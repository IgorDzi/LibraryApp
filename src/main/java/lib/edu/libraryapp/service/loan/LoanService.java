package lib.edu.libraryapp.service.loan;

import lib.edu.libraryapp.controller.dto.loan.BeginLoanDto;
import lib.edu.libraryapp.controller.dto.loan.BeginLoanResponseDto;
import lib.edu.libraryapp.controller.dto.loan.GetLoanDto;
import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import lib.edu.libraryapp.infrastructure.entity.LoanEntity;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;
import lib.edu.libraryapp.infrastructure.repository.BookRepository;
import lib.edu.libraryapp.infrastructure.repository.LoanRepository;
import lib.edu.libraryapp.infrastructure.repository.UserRepository;
import lib.edu.libraryapp.service.book.error.BookNotFoundException;
import lib.edu.libraryapp.service.loan.error.LoanAlreadyEndedException;
import lib.edu.libraryapp.service.loan.error.LoanNotFoundException;
import lib.edu.libraryapp.service.user.error.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    @Autowired
    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<GetLoanDto> getAll(){
        var loans = loanRepository.findAll();
        return loans.stream().map((loanEntity -> new GetLoanDto(
                loanEntity.getId(),
                loanEntity.getBook(),
                loanEntity.getUser(),
                loanEntity.getLoanDate(),
                loanEntity.getDays(),
                loanEntity.getReturnDate()
        ))).collect(Collectors.toList());
    }

    public GetLoanDto getOne(long id){
        var loanEntity = loanRepository.findById(id).orElseThrow(() -> LoanNotFoundException.create(id));
        return  new GetLoanDto(
                loanEntity.getId(),
                loanEntity.getBook(),
                loanEntity.getUser(),
                loanEntity.getLoanDate(),
                loanEntity.getDays(),
                loanEntity.getReturnDate());
    }

    @Transactional
    public BeginLoanResponseDto beginLoan(BeginLoanDto loan){
        // Find the associated book and user entities
        BookEntity book = bookRepository.findById(loan.getBook().getId())
                .orElseThrow(() -> BookNotFoundException.create(loan.getBook().getId()));

        UserEntity user = userRepository.findById(loan.getUser().getId())
                .orElseThrow(() -> UserNotFoundException.create(loan.getUser().getId()));

        LoanEntity loanEntity = new LoanEntity();
        loanEntity.setBook(book);
        loanEntity.setUser(user);
        loanEntity.setLoanDate(loan.getLoanDate());
        loanEntity.setDays(loan.getDays());

        LoanEntity newLoan = loanRepository.save(loanEntity);
        book.setAvailableCopies(book.getAvailableCopies()-1);
        bookRepository.save(book);
        String returnDueDate = LocalDate.parse(loanEntity.getLoanDate()).plusDays(loanEntity.getDays()).toString();
        return new BeginLoanResponseDto(newLoan.getId(),
                newLoan.getBook(),
                newLoan.getUser(),
                newLoan.getLoanDate(),
                returnDueDate);
    }

    public GetLoanDto endLoan(long id){
        var loanEntity = loanRepository.findById(id).orElseThrow(() -> LoanNotFoundException.create(id));
        if (loanEntity.getReturnDate() != null){
            throw LoanAlreadyEndedException.create(id);
        }
        loanEntity.setReturnDate(LocalDate.now().toString());
        loanRepository.save(loanEntity);
        BookEntity book = loanEntity.getBook();
        book.setAvailableCopies(book.getAvailableCopies()+1);
        bookRepository.save(book);
        return new GetLoanDto(
                loanEntity.getId(),
                loanEntity.getBook(),
                loanEntity.getUser(),
                loanEntity.getLoanDate(),
                loanEntity.getDays(),
                loanEntity.getReturnDate());
    }
}

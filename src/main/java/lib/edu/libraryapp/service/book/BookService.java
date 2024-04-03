package lib.edu.libraryapp.service.book;


import lib.edu.libraryapp.controller.dto.book.CreateBookDto;
import lib.edu.libraryapp.controller.dto.book.CreateBookResponseDto;
import lib.edu.libraryapp.controller.dto.book.GetBookDto;
import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import lib.edu.libraryapp.infrastructure.repository.BookRepository;
import lib.edu.libraryapp.service.book.error.BookAlreadyExistsException;
import lib.edu.libraryapp.service.book.error.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<GetBookDto> getAll(){
        var books = bookRepository.findAll();
        return  books.stream().map((book -> new GetBookDto(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getPublicationYear(),
                book.getAvailableCopies() > 0))).collect(Collectors.toList());
    }
    public GetBookDto getOne(long id){
        var book = bookRepository.findById(id).orElseThrow(() -> BookNotFoundException.create(id));
        return new GetBookDto(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getPublicationYear(),
                book.getAvailableCopies() > 0);
    }
    public CreateBookResponseDto create(CreateBookDto book){
        Optional<BookEntity> existingBook = bookRepository.findByIsbn(book.getIsbn());
        if (existingBook.isPresent()){
            throw BookAlreadyExistsException.create(book.getIsbn());
        }
        var bookEntity = new BookEntity();
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setPublisher(book.getPublisher());
        bookEntity.setAvailableCopies(book.getAvailableCopies());
        bookEntity.setPublicationYear(book.getPublicationYear());
        var newBook =  bookRepository.save(bookEntity);
        return new CreateBookResponseDto(newBook.getId(), newBook.getIsbn(), newBook.getTitle(), newBook.getAuthor(), newBook.getPublisher(), newBook.getPublicationYear(), newBook.getAvailableCopies());
    }

    public void delete(long id){
        if(!bookRepository.existsById(id)){
            throw BookNotFoundException.create(id);
        }
        bookRepository.deleteById(id);
    }
}

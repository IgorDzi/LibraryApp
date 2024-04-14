package lib.edu.libraryapp.service.book;


import lib.edu.libraryapp.controller.dto.book.CreateBookDto;
import lib.edu.libraryapp.controller.dto.book.CreateBookResponseDto;
import lib.edu.libraryapp.controller.dto.book.GetBookDto;
import lib.edu.libraryapp.controller.dto.book.SearchForBookDto;
import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import lib.edu.libraryapp.infrastructure.repository.BookRepository;
import lib.edu.libraryapp.service.book.error.BookAlreadyExistsException;
import lib.edu.libraryapp.service.book.error.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static lib.edu.libraryapp.service.book.BookSpecifications.buildSpecificationFromDto;

/**
 * The type Book service.
 */
@Service
public class BookService {
    private final BookRepository bookRepository;

    /**
     * Instantiates a new Book service.
     *
     * @param bookRepository the book repository
     */
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Get all list.
     *
     * @return the list
     */
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

    /**
     * Get one get book dto.
     *
     * @param id the id
     * @return the get book dto
     */
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

    /**
     * Search books list.
     *
     * @param searchForBookDto the search for book dto
     * @return the list
     */
    public List<GetBookDto> searchBooks(SearchForBookDto searchForBookDto) {
        List<BookEntity> books = bookRepository.findAll(buildSpecificationFromDto(searchForBookDto));
        return  books.stream().map((book -> new GetBookDto(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getPublicationYear(),
                book.getAvailableCopies() > 0))).collect(Collectors.toList());
    }

    /**
     * Create create book response dto.
     *
     * @param book the book
     * @return the create book response dto
     */
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

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(long id){
        if(!bookRepository.existsById(id)){
            throw BookNotFoundException.create(id);
        }
        bookRepository.deleteById(id);
    }
}

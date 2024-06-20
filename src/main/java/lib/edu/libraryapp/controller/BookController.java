package lib.edu.libraryapp.controller;

import lib.edu.libraryapp.controller.dto.book.CreateBookDto;
import lib.edu.libraryapp.controller.dto.book.CreateBookResponseDto;
import lib.edu.libraryapp.controller.dto.book.GetBookDto;
import lib.edu.libraryapp.controller.dto.book.SearchForBookDto;
import lib.edu.libraryapp.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Book controller.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    /**
     * Instantiates a new Book controller.
     *
     * @param bookService the book service
     */
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Gets all books.
     *
     * @return the all books
     */
    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN', 'READER')")
    public List<GetBookDto> getAllBooks() {
        return bookService.getAll();
    }

    /**
     * Get book .
     *
     * @param id the id
     * @return the get book dto
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'READER')")
    public GetBookDto getOne(@PathVariable long id){
        return bookService.getOne(id);
    }

    /**
     * Search books from criteria.
     *
     * @param search the search criteria
     * @return the response entity
     */
    @PostMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN', 'READER')")
    public ResponseEntity<List<GetBookDto>> searchBooks(@RequestBody SearchForBookDto search) {
        List<GetBookDto> books = bookService.searchBooks(search);
        return ResponseEntity.ok(books);
    }


    /**
     * Create book entity.
     *
     * @param book the book
     * @return the response entity
     */
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CreateBookResponseDto> create(@RequestBody CreateBookDto book) {
        var newBook = bookService.create(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    /**
     * Delete book entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

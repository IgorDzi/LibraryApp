package lib.edu.libraryapp.controller;

import lib.edu.libraryapp.controller.dto.book.CreateBookDto;
import lib.edu.libraryapp.controller.dto.book.CreateBookResponseDto;
import lib.edu.libraryapp.controller.dto.book.GetBookDto;
import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import lib.edu.libraryapp.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    @PreAuthorize("permitAll()")
    public List<GetBookDto> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public GetBookDto getOne(@PathVariable long id){
        return bookService.getOne(id);
    }
    @GetMapping("/search")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<GetBookDto>> searchBooks(@RequestParam(required = false) String title,
                                                        @RequestParam(required = false) String author,
                                                        @RequestParam(required = false) String publisher,
                                                        @RequestParam(required = false) Integer publicationYear) {
        List<GetBookDto> books = bookService.searchBooks(title, author, publisher, publicationYear);
        return ResponseEntity.ok(books);
    }




    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CreateBookResponseDto> create(@RequestBody CreateBookDto book) {
        var newBook = bookService.create(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

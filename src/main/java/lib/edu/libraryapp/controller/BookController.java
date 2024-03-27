package lib.edu.libraryapp.controller;

import lib.edu.libraryapp.controller.dto.book.CreateBookDto;
import lib.edu.libraryapp.controller.dto.book.CreateBookResponseDto;
import lib.edu.libraryapp.controller.dto.book.GetBookDto;
import lib.edu.libraryapp.service.BookService;
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
    @PreAuthorize("hasAnyRole()")
    public List<GetBookDto> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole()")
    public GetBookDto getOne(@PathVariable long id){
        return bookService.getOne(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<CreateBookResponseDto> create(@RequestBody CreateBookDto book) {
        var newBook = bookService.create(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Void> delete(@PathVariable long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

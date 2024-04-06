package lib.edu.libraryapp.service.book.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * The type Book not found exception.
 */
public class BookNotFoundException extends RuntimeException{
    private BookNotFoundException(String message) {
        super(message);
    }

    /**
     * Create response status exception.
     *
     * @param book the book
     * @return the response status exception
     */
    public static ResponseStatusException create(long book){
        BookNotFoundException exception = new BookNotFoundException(String.format("Book with id: %s not found.",book));
        return new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(),exception);

    }
}

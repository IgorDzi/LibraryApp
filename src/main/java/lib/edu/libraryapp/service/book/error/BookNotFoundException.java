package lib.edu.libraryapp.service.book.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookNotFoundException extends RuntimeException{
    private BookNotFoundException(String message) {
        super(message);
    }

    public static ResponseStatusException create(long book){
        BookNotFoundException exception = new BookNotFoundException(String.format("Book with id: %s not found.",book));
        return new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(),exception);

    }
}

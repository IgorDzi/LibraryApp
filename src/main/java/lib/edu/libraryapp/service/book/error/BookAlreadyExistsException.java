package lib.edu.libraryapp.service.book.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookAlreadyExistsException extends RuntimeException{

    private BookAlreadyExistsException(String message) {
        super(message);
    }

    public static ResponseStatusException create(String isbn){
        BookAlreadyExistsException exception = new BookAlreadyExistsException(String.format("Book wiht ISBN: %s already exists.", isbn));
        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }
}

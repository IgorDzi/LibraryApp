package lib.edu.libraryapp.service.user.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends  RuntimeException{
    private UserNotFoundException(String message) {
        super(message);
    }

    public static ResponseStatusException create(long id) {
        UserNotFoundException exception = new UserNotFoundException(String.format("User with id: %s not found.", id));
        return new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage(), exception);
    }
    public static ResponseStatusException create(String username) {
        UserNotFoundException exception = new UserNotFoundException(String.format("User with username: %s not found.", username));
        return new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage(), exception);
    }
}

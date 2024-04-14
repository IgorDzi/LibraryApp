package lib.edu.libraryapp.service.auth.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * The type User already exists exception.
 */
public class UserAlreadyExistsException extends  RuntimeException{
    private UserAlreadyExistsException(String message) {
        super(message);
    }

    /**
     * Create response status exception.
     *
     * @param username the username
     * @return the response status exception
     */
    public static ResponseStatusException create(String username) {
        UserAlreadyExistsException exception = new UserAlreadyExistsException(String.format("User with username: %s already exists.", username));
        return new ResponseStatusException(HttpStatus.CONFLICT,exception.getMessage(), exception);
    }
}

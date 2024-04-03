package lib.edu.libraryapp.service.auth.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class WrongUsernameOrPasswordException extends RuntimeException{
    private WrongUsernameOrPasswordException(String message) {
        super(message);
    }

    public static ResponseStatusException create(){
        WrongUsernameOrPasswordException exception = new WrongUsernameOrPasswordException("Wrong username or password!");
        return new ResponseStatusException(HttpStatus.UNAUTHORIZED, exception.getMessage(),exception);
    }
}

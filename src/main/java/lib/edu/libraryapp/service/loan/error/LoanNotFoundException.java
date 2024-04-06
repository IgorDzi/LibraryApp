package lib.edu.libraryapp.service.loan.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


/**
 * The type Loan not found exception.
 */
public class LoanNotFoundException extends  RuntimeException{
    private LoanNotFoundException(String message) {
        super(message);
    }

    /**
     * Create response status exception.
     *
     * @param id the id
     * @return the response status exception
     */
    public static ResponseStatusException create(long id) {
        LoanNotFoundException exception = new LoanNotFoundException(String.format("Loan with id: %s not found.", id));
        return new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage(), exception);
    }
}

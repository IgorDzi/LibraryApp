package lib.edu.libraryapp.service.loan.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


/**
 * The type Loan already ended exception.
 */
public class LoanAlreadyEndedException extends  RuntimeException{
    private LoanAlreadyEndedException(String message) {
        super(message);
    }

    /**
     * Create response status exception.
     *
     * @param id the id
     * @return the response status exception
     */
    public static ResponseStatusException create(long id) {
        LoanAlreadyEndedException exception = new LoanAlreadyEndedException(String.format("Loan with id: %s has already ended.", id));
        return new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage(), exception);
    }
}
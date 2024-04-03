package lib.edu.libraryapp.service.loan.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class LoanAlreadyEndedException extends  RuntimeException{
    private LoanAlreadyEndedException(String message) {
        super(message);
    }

    public static ResponseStatusException create(long id) {
        LoanAlreadyEndedException exception = new LoanAlreadyEndedException(String.format("Loan with id: %s has already ended.", id));
        return new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage(), exception);
    }
}
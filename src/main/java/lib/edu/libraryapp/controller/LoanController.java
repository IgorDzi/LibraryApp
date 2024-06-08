package lib.edu.libraryapp.controller;

import lib.edu.libraryapp.controller.dto.loan.BeginLoanDto;
import lib.edu.libraryapp.controller.dto.loan.BeginLoanResponseDto;
import lib.edu.libraryapp.controller.dto.loan.GetLoanDto;
import lib.edu.libraryapp.service.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * The type Loan controller.
 */
@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    /**
     * Instantiates a new Loan controller.
     *
     * @param loanService the loan service
     */
    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    /**
     * Gets all loans.
     *
     * @return the all
     */
    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public List<GetLoanDto> getAll() {
        return loanService.getAll();
    }

    /**
     * Get loan.
     *
     * @param id the id
     * @return the get loan dto
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public GetLoanDto getOne(@PathVariable long id){
        return loanService.getOne(id);
    }

    /**
     * Begin loan.
     *
     * @param beginLoanDto the begin loan dto
     * @return the begin loan response dto
     */
    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public BeginLoanResponseDto beginLoan(@RequestBody BeginLoanDto beginLoanDto){
        return loanService.beginLoan(beginLoanDto);
    }

    /**
     * End loan.
     *
     * @param id the id
     * @return the get loan dto
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public GetLoanDto endLoan(@PathVariable long id){
        return loanService.endLoan(id);
    }

    /**
     * Get user loans list.
     *
     * @param principal the principal
     * @return the list of user loans
     */
    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('READER')")
    public List<GetLoanDto> getUserLoans(Principal principal){
        String username = principal.getName();
        return loanService.getUserLoans(username);

    }

}

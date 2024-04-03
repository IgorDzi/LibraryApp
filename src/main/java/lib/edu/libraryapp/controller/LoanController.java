package lib.edu.libraryapp.controller;

import lib.edu.libraryapp.controller.dto.loan.BeginLoanDto;
import lib.edu.libraryapp.controller.dto.loan.BeginLoanResponseDto;
import lib.edu.libraryapp.controller.dto.loan.GetLoanDto;
import lib.edu.libraryapp.service.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public List<GetLoanDto> getAll() {
        return loanService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public GetLoanDto getOne(@PathVariable long id){
        return loanService.getOne(id);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public BeginLoanResponseDto beginLoan(@RequestBody BeginLoanDto beginLoanDto){
        return loanService.beginLoan(beginLoanDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public GetLoanDto endLoan(@PathVariable long id){
        return loanService.endLoan(id);
    }

}

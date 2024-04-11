package lib.edu.libraryapp.controller;


import lib.edu.libraryapp.controller.dto.auth.*;
import lib.edu.libraryapp.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * The type Auth controller.
 */
@RestController
@RequestMapping("/api/auth")

public class AuthController {

    private final AuthService authService;

    /**
     * Instantiates a new Auth controller.
     *
     * @param authService the auth service
     */
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Register a new user.
     *
     * @param registerDto the register dto
     * @return the response entity
     */
    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RegisterResponseDto> register(@Validated @RequestBody RegisterDto registerDto){
        RegisterResponseDto responseDto = authService.register(registerDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

    }

    /**
     * Login user.
     *
     * @param loginDto the login dto
     * @return the response entity
     */
    @PostMapping("/login")
    @PreAuthorize("hasAnyRole('ADMIN', 'READER')")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto){
       LoginResponseDto responseDto = authService.login(loginDto);
       return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PostMapping("/update-password")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UpdatePasswordResponseDto> update(@RequestBody UpdatePasswordDto updateFrom){
        UpdatePasswordResponseDto response = authService.updatePassword(updateFrom);
        if (response.getSuccess()){
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else
            return new ResponseEntity<>(response,HttpStatus.NOT_MODIFIED) ;
    }


}

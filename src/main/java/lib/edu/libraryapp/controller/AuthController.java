package lib.edu.libraryapp.controller;


import lib.edu.libraryapp.controller.dto.auth.LoginDto;
import lib.edu.libraryapp.controller.dto.auth.LoginResponseDto;
import lib.edu.libraryapp.controller.dto.auth.RegisterDto;
import lib.edu.libraryapp.controller.dto.auth.RegisterResponseDto;
import lib.edu.libraryapp.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PreAuthorize("permitAll()")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto){
       LoginResponseDto responseDto = authService.login(loginDto);
       return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}

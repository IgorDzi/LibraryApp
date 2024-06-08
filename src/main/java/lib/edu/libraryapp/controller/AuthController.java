package lib.edu.libraryapp.controller;


import lib.edu.libraryapp.controller.dto.auth.*;
import lib.edu.libraryapp.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


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
       return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param updateFrom the update from
     * @return the response entity
     */
    @PostMapping("/update-password")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UpdatePasswordResponseDto> update(@RequestBody UpdatePasswordDto updateFrom){
        UpdatePasswordResponseDto response = authService.updatePassword(updateFrom);
        if (response.getSuccess()){
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else
            return new ResponseEntity<>(response,HttpStatus.NOT_MODIFIED) ;
    }
    @GetMapping("/get-role")
    @PreAuthorize("hasAnyRole('ADMIN', 'READER')")
    public ResponseEntity<String> getRole(Principal principal) {
        String userRole = authService.getRole(principal.getName());
        return new ResponseEntity<>(userRole, HttpStatus.OK);
    }

    @GetMapping("/get-username")
    @PreAuthorize("hasAnyRole('ADMIN', 'READER')")
    public ResponseEntity<String> getUsernameByUserId(@RequestParam long id) {
        String username = authService.getUsername(id);
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

    @GetMapping("/get-role-by-id")
    @PreAuthorize("hasAnyRole('ADMIN', 'READER')")
    public ResponseEntity<String> getRoleByUserId(@RequestParam long id) {
        String userRole = authService.getRoleById(id);
        return new ResponseEntity<>(userRole, HttpStatus.OK);
    }
}

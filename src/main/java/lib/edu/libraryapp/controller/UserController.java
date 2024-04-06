package lib.edu.libraryapp.controller;



import lib.edu.libraryapp.controller.dto.user.GetUserDto;
import lib.edu.libraryapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Gets all users.
     *
     * @return the all
     */
    @GetMapping()
    public List<GetUserDto> getAll() {
        return userService.getAll();
    }

    /**
     * Gets one user.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping("/{id}")
    public GetUserDto getOne(@PathVariable long id) {
        return userService.getOne(id);
    }

    /**
     * Delete user
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('ADMIN', 'READER')")
    public ResponseEntity<GetUserDto> getMe(Principal principal) {
        GetUserDto userDto = userService.getByUsername(principal.getName());
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
}

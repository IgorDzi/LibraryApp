package lib.edu.libraryapp.controller;



import lib.edu.libraryapp.controller.dto.user.GetUserDto;
import lib.edu.libraryapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<GetUserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public GetUserDto getOne(@PathVariable long id) {
        return userService.getOne(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

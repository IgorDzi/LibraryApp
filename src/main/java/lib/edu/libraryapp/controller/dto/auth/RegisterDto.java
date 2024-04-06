package lib.edu.libraryapp.controller.dto.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lib.edu.libraryapp.commonTypes.UserRole;


public class RegisterDto {

    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")

    private String password;

    @NotNull(message = "Role is required")
    private UserRole role;
    @NotBlank(message = "Email is required")
    @Email
    private String email;
    @NotBlank(message = "Full name is required")
    private String fullName;

    public RegisterDto(String username, String password, UserRole role, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.fullName = fullName;
    }

    public RegisterDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

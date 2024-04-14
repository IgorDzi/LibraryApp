package lib.edu.libraryapp.controller.dto.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lib.edu.libraryapp.commonTypes.UserRole;


/**
 * The type Register dto.
 */
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

    /**
     * Instantiates a new Register dto.
     *
     * @param username the username
     * @param password the password
     * @param role     the role
     * @param email    the email
     * @param fullName the full name
     */
    public RegisterDto(String username, String password, UserRole role, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.fullName = fullName;
    }

    /**
     * Instantiates a new Register dto.
     */
    public RegisterDto() {
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets full name.
     *
     * @param fullName the full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}

package lib.edu.libraryapp.controller.dto.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * The type Login dto.
 */
public class LoginDto {

    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;

    /**
     * Instantiates a new Login dto.
     *
     * @param username the username
     * @param password the password
     */
    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new Login dto.
     */
    public LoginDto() {
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
}

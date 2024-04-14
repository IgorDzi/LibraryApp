package lib.edu.libraryapp.controller.dto.auth;

/**
 * The type Update password dto.
 */
public class UpdatePasswordDto {
    private String username;

    private String password;

    /**
     * Instantiates a new Update password dto.
     *
     * @param username the username
     * @param password the password
     */
    public UpdatePasswordDto(String username, String password) {
        this.username = username;
        this.password = password;
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


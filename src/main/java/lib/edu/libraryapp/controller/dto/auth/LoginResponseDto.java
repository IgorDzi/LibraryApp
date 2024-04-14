package lib.edu.libraryapp.controller.dto.auth;

/**
 * The type Login response dto.
 */
public class LoginResponseDto {
    private String token;

    /**
     * Instantiates a new Login response dto.
     *
     * @param token the token
     */
    public LoginResponseDto(String token) {
        this.token = token;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token;
    }
}

package lib.edu.libraryapp.controller.dto.auth;

/**
 * The type Update password response dto.
 */
public class UpdatePasswordResponseDto {
    private String username;

    private boolean success;

    /**
     * Instantiates a new Update password response dto.
     *
     * @param username the username
     * @param success  the success
     */
    public UpdatePasswordResponseDto(String username, boolean success) {
        this.username = username;
        this.success = success;
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
     * Gets success.
     *
     * @return the success
     */
    public boolean getSuccess() {
        return success;
    }

    /**
     * Sets success.
     *
     * @param success the success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }
}

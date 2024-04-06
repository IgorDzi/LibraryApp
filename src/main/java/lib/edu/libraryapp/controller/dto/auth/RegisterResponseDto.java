package lib.edu.libraryapp.controller.dto.auth;

import lib.edu.libraryapp.commonTypes.UserRole;

/**
 * The type Register response dto.
 */
public class RegisterResponseDto {

    private String username;
    private UserRole role;
    private String email;
    private long userId;

    /**
     * Instantiates a new Register response dto.
     *
     * @param username the username
     * @param role     the role
     * @param email    the email
     * @param userId   the user id
     */
    public RegisterResponseDto(String username, UserRole role, String email, long userId) {
        this.username = username;
        this.role = role;
        this.email = email;
        this.userId = userId;
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
     * Gets user id.
     *
     * @return the user id
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(long userId) {
        this.userId = userId;
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

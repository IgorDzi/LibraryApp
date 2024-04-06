package lib.edu.libraryapp.controller.dto.user;

/**
 * The type Get user dto.
 */
public class GetUserDto {

    private long id;
    private  String email;
    private String fullName;

    /**
     * Instantiates a new Get user dto.
     *
     * @param id       the id
     * @param email    the email
     * @param fullName the full name
     */
    public GetUserDto(long id, String email, String fullName) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
    }

    /**
     * Instantiates a new Get user dto.
     */
    public GetUserDto() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
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
}

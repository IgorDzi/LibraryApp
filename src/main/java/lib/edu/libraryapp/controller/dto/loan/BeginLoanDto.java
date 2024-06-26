package lib.edu.libraryapp.controller.dto.loan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;

/**
 * The type Begin loan dto.
 */
public class BeginLoanDto {
    @NotBlank(message = "Book is required")
    private long book;
    @NotBlank(message = "User is required")
    private long user;

    @NotNull(message = "Number of days is required")
    private int days;

    /**
     * Instantiates a new Begin loan dto.
     *
     * @param book the book
     * @param user the user
     * @param days the days
     */
    public BeginLoanDto(long book, long user, int days) {
        this.book = book;
        this.user = user;
        this.days = days;
    }

    /**
     * Instantiates a new Begin loan dto.
     */
    public BeginLoanDto() {
    }

    /**
     * Gets book.
     *
     * @return the book
     */
    public long getBook() {
        return book;
    }

    /**
     * Sets book.
     *
     * @param book the book
     */
    public void setBook(long book) {
        this.book = book;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public long getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(long user) {
        this.user = user;
    }

    /**
     * Gets days.
     *
     * @return the days
     */
    public int getDays() {
        return days;
    }

    /**
     * Sets days.
     *
     * @param days the days
     */
    public void setDays(int days) {
        this.days = days;
    }
}

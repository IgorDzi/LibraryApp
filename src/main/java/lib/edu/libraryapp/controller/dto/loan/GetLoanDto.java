package lib.edu.libraryapp.controller.dto.loan;

import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;

/**
 * The type Get loan dto.
 */
public class GetLoanDto {

    private long id;

    private BookEntity book;

    private UserEntity user;

    private String loanDate;
    private int days;
    private String returnDate;

    /**
     * Instantiates a new Get loan dto.
     *
     * @param id         the id
     * @param book       the book
     * @param user       the user
     * @param loanDate   the loan date
     * @param days       the days
     * @param returnDate the return date
     */
    public GetLoanDto(long id, BookEntity book, UserEntity user, String loanDate, int days, String returnDate) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
        this.days = days;
        this.returnDate = returnDate;
    }

    /**
     * Instantiates a new Get loan dto.
     */
    public GetLoanDto() {
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
     * Gets book.
     *
     * @return the book
     */
    public long getBook() {
        return book.getId();
    }

    /**
     * Sets book.
     *
     * @param book the book
     */
    public void setBook(BookEntity book) {
        this.book = book;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public long getUser() {
        return user.getId();
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }

    /**
     * Gets loan date.
     *
     * @return the loan date
     */
    public String getLoanDate() {
        return loanDate;
    }

    /**
     * Sets loan date.
     *
     * @param loanDate the loan date
     */
    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
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

    /**
     * Gets return date.
     *
     * @return the return date
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * Sets return date.
     *
     * @param returnDate the return date
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

}

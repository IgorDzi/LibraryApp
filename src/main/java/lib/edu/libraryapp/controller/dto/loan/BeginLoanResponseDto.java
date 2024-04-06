package lib.edu.libraryapp.controller.dto.loan;

import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;

/**
 * The type Begin loan response dto.
 */
public class BeginLoanResponseDto {

    private long id;

    private BookEntity book;

    private UserEntity user;

    private String loanDate;
    private String returnDueDate;

    /**
     * Instantiates a new Begin loan response dto.
     *
     * @param id            the id
     * @param book          the book
     * @param user          the user
     * @param loanDate      the loan date
     * @param returnDueDate the return due date
     */
    public BeginLoanResponseDto(long id, BookEntity book, UserEntity user, String loanDate, String returnDueDate) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
        this.returnDueDate = returnDueDate;
    }

    /**
     * Instantiates a new Begin loan response dto.
     */
    public BeginLoanResponseDto() {
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
     * Gets return due date.
     *
     * @return the return due date
     */
    public String getReturnDueDate() {
        return returnDueDate;
    }

    /**
     * Sets return due date.
     *
     * @param returnDueDate the return due date
     */
    public void setReturnDueDate(String returnDueDate) {
        this.returnDueDate = returnDueDate;
    }
}

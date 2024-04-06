package lib.edu.libraryapp.infrastructure.entity;



import jakarta.persistence.*;

/**
 * The type Loan entity.
 */
@Entity
@Table(name = "loans", schema = "library")
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Basic
    @Column(name = "loan_date")
    private String loanDate;

    @Basic
    @Column(name = "loan_period")
    private int days;

    @Basic
    @Column(name = "return_date")
    private String returnDate;

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
    public BookEntity getBook() {
        return book;
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
    public UserEntity getUser() {
        return user;
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

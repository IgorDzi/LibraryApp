package lib.edu.libraryapp.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

/**
 * The type Book entity.
 */
@Entity
@Table(name = "books", schema = "library")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "isbn", unique = true)
    private String isbn;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "author")
    private String author;

    @Basic
    @Column(name = "publisher")
    private String publisher;

    @Basic
    @Column(name = "publication_year")
    private int publicationYear;

    @Basic
    @Column(name = "available_copies")
    private int availableCopies;


    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    @Column(name = "loans")
    private List<LoanEntity> loanList;

    /**
     * Gets loan list.
     *
     * @return the loan list
     */
    public List<LoanEntity> getLoanList() {
        return loanList;
    }

    /**
     * Sets loan list.
     *
     * @param loanList the loan list
     */
    public void setLoanList(List<LoanEntity> loanList) {
        this.loanList = loanList;
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
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets isbn.
     *
     * @param isbn the isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets publisher.
     *
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets publisher.
     *
     * @param publisher the publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets publication year.
     *
     * @return the publication year
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Sets publication year.
     *
     * @param publicationYear the publication year
     */
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * Gets available copies.
     *
     * @return the available copies
     */
    public int getAvailableCopies() {
        return availableCopies;
    }

    /**
     * Sets available copies.
     *
     * @param availableCopies the available copies
     */
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}

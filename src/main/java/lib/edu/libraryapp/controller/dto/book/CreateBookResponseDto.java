package lib.edu.libraryapp.controller.dto.book;

/**
 * The type Create book response dto.
 */
public class CreateBookResponseDto {
    private long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private int availableCopies;

    /**
     * Instantiates a new Create book response dto.
     *
     * @param id              the id
     * @param isbn            the isbn
     * @param title           the title
     * @param author          the author
     * @param publisher       the publisher
     * @param publicationYear the publication year
     * @param availableCopies the available copies
     */
    public CreateBookResponseDto(long id, String isbn, String title, String author, String publisher, int publicationYear, int availableCopies) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.availableCopies = availableCopies;
    }

    /**
     * Instantiates a new Create book response dto.
     */
    public CreateBookResponseDto() {
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

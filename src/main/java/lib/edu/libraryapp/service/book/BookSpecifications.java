package lib.edu.libraryapp.service.book;

import lib.edu.libraryapp.controller.dto.book.SearchForBookDto;
import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import org.springframework.data.jpa.domain.Specification;


/**
 * The type Book specifications.
 */
public class BookSpecifications {

    /**
     * Has isbn specification.
     *
     * @param isbn the isbn
     * @return the specification
     */
    public static Specification<BookEntity> hasIsbn(String isbn) {
        return (root, query, cb) -> isbn == null ? cb.conjunction() : cb.equal(root.get("isbn"), isbn);
    }

    /**
     * Title contains specification.
     *
     * @param title the title
     * @return the specification
     */
    public static Specification<BookEntity> titleContains(String title) {
        return (root, query, cb) -> title == null ? cb.conjunction() : cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    /**
     * Author contains specification.
     *
     * @param author the author
     * @return the specification
     */
    public static Specification<BookEntity> authorContains(String author) {
        return (root, query, cb) -> author == null ? cb.conjunction() : cb.like(cb.lower(root.get("author")), "%" + author.toLowerCase() + "%");
    }

    /**
     * Publisher contains specification.
     *
     * @param publisher the publisher
     * @return the specification
     */
    public static Specification<BookEntity> publisherContains(String publisher) {
        return (root, query, cb) -> publisher == null ? cb.conjunction() : cb.like(cb.lower(root.get("publisher")), "%" + publisher.toLowerCase() + "%");
    }

    /**
     * Publication year is specification.
     *
     * @param publicationYear the publication year
     * @return the specification
     */
    public static Specification<BookEntity> publicationYearIs(Integer publicationYear) {
        return (root, query, cb) -> publicationYear == null ? cb.conjunction() : cb.equal(root.get("publicationYear"), publicationYear);
    }

    /**
     * Is available specification.
     *
     * @param isAvailable the is available
     * @return the specification
     */
    public static Specification<BookEntity> isAvailable(boolean isAvailable) {
        return (root, query, cb) -> {
            if (isAvailable) {
                return cb.greaterThan(root.get("availableCopies"), 0);
            } else {
                return cb.conjunction();
            }
        };
    }

    /**
     * Build specification from dto specification.
     *
     * @param searchDto the search dto
     * @return the specification
     */
    public static Specification<BookEntity> buildSpecificationFromDto(SearchForBookDto searchDto) {
        Specification<BookEntity> spec = Specification.where(null);

        if (searchDto.getIsbn() != null && !searchDto.getIsbn().isEmpty()) {
            spec = spec.and(BookSpecifications.hasIsbn(searchDto.getIsbn()));
        }
        if (searchDto.getTitle() != null && !searchDto.getTitle().isEmpty()) {
            spec = spec.and(BookSpecifications.titleContains(searchDto.getTitle()));
        }
        if (searchDto.getAuthor() != null && !searchDto.getAuthor().isEmpty()) {
            spec = spec.and(BookSpecifications.authorContains(searchDto.getAuthor()));
        }
        if (searchDto.getPublisher() != null && !searchDto.getPublisher().isEmpty()) {
            spec = spec.and(BookSpecifications.publisherContains(searchDto.getPublisher()));
        }

        if (searchDto.getPublicationYear() > 0) {
            spec = spec.and(BookSpecifications.publicationYearIs(searchDto.getPublicationYear()));
        }
        spec = spec.and(BookSpecifications.isAvailable(searchDto.isAvailable()));
        return spec;
    }
}


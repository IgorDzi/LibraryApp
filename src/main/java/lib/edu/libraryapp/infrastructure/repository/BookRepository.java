package lib.edu.libraryapp.infrastructure.repository;

import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * The interface Book repository.
 */
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity> {

    /**
     * Find by isbn optional.
     *
     * @param Isbn the isbn
     * @return the optional
     */
    Optional<BookEntity> findByIsbn(String Isbn);

}

package lib.edu.libraryapp.infrastructure.repository;

import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findByIsbn(String Isbn);
}

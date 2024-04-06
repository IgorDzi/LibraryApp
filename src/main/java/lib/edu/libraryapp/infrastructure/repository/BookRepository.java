package lib.edu.libraryapp.infrastructure.repository;

import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findByIsbn(String Isbn);

    @Query("SELECT b FROM BookEntity b WHERE " +
            "(b.title LIKE %:title%) AND " +
            "(b.author LIKE %:author%) AND " +
            "(b.publisher LIKE %:publisher%) AND " +
            "(b.publicationYear = :publicationYear)")
    List<BookEntity> findByOptionalCriteria(@Param("title") String title,
                                      @Param("author") String author,
                                      @Param("publisher") String publisher,
                                      @Param("publicationYear") Integer publicationYear);


}

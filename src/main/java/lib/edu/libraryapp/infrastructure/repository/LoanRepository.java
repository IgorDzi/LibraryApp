package lib.edu.libraryapp.infrastructure.repository;


import lib.edu.libraryapp.infrastructure.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Loan repository.
 */
@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, Long> {
}

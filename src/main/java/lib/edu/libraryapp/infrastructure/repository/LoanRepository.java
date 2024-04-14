package lib.edu.libraryapp.infrastructure.repository;


import lib.edu.libraryapp.infrastructure.entity.LoanEntity;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Loan repository.
 */
@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, Long> {

    List<LoanEntity> findAllByUserId(long userId);
}

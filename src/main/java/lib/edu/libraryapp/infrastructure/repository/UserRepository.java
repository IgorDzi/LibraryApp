package lib.edu.libraryapp.infrastructure.repository;

import lib.edu.libraryapp.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

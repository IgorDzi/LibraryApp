package lib.edu.libraryapp.infrastructure.repository;

import lib.edu.libraryapp.infrastructure.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Auth repository.
 */
@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Long> {
    /**
     * Find by username optional.
     *
     * @param username the username
     * @return the optional
     */
    Optional<AuthEntity> findByUsername(String username);
}

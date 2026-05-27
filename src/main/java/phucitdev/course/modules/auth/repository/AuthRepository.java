package phucitdev.course.modules.auth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import phucitdev.course.modules.auth.entity.Account;

import java.util.Optional;
import java.util.UUID;
public interface AuthRepository extends JpaRepository<Account, UUID> {
    boolean existsByEmail(String email);
    Optional<Account> findByEmail(String email);

}

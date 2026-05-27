package phucitdev.course.modules.auth.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import phucitdev.course.modules.auth.entity.RefreshToken;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {
    Optional<RefreshToken> findByToken(String token);
    // Lấy batch token đã expired hoặc revoked
    List<RefreshToken> findTop1000ByExpiredAtBeforeOrRevokedTrue(Date now);
    // Xóa theo danh sách id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM refresh_token WHERE id IN :ids", nativeQuery = true)
    int deleteByIds(List<UUID> ids);
}

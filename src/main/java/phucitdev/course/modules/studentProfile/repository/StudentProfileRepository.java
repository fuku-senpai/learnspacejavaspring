package phucitdev.course.modules.studentProfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phucitdev.course.modules.studentProfile.entity.StudentProfile;

import java.util.Optional;
import java.util.UUID;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, UUID> {
    Optional<StudentProfile> findByAccountId(UUID accountId);
}

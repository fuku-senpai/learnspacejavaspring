package phucitdev.course.modules.teacherProfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phucitdev.course.modules.teacherProfile.entity.TeacherProfile;

import java.util.Optional;
import java.util.UUID;

public interface TeacherProfileRepository extends JpaRepository<TeacherProfile, UUID> {
    Optional<TeacherProfile> findByAccountId(UUID accountId);
}

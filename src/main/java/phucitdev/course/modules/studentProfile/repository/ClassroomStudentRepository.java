package phucitdev.course.modules.studentProfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phucitdev.course.modules.studentProfile.entity.ClassroomStudent;

import java.util.UUID;

public interface ClassroomStudentRepository extends JpaRepository<ClassroomStudent, UUID> {
}

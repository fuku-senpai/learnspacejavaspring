package phucitdev.course.modules.snap_lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import phucitdev.course.modules.snap_lesson.entity.SnapLesson;

import java.util.UUID;

public interface SnapLessonRepository extends JpaRepository<SnapLesson, UUID> {
}

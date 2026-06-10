package phucitdev.course.modules.lessons.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phucitdev.course.modules.lessons.dto.LessonResponse;
import phucitdev.course.modules.lessons.entity.Lesson;
import java.util.List;
import java.util.UUID;
public interface LessonRepository extends JpaRepository<Lesson, UUID> {
    @Query("""
        SELECT new phucitdev.course.modules.lessons.dto.LessonResponse(
            l.id,
            l.title,
            l.lessonOrder
        )
        FROM Lesson l
        WHERE l.material.id = :materialId
        ORDER BY l.lessonOrder ASC
    """)
    List<LessonResponse> getLessonsByMaterialId(
            UUID materialId
    );
    List<Lesson> findAllByMaterialIdAndIsDeletedFalseOrderByLessonOrderAsc(UUID materialId);
}

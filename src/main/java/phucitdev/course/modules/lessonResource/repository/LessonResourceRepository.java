package phucitdev.course.modules.lessonResource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phucitdev.course.modules.lessonResource.dto.GetLessonResourceResponse;
import phucitdev.course.modules.lessonResource.entity.LessonResource;

import java.util.List;
import java.util.UUID;

public interface LessonResourceRepository extends JpaRepository<LessonResource, UUID> {
    @Query("""
    SELECT DISTINCT lr
    FROM LessonResource lr
    LEFT JOIN FETCH lr.lessonResourceUrls
    WHERE lr.lesson.id = :lessonId
""")
    List<LessonResource> getLessonResources(
            UUID lessonId
    );
}

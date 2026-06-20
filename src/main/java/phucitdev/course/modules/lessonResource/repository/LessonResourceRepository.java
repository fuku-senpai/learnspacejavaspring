package phucitdev.course.modules.lessonResource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import phucitdev.course.modules.lessonResource.entity.LessonResource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LessonResourceRepository extends JpaRepository<LessonResource, UUID> {
    @Query("""
    SELECT DISTINCT lr
    FROM LessonResource lr
    LEFT JOIN FETCH lr.lessonResourceUrls
    WHERE lr.snapLesson.id = :snapLessonId
    AND lr.isDeleted = false
""")
    List<LessonResource> getLessonResources(
            UUID snapLessonId
    );
    Optional<LessonResource> getLessonResourceById(UUID snapLessonId);
}

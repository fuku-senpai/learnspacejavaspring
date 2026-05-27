package phucitdev.course.modules.lessonVideo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phucitdev.course.modules.lessonVideo.dto.GetLessonVideoResponse;
import phucitdev.course.modules.lessonVideo.entity.LessonVideo;

import java.util.List;
import java.util.UUID;

public interface LessonVideoRepository extends JpaRepository<LessonVideo, UUID> {
    @Query("""
    SELECT new phucitdev.course.modules.lessonVideo.dto.GetLessonVideoResponse(
        lv.id,
        lv.title,
        lv.videoUrl,
        lv.createdAt
    )
    FROM LessonVideo lv
    WHERE lv.lesson.id = :lessonId
    ORDER BY lv.createdAt DESC
""")
    List<GetLessonVideoResponse> findByLessonId(UUID lessonId);
}

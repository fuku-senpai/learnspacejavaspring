package phucitdev.course.modules.snap_lessonquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import phucitdev.course.modules.lesson_quiz.dto.assignQuiz.LessonAssignedQuizResponse;
import phucitdev.course.modules.snap_lessonquiz.entity.SnapLessonQuiz;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SnapLessonQuizRepository extends JpaRepository<SnapLessonQuiz, UUID> {
    boolean
    existsBySnapLessonIdAndLessonQuizId(
            UUID snapLessonId,
            UUID lessonQuizId
    );

        @Query("""
        SELECT new phucitdev.course.modules.lesson_quiz.dto.assignQuiz.LessonAssignedQuizResponse(
            slq.id,
            q.id,
            q.title,
            q.description,
            q.quizType,
            q.durationMinutes,
            q.passScore,
            slq.required,
            slq.maxAttempts,
            slq.displayOrder
        )
        FROM SnapLessonQuiz slq
        JOIN slq.lessonQuiz q
        WHERE slq.snapLesson.id = :snapLessonId
        ORDER BY slq.displayOrder ASC,
                 slq.createdAt ASC
    """)
        List<LessonAssignedQuizResponse> getAssignedQuizzesByLesson(UUID snapLessonId);
    boolean existsBySnapLessonIdAndLessonQuizIdAndIdNot(
            UUID snapLessonId,
            UUID lessonQuizId,
            UUID id
    );
    Optional<SnapLessonQuiz> findSnapLessonQuizById(UUID snapLessonQuizId);
}

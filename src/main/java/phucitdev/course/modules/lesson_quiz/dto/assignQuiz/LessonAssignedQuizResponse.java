package phucitdev.course.modules.lesson_quiz.dto.assignQuiz;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import phucitdev.course.modules.lesson_quiz.entity.QuizType;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class LessonAssignedQuizResponse {
    private UUID snapLessonQuizId;

    private UUID lessonQuizId;

    private String title;

    private String description;

    private QuizType quizType;

    private Integer durationMinutes;

    private Integer passScore;

    private Boolean required;

    private Integer maxAttempts;

    private Integer displayOrder;
}

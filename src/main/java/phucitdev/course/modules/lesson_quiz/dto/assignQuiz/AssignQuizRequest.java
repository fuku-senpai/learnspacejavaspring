package phucitdev.course.modules.lesson_quiz.dto.assignQuiz;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class AssignQuizRequest {
    @NotNull(message = "Lesson không được để trống")
    private UUID snapLessonId;
    @NotNull(message = "Quiz không được để trống")
    private UUID lessonQuizId;
    private Boolean required = true;
    @Min(value = 1, message = "Số lần làm phải >= 1")
    private Integer maxAttempts = 1;
    private Integer displayOrder;
}


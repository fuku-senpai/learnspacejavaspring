package phucitdev.course.modules.lesson_quiz.dto.assignQuiz;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;
@Getter
@Setter
public class UpdateAssignedQuizRequest {
    @NotNull(message = "Quiz không được để trống")
    private UUID lessonQuizId;
    private Boolean required;
    @Min(value = 1, message = "Số lần làm phải >= 1")
    private Integer maxAttempts;
    private Integer displayOrder;
}
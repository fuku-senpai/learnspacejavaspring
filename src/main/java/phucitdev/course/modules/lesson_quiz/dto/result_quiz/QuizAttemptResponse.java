
package phucitdev.course.modules.lesson_quiz.dto.result_quiz;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class QuizAttemptResponse {

    private UUID submissionId;

    private Integer attemptNo;

    private Integer score;

    private Boolean passed;

    private String status;

    private LocalDateTime submittedAt;

    private List<QuestionResultResponse> questions;
}

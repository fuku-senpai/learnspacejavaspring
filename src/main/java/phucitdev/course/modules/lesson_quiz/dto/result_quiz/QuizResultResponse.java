package phucitdev.course.modules.lesson_quiz.dto.result_quiz;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizResultResponse {

    private UUID quizId;

    private String quizTitle;

    private Integer passScore;

    private List<QuizAttemptResponse> attempts;
}


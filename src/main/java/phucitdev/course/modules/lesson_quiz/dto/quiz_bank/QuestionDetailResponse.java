package phucitdev.course.modules.lesson_quiz.dto.quiz_bank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDetailResponse {

    private UUID id;

    private String content;

    private Integer points;

    private String essayAnswer;

    private List<OptionDetailResponse>
            options;
}


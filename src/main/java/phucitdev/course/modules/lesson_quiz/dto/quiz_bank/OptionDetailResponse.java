package phucitdev.course.modules.lesson_quiz.dto.quiz_bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class OptionDetailResponse {

    private UUID id;

    private String content;

    private Boolean correct;
}



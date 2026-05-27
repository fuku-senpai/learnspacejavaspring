package phucitdev.course.modules.lessons.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class LessonResponse {
    private UUID id;
    private String title;
    private Integer lessonOrder;
}
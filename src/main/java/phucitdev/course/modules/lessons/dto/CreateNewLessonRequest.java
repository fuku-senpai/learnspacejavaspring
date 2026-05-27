package phucitdev.course.modules.lessons.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewLessonRequest {
    @NotBlank(message = "Tiêu đề không được để trống!")
    private String title;

    @NotNull(message = "Thứ tự không được để trống!")
    private Integer lessonOrder;

    @NotNull(message = "Material id không được để trống!")
    private UUID materialId;

}

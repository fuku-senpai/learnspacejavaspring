package phucitdev.course.modules.lessonResource.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import phucitdev.course.modules.lessonResource.entity.ResourceType;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLessonResourceRequest {
    @NotBlank(message = "Tiêu đề không được để trống!")
    private String title;
    @NotNull(message = "Loại tài nguyên không được để trống!")
    private ResourceType type;
    private List<String> urls;
    private String note;
    private UUID snapLessonId;
}

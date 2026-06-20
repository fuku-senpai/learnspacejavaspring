package phucitdev.course.modules.lessonResource.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLessonResourceRequest {
    @NotBlank(message = "Tiêu đề không được để trống!")
    private String title;
    @Column(columnDefinition = "TEXT")
    private String note;
}

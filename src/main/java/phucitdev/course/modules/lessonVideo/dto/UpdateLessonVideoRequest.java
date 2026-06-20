package phucitdev.course.modules.lessonVideo.dto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import phucitdev.course.modules.lessonVideo.entity.VideoType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLessonVideoRequest {
    @Column(nullable = false)
    @NotBlank(message = "Tiêu đề không được để trống")
    private String title;
    @Column(nullable = false)
    @NotNull(message = "Loại không được để trống!")
    private VideoType videoType;
}

package phucitdev.course.modules.material.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaterialRequest {
    @NotBlank(message = "Tiêu đề không được để trống!")
    private String title;
    @NotBlank(message = "Mô tả không được để trống!")
    private String description;
}

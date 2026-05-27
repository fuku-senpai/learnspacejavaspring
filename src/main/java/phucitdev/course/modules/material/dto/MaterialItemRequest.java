package phucitdev.course.modules.material.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialItemRequest {
    @NotBlank(message = "Tiêu đề không được để trống!")
    private String title;
    @NotBlank(message = "Miêu tả không được để trống!")
    private String description;
}

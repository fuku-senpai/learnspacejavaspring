package phucitdev.course.modules.classroomMaterial.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDisplayOrderRequest {
    @NotNull(message = "Thứ tự không được để trống")
    private Integer displayOrder;
}

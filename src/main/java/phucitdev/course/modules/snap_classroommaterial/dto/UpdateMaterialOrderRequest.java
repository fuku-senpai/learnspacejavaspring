package phucitdev.course.modules.snap_classroommaterial.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaterialOrderRequest {
    @NotNull(message = "order không được để trống")
    private Integer order;
}

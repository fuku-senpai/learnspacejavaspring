package phucitdev.course.modules.classrooms.dto.assign;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;
@Data
public class MaterialAssignmentItem {
    @NotNull(message = "materialId không được để trống")
    private UUID materialId;
    @NotNull(message = "order không được để trống")
    private Integer order;
}

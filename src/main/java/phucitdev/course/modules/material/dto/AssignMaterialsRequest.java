package phucitdev.course.modules.material.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class    AssignMaterialsRequest {
    @NotEmpty(message = "Danh sách đề tài không được để trống")
    private List<MaterialAssignmentItem> materials;
}

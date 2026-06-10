package phucitdev.course.modules.classrooms.dto.assign;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignMaterialsRequest {
    @NotEmpty(message = "Danh sách đề tài không được để trống")
    private List<MaterialAssignmentItem> materials;
}

package phucitdev.course.modules.classroomMaterial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteClassroomMaterialRequest {
    private UUID classroomMaterialId;
}

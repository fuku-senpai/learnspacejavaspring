package phucitdev.course.modules.snap_classroommaterial.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetSnapClassroomMaterialsResponse {
    private List<SnapClassroomMaterialItemResponse> materials;
}

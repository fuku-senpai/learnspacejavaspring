package phucitdev.course.modules.snap_classroommaterial.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SnapClassroomMaterialItemResponse {
    private UUID id;
    private UUID sourceMaterialId;
    private String title;
    private String description;
    private Integer materialOrder;

    private Integer totalLessons;
}

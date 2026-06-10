package phucitdev.course.modules.snap_classroommaterial.service;

import phucitdev.course.modules.snap_classroommaterial.dto.GetSnapClassroomMaterialsResponse;
import phucitdev.course.modules.snap_classroommaterial.dto.UpdateMaterialOrderRequest;
import phucitdev.course.modules.snap_classroommaterial.dto.UpdateMaterialOrderResponse;

import java.util.UUID;

public interface SnapClassroomMaterialService {
    GetSnapClassroomMaterialsResponse getMaterialsByClassroomId(UUID classroomId);
    UpdateMaterialOrderResponse updateMaterialOrder(UUID snapclassmaterialId, UpdateMaterialOrderRequest request);
}

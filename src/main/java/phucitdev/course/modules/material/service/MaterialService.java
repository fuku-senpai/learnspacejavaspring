package phucitdev.course.modules.material.service;
import org.springframework.data.domain.Pageable;
import phucitdev.course.modules.material.dto.*;
import java.util.List;
import java.util.UUID;

public interface MaterialService {
      CreateMaterialResponse createNewMaterials(CreateNewMaterialsRequest createNewMaterialsRequest);
      GetMaterialsResponse getAllMaterials(Pageable pageable, String title);
      DeleteMaterialResponse deleteMaterialByMaterialId(UUID materialId);
    UpdateMaterialResponse updateMaterialByMaterialId(UpdateMaterialRequest updateMaterialRequest, UUID materialId);
//    UpdateMaterialResponse updateMaterial(UUID classroomId, UUID materialId, UpdateMaterialRequest request);

//    DeleteMaterialResponse deleteMaterial(UUID classroomId, UUID materialId);



//    AssignMaterialsResponse assignMaterialsToClassroom(UUID classroomId, AssignMaterialsRequest request);
//    List<GetMaterialsOfClassroom> getMaterialsByClassroomId(UUID classroomId);
}

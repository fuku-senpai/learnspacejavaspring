package phucitdev.course.modules.material.service;

import org.springframework.data.domain.Page;
import phucitdev.course.modules.material.dto.CreateMaterialRequest;
import phucitdev.course.modules.material.dto.CreateMaterialResponse;
import phucitdev.course.modules.material.dto.GetMaterialsOfClassroom;

import java.util.List;
import java.util.UUID;

public interface MaterialService {
    CreateMaterialResponse createNewMaterial(UUID classroomId, CreateMaterialRequest createMaterialRequest);
    Page<GetMaterialsOfClassroom> getMaterialsOfClassroom(UUID classroomId, int page, int size);
}

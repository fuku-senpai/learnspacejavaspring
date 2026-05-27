package phucitdev.course.modules.material.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import phucitdev.course.commo.exception.material.DuplicationException;
import phucitdev.course.commo.exception.classroom.NotFoundException;
import phucitdev.course.modules.classrooms.entity.Classroom;
import phucitdev.course.modules.classrooms.repository.ClassroomRepository;
import phucitdev.course.modules.material.dto.CreateMaterialRequest;
import phucitdev.course.modules.material.dto.CreateMaterialResponse;
import phucitdev.course.modules.material.dto.GetMaterialsOfClassroom;
import phucitdev.course.modules.material.dto.MaterialItemRequest;
import phucitdev.course.modules.material.entity.Material;
import phucitdev.course.modules.material.repository.MaterialRepository;
import phucitdev.course.modules.material.service.MaterialService;

import java.util.*;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialRepository materialRepository;
    @Autowired
    ClassroomRepository classroomRepository;
    @Override
    public CreateMaterialResponse createNewMaterial(UUID classroomId, CreateMaterialRequest createMaterialRequest ) {
        Classroom classroom = classroomRepository
                .findById(classroomId)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy phòng học này!"));
        List<Material> materials = new ArrayList<>();
        Set<String> requestTitles = new HashSet<>();
       for(MaterialItemRequest item: createMaterialRequest.getMaterials()){
           String normalizedTitle = item.getTitle().trim().toLowerCase();
           if (!requestTitles.add(normalizedTitle)) {
               throw new DuplicationException(
                       "Material '" +
                               item.getTitle() +
                               "' bị trùng trong request!"
               );
           }
           boolean existed = materialRepository
                           .existsByTitleAndClassroom(
                                   classroomId,
                                   item.getTitle()
                           );
           if (existed) {
               throw new DuplicationException(
                       "Material '" +
                               item.getTitle() +
                               "' đã tồn tại!"
               );
           }
           Material material = new Material();
           material.setTitle(item.getTitle());
           material.setDescription(item.getDescription());
           material.setClassrooms(List.of(classroom));
           materials.add(material);
       }
       materialRepository.saveAll(materials);
       classroom.getMaterials().addAll(materials);
       classroomRepository.save(classroom);
       return new CreateMaterialResponse("Tạo material thành công!");
    }

    @Override
    public Page<GetMaterialsOfClassroom> getMaterialsOfClassroom(UUID classroomId, int page, int size) {
        classroomRepository.findById(
                classroomId
        ).orElseThrow(() ->
                new NotFoundException(
                        "Không tìm thấy phòng học!"
                ));
        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        Sort.by("createdAt")
                                .descending()
                );
        return materialRepository
                .getMaterialsOfClassroom(
                        classroomId,
                        pageable
                );
    }
}

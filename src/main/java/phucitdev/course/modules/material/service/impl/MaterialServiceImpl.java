package phucitdev.course.modules.material.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import phucitdev.course.commo.exception.auth.BadRequestException;
import phucitdev.course.commo.exception.classroom.NotFoundException;
import phucitdev.course.modules.classroomMaterial.entity.ClassroomMaterial;
import phucitdev.course.modules.classroomMaterial.repository.ClassroomMaterialRepository;
import phucitdev.course.modules.classrooms.entity.Classroom;
import phucitdev.course.modules.classrooms.repository.ClassroomRepository;
import phucitdev.course.modules.material.dto.*;
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
    @Autowired
    ClassroomMaterialRepository classroomMaterialRepository;
//    @Override
//    public UpdateMaterialResponse updateMaterial(UUID classroomId, UUID materialId, UpdateMaterialRequest updateMaterialRequest) {
//        Material material = materialRepository
//                .findById(materialId)
//                .orElseThrow(() ->
//                        new NotFoundException(
//                                "Tài liệu không tồn tại!"
//                        ));
//
////        if (!material.getClassroom()
////                .getId()
////                .equals(classroomId)) {
////
////            throw new ForbiddenException(
////                    "Tài liệu không thuộc lớp học này"
////            );
////        }
//
//        material.setTitle(updateMaterialRequest.getTitle());
//        material.setDescription(updateMaterialRequest.getDescription());
//        materialRepository.save(material);
//
//        return new UpdateMaterialResponse(
//                "Cập nhật tài liệu thành công!"
//        );
//    }



//    @Override
//    public DeleteMaterialResponse deleteMaterial(UUID classroomId, UUID materialId) {
//       return null;
//    }


    @Override
    public CreateMaterialResponse createNewMaterials(CreateNewMaterialsRequest createNewMaterialsRequest) {
             Material material = new Material();
             material.setTitle(createNewMaterialsRequest.getTitle());
             material.setDescription(createNewMaterialsRequest.getDescription());
             materialRepository.save(material);
             return new CreateMaterialResponse("Tạo chủ đề thành công!");
    }

    @Override
    public GetMaterialsResponse getAllMaterials(Pageable pageable, String title) {
        Page<MaterialResponse> pageData =  materialRepository.search(title,
                pageable
        );
        return new GetMaterialsResponse(
                pageData.getContent(),
                pageData.getNumber(),
                pageData.getSize(),
                pageData.getTotalElements(),
                pageData.getTotalPages()
        );
    }
    @Override
    public DeleteMaterialResponse deleteMaterialByMaterialId(UUID materialId) {
        Material material = materialRepository.findByIdAndIsDeletedFalse(materialId).orElseThrow(() ->
                new NotFoundException(
                        "Tài liệu không tồn tại!"
                ));
        material.setIsDeleted(true);
        materialRepository.save(material);
        return new DeleteMaterialResponse("Xoá thành công!");
    }
    @Override
    public UpdateMaterialResponse updateMaterialByMaterialId(UpdateMaterialRequest updateMaterialRequest, UUID materialId) {
        Material material = materialRepository.findByIdAndIsDeletedFalse(materialId)
                .orElseThrow(() ->
                        new NotFoundException("Material không tồn tại")
                );
        boolean isDuplicateName = materialRepository
                .existsByTitleAndIsDeletedFalseAndIdNot(
                        updateMaterialRequest.getTitle(),
                        materialId
                );
        if (isDuplicateName) {
            throw new BadRequestException(
                    "Tên material đã tồn tại"
            );
        }
        material.setTitle(updateMaterialRequest.getTitle());
        material.setDescription(updateMaterialRequest.getDescription());
        materialRepository.save(material);
        return new UpdateMaterialResponse("Cập nhật thành công!");
    }

//    @Override
//    public AssignMaterialsResponse assignMaterialsToClassroom(UUID classroomId, AssignMaterialsRequest request) {
//        Classroom classroom = classroomRepository.findById(classroomId)
////                .orElseThrow(() ->
////                        new NotFoundException("Không tìm thấy lớp học")
////                );
////        for (MaterialAssignmentItem item : request.getMaterials()) {
////                   Material material = materialRepository.findById(item.getMaterialId())
////                            .orElseThrow(() ->
////                                    new NotFoundException(
////                                            "Không tìm thấy đề tài"
////                                    )
////                            );
////            Optional<ClassroomMaterial> existingMaterial = classroomMaterialRepository.findByClassroomIdAndMaterialId(
////                                    classroomId,
////                                    material.getId()
////                            );
////            // đã tồn tại
////            if (existingMaterial.isPresent()) {
////                ClassroomMaterial cm = existingMaterial.get();
////                // nếu chưa xoá -> báo lỗi
////                if (!cm.getIsDeleted()) {
////                    throw new BadRequestException(
////                            "Đề tài "
////                                    + material.getTitle()
////                                    + " đã được gán"
////                    );
////                }
////                // nếu đã xoá -> restore
////                cm.setIsDeleted(false);
////                cm.setDisplayOrder(item.getOrder());
////                classroomMaterialRepository.save(cm);
////                continue;
////            }
////            ClassroomMaterial classroomMaterial = new ClassroomMaterial();
////            classroomMaterial.setClassroom(classroom);
////            classroomMaterial.setMaterial(material);
////            classroomMaterial.setDisplayOrder(item.getOrder());
////            classroom.getClassroomMaterials().add(classroomMaterial);
////        }
////        classroomRepository.save(classroom);
////        return new AssignMaterialsResponse("Gán thành công!");
//        return null;
    }

//    @Override
//    public List<GetMaterialsOfClassroom> getMaterialsByClassroomId(UUID classroomId) {
//        classroomRepository.findById(classroomId)
//                .orElseThrow(() ->
//                        new NotFoundException("Không tìm thấy lớp học")
//                );
//        return classroomMaterialRepository.getMaterialsByClassroomId(classroomId);
//    }



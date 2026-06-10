package phucitdev.course.modules.snap_classroommaterial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phucitdev.course.commo.exception.classroom.NotFoundException;
import phucitdev.course.modules.classrooms.entity.Classroom;
import phucitdev.course.modules.classrooms.repository.ClassroomRepository;
import phucitdev.course.modules.snap_classroommaterial.dto.GetSnapClassroomMaterialsResponse;
import phucitdev.course.modules.snap_classroommaterial.dto.SnapClassroomMaterialItemResponse;
import phucitdev.course.modules.snap_classroommaterial.dto.UpdateMaterialOrderRequest;
import phucitdev.course.modules.snap_classroommaterial.dto.UpdateMaterialOrderResponse;
import phucitdev.course.modules.snap_classroommaterial.entity.SnapClassroomMaterial;
import phucitdev.course.modules.snap_classroommaterial.repository.SnapClassroomMaterialRepository;
import phucitdev.course.modules.snap_classroommaterial.service.SnapClassroomMaterialService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SnapClassroomMaterialServiceImpl implements SnapClassroomMaterialService {
    @Autowired
    ClassroomRepository classroomRepository;
    @Autowired
    SnapClassroomMaterialRepository snapClassroomMaterialRepository;
    @Override
    public GetSnapClassroomMaterialsResponse getMaterialsByClassroomId(UUID classroomId) {
        Classroom classroom = classroomRepository.findByIdAndIsDeletedFalse(classroomId)
                        .orElseThrow(() ->
                                new NotFoundException("Lớp học không tồn tại")
                        );
        List<SnapClassroomMaterial> materials = snapClassroomMaterialRepository
                        .findAllByClassroomIdAndIsDeletedFalseOrderByMaterialOrderAsc(
                                classroom.getId()
                        );
        List<SnapClassroomMaterialItemResponse>
                responseItems =
                materials.stream()
                        .map(item ->
                                SnapClassroomMaterialItemResponse
                                        .builder()
                                        .id(item.getId())
                                        .sourceMaterialId(
                                                item.getSourceMaterialId()
                                        )
                                        .title(item.getTitle())
                                        .description(
                                                item.getDescription()
                                        )
                                        .materialOrder(
                                                item.getMaterialOrder()
                                        )
                                        .totalLessons(
                                                item.getSnapLessons()
                                                        .size()
                                        )
                                        .build()
                        )
                        .toList();
        return GetSnapClassroomMaterialsResponse
                .builder()
                .materials(responseItems)
                .build();
    }

    @Override
    public UpdateMaterialOrderResponse updateMaterialOrder(UUID snapClassroomMaterialId, UpdateMaterialOrderRequest request) {
        SnapClassroomMaterial current =
                snapClassroomMaterialRepository
                        .findByIdAndIsDeletedFalse(
                                snapClassroomMaterialId
                        )
                        .orElseThrow(() ->
                                new NotFoundException(
                                        "Không tìm thấy đề tài"
                                )
                        );
        Integer oldOrder =
                current.getMaterialOrder();

        Integer newOrder =
                request.getOrder();

        // không đổi gì
        if (oldOrder.equals(newOrder)) {
            return new UpdateMaterialOrderResponse(
                    "Cập nhật thành công"
            );
        }
        Optional<SnapClassroomMaterial> existingOrderMaterial = snapClassroomMaterialRepository
                        .findByClassroomIdAndMaterialOrderAndIsDeletedFalse(
                                current.getClassroom()
                                        .getId(),
                                newOrder
                        );
        if (existingOrderMaterial.isPresent()) {
            SnapClassroomMaterial swapMaterial = existingOrderMaterial.get();
            // swap order
            swapMaterial.setMaterialOrder(oldOrder);
            snapClassroomMaterialRepository.save(swapMaterial);
        }
        current.setMaterialOrder(newOrder);
        snapClassroomMaterialRepository.save(current);
        return new UpdateMaterialOrderResponse(
                "Cập nhật thứ tự thành công"
        );
    }
}

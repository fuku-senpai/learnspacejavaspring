package phucitdev.course.modules.classroomMaterial.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phucitdev.course.commo.exception.classroom.NotFoundException;
import phucitdev.course.modules.classroomMaterial.dto.DeleteClassroomMaterialResponse;
import phucitdev.course.modules.classroomMaterial.dto.UpdateDisplayOrderRequest;
import phucitdev.course.modules.classroomMaterial.dto.UpdateDisplayOrderResponse;
import phucitdev.course.modules.classroomMaterial.entity.ClassroomMaterial;
import phucitdev.course.modules.classroomMaterial.repository.ClassroomMaterialRepository;
import phucitdev.course.modules.classroomMaterial.service.ClassroomMaterialService;
import java.util.UUID;
@Service
public class ClassroomMaterialServiceImpl implements ClassroomMaterialService {
    @Autowired
    ClassroomMaterialRepository  classroomMaterialRepository;
//    @Override
//    public UpdateDisplayOrderResponse updateDisplayOrder(UUID classroomMaterialId, UpdateDisplayOrderRequest request) {
//        ClassroomMaterial classroomMaterial = classroomMaterialRepository.findById(classroomMaterialId)
//                        .orElseThrow(() ->
//                                new NotFoundException("Không tìm thấy dữ liệu")
//                        );
//        classroomMaterial.setDisplayOrder(request.getDisplayOrder());
//        classroomMaterialRepository.save(classroomMaterial);
//        return new UpdateDisplayOrderResponse("Cập nhật thứ tự thành công!");
//    }

//    @Override
//    public DeleteClassroomMaterialResponse deleteClassroomMaterial(UUID classroomMaterialId) {
//        ClassroomMaterial classroomMaterial = classroomMaterialRepository.findByIdAndIsDeletedFalse(classroomMaterialId)
//                .orElseThrow(() ->
//                        new NotFoundException("Không tìm thấy dữ liệu")
//                );
//        classroomMaterial.setIsDeleted(true);
//        classroomMaterialRepository.save(classroomMaterial);
//        return new DeleteClassroomMaterialResponse("Xoá thành công!");
//    }
}

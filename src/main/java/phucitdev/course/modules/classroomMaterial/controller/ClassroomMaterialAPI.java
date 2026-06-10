package phucitdev.course.modules.classroomMaterial.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phucitdev.course.modules.classroomMaterial.dto.DeleteClassroomMaterialResponse;
import phucitdev.course.modules.classroomMaterial.dto.UpdateDisplayOrderRequest;
import phucitdev.course.modules.classroomMaterial.dto.UpdateDisplayOrderResponse;
import phucitdev.course.modules.classroomMaterial.service.ClassroomMaterialService;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
@SecurityRequirement(name = "api")
public class ClassroomMaterialAPI {
//    @Autowired
//    ClassroomMaterialService classroomMaterialService;
//    @PutMapping("classroomMaterial/{classroomMaterialId}")
//    public ResponseEntity<?> updateDisplayOrder(@PathVariable UUID classroomMaterialId, @Valid @RequestBody UpdateDisplayOrderRequest request) {
//        UpdateDisplayOrderResponse response = classroomMaterialService.updateDisplayOrder(classroomMaterialId, request);
//        return ResponseEntity.ok(response);
//    }
//    @DeleteMapping("classroomMaterial/{classroomMaterialId}")
//    public ResponseEntity<?> deleteClassroomMaterial(@PathVariable UUID classroomMaterialId) {
//        DeleteClassroomMaterialResponse response = classroomMaterialService.deleteClassroomMaterial(classroomMaterialId);
//        return ResponseEntity.ok(response);
//    }
}

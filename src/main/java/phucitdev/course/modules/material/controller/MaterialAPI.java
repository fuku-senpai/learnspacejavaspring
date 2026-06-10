package phucitdev.course.modules.material.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phucitdev.course.modules.material.dto.*;
import phucitdev.course.modules.material.service.MaterialService;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
@SecurityRequirement(name = "api")
public class MaterialAPI {
    @Autowired
    MaterialService materialService;
    @PostMapping("materials")
    public ResponseEntity<?> createNewMaterials(@Valid @RequestBody CreateNewMaterialsRequest request) {
         CreateMaterialResponse response = materialService.createNewMaterials(request);
         return ResponseEntity.ok().body(response);
    }
    @GetMapping("materials")
    public ResponseEntity<?> getAllMaterials(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String title
    ) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("createdAt").descending()
        );
        return ResponseEntity.ok(
                materialService.getAllMaterials(pageable,title)
        );
    }
    @DeleteMapping("/materials/{materialId}")
    public ResponseEntity<?> deleteMaterialByMaterialId(@PathVariable UUID materialId){
        DeleteMaterialResponse response = materialService.deleteMaterialByMaterialId(materialId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/materials/{materialId}")
    public ResponseEntity<UpdateMaterialResponse> updateMaterialByMaterialId(
            @PathVariable UUID materialId,
            @RequestBody @Valid UpdateMaterialRequest request
    ) {
        UpdateMaterialResponse response = materialService.updateMaterialByMaterialId(request, materialId);
        return ResponseEntity.ok(response);
    }
//    @PutMapping("/{classroomId}/materials/{materialId}")
//    public ResponseEntity<?> updateMaterial(
//            @PathVariable UUID classroomId,
//            @PathVariable UUID materialId,
//            @Valid @RequestBody UpdateMaterialRequest request) {
//        UpdateMaterialResponse response = materialService.updateMaterial(classroomId, materialId, request);
//        return ResponseEntity.ok(response);
//    }
    // api gán đề tài
//    @PostMapping("{classroomId}/materials/assign")
//    public ResponseEntity<?> assignMaterial(@PathVariable UUID classroomId, @Valid @RequestBody AssignMaterialsRequest request){
//        AssignMaterialsResponse response =
//                materialService.assignMaterialsToClassroom(
//                        classroomId,
//                        request
//                );
//
//        return ResponseEntity.ok(response);
//    }
    // api lấy các đề tài theo classId trong bảng trung gian
//    @GetMapping("/{classroomId}/materials")
//    public ResponseEntity<?> getMaterialsByClassroomId(@PathVariable UUID classroomId){
//           List<GetMaterialsOfClassroom> response  = materialService.getMaterialsByClassroomId(classroomId);
//           return ResponseEntity.ok(response);
//    }

//
//    @DeleteMapping("/{classroomId}/materials/{materialId}")
//    public ResponseEntity<?> deleteMaterial(
//            @PathVariable UUID classroomId,
//            @PathVariable UUID materialId) {
//
//        DeleteMaterialResponse response = materialService.deleteMaterial(classroomId, materialId);
//        return ResponseEntity.ok(response);
//    }


}

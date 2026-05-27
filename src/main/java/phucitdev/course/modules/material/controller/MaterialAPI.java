package phucitdev.course.modules.material.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phucitdev.course.modules.material.dto.CreateMaterialRequest;
import phucitdev.course.modules.material.dto.CreateMaterialResponse;
import phucitdev.course.modules.material.dto.GetMaterialsOfClassroom;
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
    @PostMapping("{classroomId}/materials")
    public ResponseEntity<?> createNewMaterial(@PathVariable UUID classroomId,
                                                @Valid @RequestBody CreateMaterialRequest createMaterialRequest) {
        CreateMaterialResponse createMaterialResponse = materialService.createNewMaterial(classroomId, createMaterialRequest);
        return ResponseEntity.ok().body(createMaterialResponse);
    }
    @GetMapping("{classroomId}/materials")
    public ResponseEntity<?> getMaterials(@PathVariable UUID classroomId, @RequestParam(
                                                      defaultValue = "0"
                                              ) int page,

                                          @RequestParam(
                                                  defaultValue = "10"
                                          ) int size) {
        Page<GetMaterialsOfClassroom> response = materialService.getMaterialsOfClassroom(classroomId, page, size);
        return ResponseEntity.ok().body(response);
    }
}

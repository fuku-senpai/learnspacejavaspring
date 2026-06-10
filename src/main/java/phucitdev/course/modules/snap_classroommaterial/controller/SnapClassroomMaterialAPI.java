package phucitdev.course.modules.snap_classroommaterial.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phucitdev.course.modules.snap_classroommaterial.dto.UpdateMaterialOrderRequest;
import phucitdev.course.modules.snap_classroommaterial.service.SnapClassroomMaterialService;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
@SecurityRequirement(name = "api")
public class SnapClassroomMaterialAPI {
    @Autowired
    SnapClassroomMaterialService snapClassroomMaterialService;

    @GetMapping("/{classroomId}/materials")
    public ResponseEntity<?> getMaterialsByClassroomId(@PathVariable UUID classroomId) {
        return ResponseEntity.ok(
                snapClassroomMaterialService.getMaterialsByClassroomId(
                                classroomId
                        )
        );
    }
    @PutMapping("/{snapMaterialId}/order")
    public ResponseEntity<?> updateMaterialOrder(@PathVariable UUID snapMaterialId,
            @Valid @RequestBody UpdateMaterialOrderRequest request
    ) {
        return ResponseEntity.ok(
                snapClassroomMaterialService
                        .updateMaterialOrder(
                                snapMaterialId,
                                request
                        )
        );
    }
}

package phucitdev.course.modules.lessonResource.controller;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phucitdev.course.modules.lessonResource.dto.CreateLessonResourceRequest;
import phucitdev.course.modules.lessonResource.dto.CreateLessonResourceResponse;
import phucitdev.course.modules.lessonResource.dto.GetLessonResourceResponse;
import phucitdev.course.modules.lessonResource.service.LessonResourceService;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@SecurityRequirement(name = "api")
public class LessonResourceAPI {
    @Autowired
    LessonResourceService lessonResourceService;

    @GetMapping("/{lessonId}/lessonResources")
    public ResponseEntity<?> getLessonResource(@PathVariable("lessonId") UUID lessonId) {
        List<GetLessonResourceResponse> response = lessonResourceService.getLessonResources(lessonId);
        return ResponseEntity.ok().body(response);
    }
    @PostMapping("/lessonResource")
    public ResponseEntity<?> createLessonResource(@Valid @RequestBody CreateLessonResourceRequest createLessonResourceRequest) {
        CreateLessonResourceResponse createLessonResourceResponse = lessonResourceService.createLessonResource(createLessonResourceRequest);
        return ResponseEntity.ok().body(createLessonResourceResponse);
    }
}

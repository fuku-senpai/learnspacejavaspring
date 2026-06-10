package phucitdev.course.modules.lessonVideo.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phucitdev.course.modules.lessonVideo.dto.CreateLessonVideoRequest;
import phucitdev.course.modules.lessonVideo.dto.CreateLessonVideoResponse;
import phucitdev.course.modules.lessonVideo.dto.GetLessonVideoResponse;
import phucitdev.course.modules.lessonVideo.service.LessonVideoService;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@SecurityRequirement(name = "api")
public class LessonVideoAPI {
    @Autowired
    LessonVideoService  lessonVideoService;
    @PostMapping("/lessonVideo")
    public ResponseEntity<?> createNewVideo(@Valid @RequestBody CreateLessonVideoRequest createLessonVideoRequest){
        CreateLessonVideoResponse createLessonVideoResponse = lessonVideoService.createLessonVideo(createLessonVideoRequest);
        return ResponseEntity.ok(createLessonVideoResponse);
    }
    @GetMapping("/{snapLessonId}/lessonVideos")
    public ResponseEntity<?> getLessonVideos(@PathVariable UUID snapLessonId){
        List<GetLessonVideoResponse> response = lessonVideoService.getVideos(snapLessonId);
        return ResponseEntity.ok(response);
    }

}

package phucitdev.course.modules.lessonVideo.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phucitdev.course.modules.lessonVideo.dto.*;
import phucitdev.course.modules.lessonVideo.entity.VideoType;
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
//    @GetMapping("/{snapLessonId}/lessonVideos")
//    public ResponseEntity<?> getLessonVideos(@PathVariable UUID snapLessonId, @RequestParam(required = false) VideoType type){
//        List<GetLessonVideoResponse> response = lessonVideoService.getVideos(snapLessonId, type);
//        return ResponseEntity.ok(response);
//    }
    @DeleteMapping("/lessonVideo/{lessonVideoId}")
    public ResponseEntity<?> deleteVideo(@PathVariable("lessonVideoId") UUID lessonVideoId){
        DeleteLessonVideoResponse response = lessonVideoService.deleteVideo(lessonVideoId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/lessonVideo/{lessonVideoId}")
    public ResponseEntity<UpdateLessonVideoResponse> updateLessonVideo(@PathVariable("lessonVideoId") UUID lessonVideoId, @Valid @RequestBody UpdateLessonVideoRequest request){
           UpdateLessonVideoResponse response = lessonVideoService.updateLessonVideo(lessonVideoId, request);
           return ResponseEntity.ok(response);
    }
}

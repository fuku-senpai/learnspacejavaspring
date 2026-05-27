package phucitdev.course.modules.lessons.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phucitdev.course.modules.lessons.dto.CreateNewLessonRequest;
import phucitdev.course.modules.lessons.dto.CreateNewLessonResponse;
import phucitdev.course.modules.lessons.dto.LessonResponse;
import phucitdev.course.modules.lessons.service.LessonService;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
@SecurityRequirement(name = "api")
public class LessonAPI {
    @Autowired
    LessonService lessonService;
    @PostMapping("lesson")
    public ResponseEntity<?> createNewLesson(@Valid  @RequestBody CreateNewLessonRequest createNewLessonRequest){
        CreateNewLessonResponse lessonResponse = lessonService.createNewLesson(createNewLessonRequest);
        return ResponseEntity.ok(lessonResponse);
    }
    @GetMapping("{materialId}/lessons")
    public ResponseEntity<?> getLessons(@PathVariable("materialId") UUID materialId){
       List<LessonResponse> lessonResponseList = lessonService.findAllLessons(materialId);
       return ResponseEntity.ok(lessonResponseList);
    }
}

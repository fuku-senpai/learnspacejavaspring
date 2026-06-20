package phucitdev.course.modules.snap_lessonquiz.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phucitdev.course.modules.snap_lessonquiz.dto.DeleteSnapLessonQuizResponse;
import phucitdev.course.modules.snap_lessonquiz.service.SnapLessonQuizService;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
@SecurityRequirement(name = "api")
public class SnapLessonQuizAPI {
    @Autowired
    SnapLessonQuizService snapLessonQuizService;
    @DeleteMapping("snapLessonQuiz/{snapLessonQuizId}")
    public ResponseEntity<?> deleteSnapLessonQuiz(@PathVariable UUID snapLessonQuizId){
           DeleteSnapLessonQuizResponse response = snapLessonQuizService.deleteSnapLessonQuiz(snapLessonQuizId);
           return ResponseEntity.ok().body(response);
    }

}

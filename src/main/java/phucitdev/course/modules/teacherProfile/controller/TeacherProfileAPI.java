package phucitdev.course.modules.teacherProfile.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phucitdev.course.modules.teacherProfile.dto.GetAllTeacherResponse;
import phucitdev.course.modules.teacherProfile.service.TeacherProfileService;

@CrossOrigin("*")
@RequestMapping("/api/")
@RestController
@SecurityRequirement(name = "api")
public class TeacherProfileAPI {
    @Autowired
    TeacherProfileService teacherProfileService;

    @GetMapping("teachers")
    public ResponseEntity<GetAllTeacherResponse> getAllTeacher(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String keyword
    ) {
        GetAllTeacherResponse response = teacherProfileService.getAllTeacher(page, size, keyword);
        return ResponseEntity.ok(response);
    }

}

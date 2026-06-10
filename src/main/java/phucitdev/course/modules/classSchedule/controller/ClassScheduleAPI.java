package phucitdev.course.modules.classSchedule.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phucitdev.course.modules.classSchedule.dto.CreateClassScheduleRequest;
import phucitdev.course.modules.classSchedule.dto.CreateClassScheduleResponse;
import phucitdev.course.modules.classSchedule.dto.GetClassScheduleResponse;
import phucitdev.course.modules.classSchedule.entity.ClassSchedule;
import phucitdev.course.modules.classSchedule.service.ClassScheduleService;
import phucitdev.course.modules.classrooms.dto.DeleteClassroomResponse;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
@SecurityRequirement(name = "api")
public class ClassScheduleAPI {
    @Autowired
    ClassScheduleService classScheduleService;
    @PostMapping("{classroomId}/schedules")
    public ResponseEntity<?> createClassSchedule( @PathVariable UUID classroomId,
                                                  @RequestBody
                                                  CreateClassScheduleRequest request){
               CreateClassScheduleResponse response = classScheduleService.createClassSchedule(request, classroomId);
               return ResponseEntity.ok(response);
    }
    @GetMapping("/{classroomId}/schedules")
    public ResponseEntity<?> getClassSchedule(@PathVariable UUID classroomId){
        List<GetClassScheduleResponse> schedules = classScheduleService.getClassSchedule(classroomId);
        return ResponseEntity.ok(schedules);
    }
    @PutMapping("/{classroomId}/schedules/{scheduleId}")
    public ResponseEntity<?> updateClassSchedule( @PathVariable UUID classroomId,
                                                  @PathVariable UUID scheduleId,
                                                  @RequestBody CreateClassScheduleRequest request){
        CreateClassScheduleResponse response =
                classScheduleService.updateClassSchedule(classroomId, scheduleId, request);
        return ResponseEntity.ok(response);

    }
    @DeleteMapping("/{classroomId}/schedules/{scheduleId}")
    public ResponseEntity<?> deleteClassSchedule(
            @PathVariable UUID classroomId,
            @PathVariable UUID scheduleId) {
       DeleteClassroomResponse response = classScheduleService.deleteClassSchedule(classroomId, scheduleId);
        return ResponseEntity.ok(response);
    }
}

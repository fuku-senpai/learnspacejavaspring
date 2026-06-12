package phucitdev.course.modules.teacherProfile.service;

import phucitdev.course.modules.classrooms.entity.ClassroomStatus;
import phucitdev.course.modules.teacherProfile.dto.GetAllTeacherResponse;
import phucitdev.course.modules.teacherProfile.dto.GetTeacherScheduleResponse;

import java.util.UUID;

public interface TeacherProfileService {
    GetAllTeacherResponse getAllTeacher(Integer page, Integer size, String keyword);
    GetTeacherScheduleResponse getTeacherSchedule(UUID teacherId, Integer page, Integer size, ClassroomStatus status);
}

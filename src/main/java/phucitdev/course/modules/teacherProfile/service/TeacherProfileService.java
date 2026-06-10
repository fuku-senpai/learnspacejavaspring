package phucitdev.course.modules.teacherProfile.service;

import phucitdev.course.modules.teacherProfile.dto.GetAllTeacherResponse;

public interface TeacherProfileService {
    GetAllTeacherResponse getAllTeacher(Integer page, Integer size, String keyword);
}

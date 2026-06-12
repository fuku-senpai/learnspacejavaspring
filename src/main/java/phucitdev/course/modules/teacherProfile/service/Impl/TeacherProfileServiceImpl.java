package phucitdev.course.modules.teacherProfile.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import phucitdev.course.modules.classSchedule.repository.ClassScheduleRepository;
import phucitdev.course.modules.classrooms.entity.ClassroomStatus;
import phucitdev.course.modules.teacherProfile.dto.GetAllTeacherResponse;
import phucitdev.course.modules.teacherProfile.dto.GetTeacherScheduleResponse;
import phucitdev.course.modules.teacherProfile.dto.TeacherItemResponse;
import phucitdev.course.modules.teacherProfile.dto.TeacherScheduleResponse;
import phucitdev.course.modules.teacherProfile.entity.TeacherProfile;
import phucitdev.course.modules.teacherProfile.repository.TeacherProfileRepository;
import phucitdev.course.modules.teacherProfile.service.TeacherProfileService;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherProfileServiceImpl implements TeacherProfileService {
    @Autowired
    private TeacherProfileRepository teacherProfileRepository;
    @Autowired
    private ClassScheduleRepository  classScheduleRepository;
    @Override
    public GetAllTeacherResponse getAllTeacher(Integer page, Integer size, String keyword) {
        Page<TeacherProfile> teacherPage =
                teacherProfileRepository.getAllTeacher(
                        keyword,
                        PageRequest.of(page, size)
                );

        List<TeacherItemResponse> items = teacherPage.getContent()
                        .stream()
                        .map(tp -> new TeacherItemResponse(
                                tp.getId(),
                                tp.getAccount().getFullName(),
                                tp.getAccount().getEmail(),
                                tp.getAvatar(),
                                tp.getSpecialization(),
                                tp.getYearsExperience()
                        ))
                        .toList();

        return new GetAllTeacherResponse(
                items,
                teacherPage.getNumber(),
                teacherPage.getSize(),
                teacherPage.getTotalElements(),
                teacherPage.getTotalPages()
        );
    }

    @Override
    public GetTeacherScheduleResponse getTeacherSchedule(UUID teacherId, Integer page, Integer size, ClassroomStatus status) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TeacherScheduleResponse> schedulePage = classScheduleRepository.getTeacherSchedules(teacherId, status, pageable);
        return new GetTeacherScheduleResponse(
                schedulePage.getContent(),
                page,
                size,
                schedulePage.getTotalElements(),
                schedulePage.getTotalPages()
        );
    }
}

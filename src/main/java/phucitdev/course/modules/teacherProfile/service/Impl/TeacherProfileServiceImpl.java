package phucitdev.course.modules.teacherProfile.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import phucitdev.course.modules.teacherProfile.dto.GetAllTeacherResponse;
import phucitdev.course.modules.teacherProfile.dto.TeacherItemResponse;
import phucitdev.course.modules.teacherProfile.entity.TeacherProfile;
import phucitdev.course.modules.teacherProfile.repository.TeacherProfileRepository;
import phucitdev.course.modules.teacherProfile.service.TeacherProfileService;

import java.util.List;

@Service
public class TeacherProfileServiceImpl implements TeacherProfileService {
    @Autowired
    private TeacherProfileRepository teacherProfileRepository;
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
}

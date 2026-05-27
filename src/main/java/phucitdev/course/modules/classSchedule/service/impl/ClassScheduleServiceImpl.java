package phucitdev.course.modules.classSchedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phucitdev.course.commo.exception.auth.AlreadyExistsException;
import phucitdev.course.commo.exception.auth.BadRequestException;
import phucitdev.course.commo.exception.classroom.NotFoundException;
import phucitdev.course.modules.classSchedule.dto.CreateClassScheduleRequest;
import phucitdev.course.modules.classSchedule.dto.CreateClassScheduleResponse;
import phucitdev.course.modules.classSchedule.dto.GetClassScheduleResponse;
import phucitdev.course.modules.classSchedule.entity.ClassSchedule;
import phucitdev.course.modules.classSchedule.repository.ClassScheduleRepository;
import phucitdev.course.modules.classSchedule.service.ClassScheduleService;
import phucitdev.course.modules.classrooms.entity.Classroom;
import phucitdev.course.modules.classrooms.entity.StudyMode;
import phucitdev.course.modules.classrooms.repository.ClassroomRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ClassScheduleServiceImpl implements ClassScheduleService {
    @Autowired
    ClassScheduleRepository classScheduleRepository;
    @Autowired
    ClassroomRepository classroomRepository;
    @Override
    public CreateClassScheduleResponse createClassSchedule(CreateClassScheduleRequest createClassScheduleRequest, UUID classId) {
        Classroom classroom = classroomRepository.findById(
                        classId
                ).orElseThrow(() ->
                        new NotFoundException(
                                "Không tìm thấy lớp học"
                        ));
        boolean exists =
                classScheduleRepository
                        .existsByClassroomIdAndDayOfWeekAndStartTimeAndEndTime(
                                classId,
                                createClassScheduleRequest.getDayOfWeek(),
                                createClassScheduleRequest.getStartTime(),
                                createClassScheduleRequest.getEndTime()
                        );

        if (exists) {
            throw new AlreadyExistsException(
                    "Lịch học đã tồn tại"
            );
        }
        if (createClassScheduleRequest.getStartTime()
                .isAfter(createClassScheduleRequest.getEndTime())) {
            throw new BadRequestException(
                    "Giờ bắt đầu phải nhỏ hơn giờ kết thúc"
            );
        }
        // validate ONLINE / OFFLINE
        if (createClassScheduleRequest.getStudyMode()
                == StudyMode.ONLINE
                && (createClassScheduleRequest.getMeetingUrl() == null
                || createClassScheduleRequest.getMeetingUrl().isBlank())) {

            throw new BadRequestException(
                    "Link meeting không được để trống"
            );
        }
        if (createClassScheduleRequest.getStudyMode()
                == StudyMode.OFFLINE
                && (createClassScheduleRequest.getLocation() == null
                || createClassScheduleRequest.getLocation().isBlank())) {

            throw new BadRequestException(
                    "Địa điểm không được để trống"
            );
        }
        ClassSchedule schedule = new ClassSchedule();
        schedule.setClassroom(classroom);
        schedule.setDayOfWeek(createClassScheduleRequest.getDayOfWeek());

        schedule.setStartTime(createClassScheduleRequest.getStartTime());
        schedule.setEndTime(createClassScheduleRequest.getEndTime());

        schedule.setStudyMode(createClassScheduleRequest.getStudyMode());
        schedule.setLocation(createClassScheduleRequest.getLocation());
        schedule.setMeetingUrl(createClassScheduleRequest.getMeetingUrl());
        classScheduleRepository.save(schedule);
        return new CreateClassScheduleResponse("Gán lịch học thành công");
    }

    @Override
    public List<GetClassScheduleResponse> getClassSchedule(UUID classroomId) {
         classroomRepository.findById(
                classroomId
        ).orElseThrow(() ->
                new NotFoundException(
                        "Không tìm thấy lớp học"
                ));
        return classScheduleRepository.getClassSchedule(classroomId);

    }
}

package phucitdev.course.modules.classSchedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phucitdev.course.commo.exception.auth.AlreadyExistsException;
import phucitdev.course.commo.exception.auth.BadRequestException;
import phucitdev.course.commo.exception.auth.ForbiddenException;
import phucitdev.course.commo.exception.classroom.NotFoundException;
import phucitdev.course.modules.classSchedule.dto.CreateClassScheduleRequest;
import phucitdev.course.modules.classSchedule.dto.CreateClassScheduleResponse;
import phucitdev.course.modules.classSchedule.dto.GetClassScheduleResponse;
import phucitdev.course.modules.classSchedule.entity.ClassSchedule;
import phucitdev.course.modules.classSchedule.repository.ClassScheduleRepository;
import phucitdev.course.modules.classSchedule.service.ClassScheduleService;
import phucitdev.course.modules.classrooms.dto.DeleteClassroomResponse;
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
                        .existsByClassroomIdAndDayOfWeekAndStartTimeAndEndTimeAndIsDeletedFalse(
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
        validateScheduleRequest(createClassScheduleRequest);
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

    @Override
    public CreateClassScheduleResponse updateClassSchedule(UUID classroomId, UUID scheduleId, CreateClassScheduleRequest createClassScheduleRequest) {
        ClassSchedule schedule = classScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NotFoundException("Lịch không tồn tại!"));
        if (!schedule.getClassroom().getId().equals(classroomId)) {
            throw new ForbiddenException("Lịch học không thuộc về lớp học này");
        }
        boolean exists =
                classScheduleRepository
                        .existsByClassroomIdAndDayOfWeekAndStartTimeAndEndTimeAndIdNotAndIsDeletedFalse(
                                classroomId,
                                createClassScheduleRequest.getDayOfWeek(),
                                createClassScheduleRequest.getStartTime(),
                                createClassScheduleRequest.getEndTime(),
                                scheduleId
                        );

        if (exists) {
            throw new AlreadyExistsException(
                    "Lịch học đã tồn tại"
            );
        }
       validateScheduleRequest(createClassScheduleRequest);
        schedule.setDayOfWeek(createClassScheduleRequest.getDayOfWeek());
        schedule.setStartTime(createClassScheduleRequest.getStartTime());
        schedule.setEndTime(createClassScheduleRequest.getEndTime());
        schedule.setStudyMode(createClassScheduleRequest.getStudyMode());
        schedule.setLocation(createClassScheduleRequest.getLocation());
        schedule.setMeetingUrl(createClassScheduleRequest.getMeetingUrl());
        classScheduleRepository.save(schedule);
        return new CreateClassScheduleResponse("Cập nhật lịch thành công!");
    }

    @Override
    public DeleteClassroomResponse deleteClassSchedule(UUID classroomId, UUID scheduleId) {
        ClassSchedule schedule = classScheduleRepository
                .findById(scheduleId)
                .orElseThrow(() -> new NotFoundException("Lịch học không tồn tại!"));

        if (!schedule.getClassroom().getId().equals(classroomId)) {
            throw new ForbiddenException("Lịch học không thuộc về lớp học này");
        }
         schedule.setIsDeleted(true);
        classScheduleRepository.save(schedule);
        return new DeleteClassroomResponse("Xoá lịch thành công!");
    }
    private void validateScheduleRequest(
            CreateClassScheduleRequest request) {

        // validate time
        if (request.getStartTime().isAfter(request.getEndTime())) {
            throw new BadRequestException(
                    "Giờ bắt đầu phải nhỏ hơn giờ kết thúc"
            );
        }

        // validate ONLINE
        if (request.getStudyMode() == StudyMode.ONLINE &&
                (request.getMeetingUrl() == null
                        || request.getMeetingUrl().isBlank())) {

            throw new BadRequestException(
                    "Link meeting không được để trống"
            );
        }

        // validate OFFLINE
        if (request.getStudyMode() == StudyMode.OFFLINE &&
                (request.getLocation() == null
                        || request.getLocation().isBlank())) {

            throw new BadRequestException(
                    "Địa điểm không được để trống"
            );
        }
    }
}

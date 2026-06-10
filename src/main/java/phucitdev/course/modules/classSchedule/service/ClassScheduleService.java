package phucitdev.course.modules.classSchedule.service;
import phucitdev.course.modules.classSchedule.dto.CreateClassScheduleRequest;
import phucitdev.course.modules.classSchedule.dto.CreateClassScheduleResponse;
import phucitdev.course.modules.classSchedule.dto.GetClassScheduleResponse;
import phucitdev.course.modules.classrooms.dto.DeleteClassroomResponse;

import java.util.List;
import java.util.UUID;

public interface ClassScheduleService {
    CreateClassScheduleResponse createClassSchedule(CreateClassScheduleRequest createClassScheduleRequest, UUID classroomId);
    List<GetClassScheduleResponse> getClassSchedule(UUID classroomId);
    CreateClassScheduleResponse updateClassSchedule(UUID classroomId, UUID scheduleId, CreateClassScheduleRequest createClassScheduleRequest);
    DeleteClassroomResponse deleteClassSchedule(UUID classroomId, UUID scheduleId);
}

package phucitdev.course.modules.classSchedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import phucitdev.course.modules.classrooms.entity.StudyMode;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClassScheduleRequest {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private StudyMode studyMode;
    // OFFLINE
    private String location;
    // ONLINE
    private String meetingUrl;
}

package phucitdev.course.modules.classSchedule.dto;

import lombok.*;
import phucitdev.course.modules.classrooms.entity.StudyMode;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetClassScheduleResponse  {
    private UUID id;

    private DayOfWeek dayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;

    private StudyMode studyMode;

    private String location;

    private String meetingUrl;

}

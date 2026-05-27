package phucitdev.course.modules.classrooms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import phucitdev.course.modules.classrooms.entity.StudyMode;

import java.time.LocalTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassScheduleResponse {
    private UUID id;
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private StudyMode studyMode;
    private String location;
    private String meetingUrl;
}

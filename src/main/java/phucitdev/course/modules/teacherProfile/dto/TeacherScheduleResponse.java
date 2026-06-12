package phucitdev.course.modules.teacherProfile.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phucitdev.course.modules.classrooms.entity.ClassroomStatus;
import phucitdev.course.modules.classrooms.entity.StudyMode;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherScheduleResponse {
    private UUID classroomId;
    private String classroomName;
    private String classroomCode;

    private ClassroomStatus classroomStatus;

    private LocalDate startDate;
    private LocalDate endDate;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    private StudyMode studyMode;

    private String location;
    private String meetingUrl;
}

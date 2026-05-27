package phucitdev.course.modules.classrooms.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ClassResponse {

    private UUID id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String code;
    private String status;
    private Integer totalStudent;
    private String teacherName;
    private List<ClassScheduleResponse> schedules;
    // Query search classes
    public ClassResponse(
            UUID id,
            String name,
            String description,
            LocalDate startDate,
            LocalDate endDate,
            String code,
            String status,
            Integer totalStudent
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.code = code;
        this.status = status;
        this.totalStudent = totalStudent;
    }

    // Query my classes
    public ClassResponse(
            UUID id,
            String name,
            String description,
            LocalDate startDate,
            LocalDate endDate,
            String code,
            String status,
            Integer totalStudent,
            String teacherName
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.code = code;
        this.status = status;
        this.totalStudent = totalStudent;
        this.teacherName = teacherName;
    }
}
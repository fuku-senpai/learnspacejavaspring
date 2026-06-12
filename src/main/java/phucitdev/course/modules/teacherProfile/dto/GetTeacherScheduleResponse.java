package phucitdev.course.modules.teacherProfile.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetTeacherScheduleResponse {
    private List<TeacherScheduleResponse> schedules;
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
}
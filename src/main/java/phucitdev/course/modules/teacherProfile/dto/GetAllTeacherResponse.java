package phucitdev.course.modules.teacherProfile.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTeacherResponse {

    private List<TeacherItemResponse> items;
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
}
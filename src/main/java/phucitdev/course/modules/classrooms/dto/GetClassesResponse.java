package phucitdev.course.modules.classrooms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetClassesResponse {
    private List<ClassResponse> items;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}

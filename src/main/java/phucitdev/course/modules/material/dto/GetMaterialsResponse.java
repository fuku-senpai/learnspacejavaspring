package phucitdev.course.modules.material.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMaterialsResponse {
    private List<MaterialResponse> items;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}

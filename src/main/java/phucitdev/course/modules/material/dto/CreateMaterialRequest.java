package phucitdev.course.modules.material.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMaterialRequest {
    private List<MaterialItemRequest> materials;

}

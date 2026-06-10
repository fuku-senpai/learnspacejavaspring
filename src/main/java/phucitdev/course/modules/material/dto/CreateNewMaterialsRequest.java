package phucitdev.course.modules.material.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewMaterialsRequest {
    private String title;
    private String description;
}

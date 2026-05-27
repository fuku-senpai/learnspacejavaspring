package phucitdev.course.modules.material.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMaterialsOfClassroom {
    private UUID id;
    private String title;
    private String description;
    private Integer totalLessons;
}

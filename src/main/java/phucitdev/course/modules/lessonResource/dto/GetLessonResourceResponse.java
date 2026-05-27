package phucitdev.course.modules.lessonResource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import phucitdev.course.modules.lessonResource.entity.ResourceType;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLessonResourceResponse {
    private UUID id;
    private String title;
    private String note;
    private ResourceType type;
    private List<String> urls;
}

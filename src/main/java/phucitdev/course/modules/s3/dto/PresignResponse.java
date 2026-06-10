package phucitdev.course.modules.s3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PresignResponse {
    private String uploadUrl;
    private String fileKey;
}
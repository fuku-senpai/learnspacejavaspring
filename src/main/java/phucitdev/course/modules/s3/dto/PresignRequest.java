package phucitdev.course.modules.s3.dto;

import lombok.Data;

@Data
public class PresignRequest {
    private String fileName;
    private String fileType;
}
package phucitdev.course.modules.auth.dto;

import lombok.Data;

@Data
public class UserInfo {
    private String id;
    private String email;
    private String fullName;
    private String role;
}
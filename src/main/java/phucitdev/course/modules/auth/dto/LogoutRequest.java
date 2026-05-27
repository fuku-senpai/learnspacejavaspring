package phucitdev.course.modules.auth.dto;

import lombok.Data;

@Data
public class LogoutRequest {
    String refreshToken;
}

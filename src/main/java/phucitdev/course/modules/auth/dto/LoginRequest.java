package phucitdev.course.modules.auth.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {
    @NotBlank(message = "Role không được để trống!")
    private String role;
    @NotBlank(message = "Email không được để trống!")
    @Email(message = "Email không đúng định dạng!")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Mật khẩu không được để trống!")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$",
            message = "Mật khẩu phải có ít nhất 6 ký tự, bao gồm in hoa, số và ký tự đặc biệt"
    )
    private String password;
    @NotBlank(message = "DeviceId không được để trống!")
    private String deviceId;
    @NotBlank(message = "DeviceInfo không được để trống!")
    private String deviceInfo;

}

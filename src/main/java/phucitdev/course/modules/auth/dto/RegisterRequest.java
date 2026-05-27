package phucitdev.course.modules.auth.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Email không được để trống!")
    @Email(message = "Email không đúng định dạng!")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Mật khẩu không được để trống!")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$",
            message = "Mật khẩu phải có ít nhất 6 ký tự, bao gồm in hoa, số và ký tự đặc biệt"
    )
    private String password;
    @NotBlank(message = "Tên đầy đủ không được để trống!")
    private String fullName;
    private String role;
}

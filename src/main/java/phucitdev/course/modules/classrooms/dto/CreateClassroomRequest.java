package phucitdev.course.modules.classrooms.dto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClassroomRequest {
    @NotBlank(message = "Tên lớp không được để trống")
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private LocalDate startDate;

    // Ngày kết thúc lớp học
    @Column(nullable = false)
    private LocalDate endDate;
}

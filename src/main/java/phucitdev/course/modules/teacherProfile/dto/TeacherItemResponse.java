package phucitdev.course.modules.teacherProfile.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherItemResponse {
    private UUID teacherId;
    private String fullName;
    private String email;
    private String avatar;
    private String specialization;
    private Integer yearsExperience;
}
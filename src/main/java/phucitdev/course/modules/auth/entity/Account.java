package phucitdev.course.modules.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phucitdev.course.commo.base.BaseEntity;
import phucitdev.course.modules.classrooms.entity.Classroom;
import phucitdev.course.modules.studentProfile.entity.StudentProfile;
import phucitdev.course.modules.teacherProfile.entity.TeacherProfile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account extends BaseEntity {
    private String email;
    private String password;
    private String fullName;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean isActive;
    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private List<RefreshToken> refreshTokens;

    @OneToOne(mappedBy = "account")
    private TeacherProfile teacher;

    @OneToOne(mappedBy = "account")
    private StudentProfile student;
}

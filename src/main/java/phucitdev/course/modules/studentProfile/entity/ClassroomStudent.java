package phucitdev.course.modules.studentProfile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import phucitdev.course.commo.base.BaseEntity;
import phucitdev.course.modules.classrooms.entity.Classroom;

import java.time.LocalDate;

@Entity
@Table(name = "classroom_students")
@Getter
@Setter
public class ClassroomStudent extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentProfile_id")
    private StudentProfile studentProfile;

    private LocalDate joinedAt;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus  status;
}
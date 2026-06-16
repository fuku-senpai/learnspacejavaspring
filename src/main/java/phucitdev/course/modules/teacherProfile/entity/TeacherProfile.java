package phucitdev.course.modules.teacherProfile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phucitdev.course.commo.base.BaseEntity;
import phucitdev.course.modules.auth.entity.Account;
import phucitdev.course.modules.classrooms.entity.Classroom;
import phucitdev.course.modules.lesson_quiz.entity.LessonQuiz;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeacherProfile extends BaseEntity {
    private String specialization;
    private Integer yearsExperience;
    private String avatar;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", unique = true)
    private Account account;

    @OneToMany(mappedBy = "teacherProfile")
    private List<Classroom> classrooms;

    @OneToMany(mappedBy = "teacher")
    private List<LessonQuiz> quizzes;
}

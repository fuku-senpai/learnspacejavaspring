package phucitdev.course.modules.snap_lessonquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import phucitdev.course.commo.base.BaseEntity;
import phucitdev.course.modules.lesson_quiz.entity.LessonQuiz;
import phucitdev.course.modules.snap_lesson.entity.SnapLesson;

@Entity
@Table(name = "snap_lesson_quizzes")
@Getter
@Setter
public class SnapLessonQuiz extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "snap_lesson_id")
    private SnapLesson snapLesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_quiz_id", nullable = false)
    private LessonQuiz lessonQuiz;

    private Boolean required = true;

    private Integer maxAttempts = 1;

    private Integer displayOrder;
}

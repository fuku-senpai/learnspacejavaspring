package phucitdev.course.modules.lessonResource.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phucitdev.course.commo.base.BaseEntity;
import phucitdev.course.modules.LessonResourceUrl.entity.LessonResourceUrl;
import phucitdev.course.modules.snap_lesson.entity.SnapLesson;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LessonResource extends BaseEntity {
    private String title;

    @Enumerated(EnumType.STRING)
    private ResourceType type;
    @Column(columnDefinition = "TEXT")
    private String note;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "snap_lesson_id", nullable = false)
    private SnapLesson snapLesson;

    @OneToMany(
            mappedBy = "lessonResource",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<LessonResourceUrl> lessonResourceUrls = new ArrayList<>();
}

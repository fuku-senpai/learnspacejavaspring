package phucitdev.course.modules.LessonResourceUrl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phucitdev.course.commo.base.BaseEntity;
import phucitdev.course.modules.lessonResource.entity.LessonResource;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LessonResourceUrl extends BaseEntity {
    private String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_resource_id")
    private LessonResource lessonResource;
}

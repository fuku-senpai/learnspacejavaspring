package phucitdev.course.modules.lessons.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phucitdev.course.commo.base.BaseEntity;
import phucitdev.course.modules.lessonResource.entity.LessonResource;
import phucitdev.course.modules.material.entity.Material;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lesson extends BaseEntity {
    private String title;
    private Integer lessonOrder;
    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;
    @OneToMany(
            mappedBy = "lesson",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<LessonResource> resources;
    @OneToMany(mappedBy = "lesson")
    private List<LessonResource> lessonResources;
}

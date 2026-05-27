package phucitdev.course.modules.material.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phucitdev.course.commo.base.BaseEntity;
import phucitdev.course.modules.classrooms.entity.Classroom;
import phucitdev.course.modules.lessons.entity.Lesson;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Material extends BaseEntity {
      private String title;
      private String description;
    @ManyToMany(mappedBy = "materials")
    private List<Classroom> classrooms;
    @OneToMany(
            mappedBy = "material",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Lesson> lessons;
}

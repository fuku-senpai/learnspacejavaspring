package phucitdev.course.modules.snap_classroommaterial.entity;

import jakarta.persistence.*;
import lombok.*;
import phucitdev.course.commo.base.BaseEntity;
import phucitdev.course.modules.classrooms.entity.Classroom;
import phucitdev.course.modules.snap_lesson.entity.SnapLesson;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "snap_classroom_materials")
public class SnapClassroomMaterial extends BaseEntity {
    // lớp học sở hữu chủ đề này
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;
    // lưu id material gốc để trace nguồn
    @Column(nullable = false)
    private UUID sourceMaterialId;
    @Column(nullable = false)
    private Integer materialOrder;
    // snapshot data
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;


    // các buổi học đã clone
    @OneToMany(
            mappedBy = "snapClassroomMaterial",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SnapLesson> snapLessons = new ArrayList<>();
}

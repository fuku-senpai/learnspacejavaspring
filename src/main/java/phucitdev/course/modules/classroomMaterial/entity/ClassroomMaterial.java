package phucitdev.course.modules.classroomMaterial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phucitdev.course.commo.base.BaseEntity;
import phucitdev.course.modules.classrooms.entity.Classroom;
import phucitdev.course.modules.material.entity.Material;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "classroom_materials")
public class ClassroomMaterial extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

//    @ManyToOne
//    @JoinColumn(name = "material_id")
//    private Material material;
    private Integer displayOrder;
}
////  Hướng làm mới tạo bảng sao cho từng bảng
//==> copy toàn bộ dữ liệu gốc sang bảng phụ cho runtime
package phucitdev.course.modules.classroomMaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phucitdev.course.modules.classroomMaterial.entity.ClassroomMaterial;
import phucitdev.course.modules.material.dto.GetMaterialsOfClassroom;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClassroomMaterialRepository extends JpaRepository<ClassroomMaterial, UUID> {
//    @Query("""
//        SELECT new phucitdev.course.modules.material.dto.GetMaterialsOfClassroom(
//            cm.id,
//            m.title,
//            m.description,
//            cm.displayOrder,
//            m.createdAt,
//            m.updatedAt
//        )
//        FROM ClassroomMaterial cm
//        JOIN cm.material m
//        WHERE cm.classroom.id = :classroomId
//        AND cm.isDeleted = false
//        ORDER BY cm.displayOrder ASC
//    """)
//    List<GetMaterialsOfClassroom> getMaterialsByClassroomId(UUID classroomId);
//    Optional<ClassroomMaterial> findByIdAndIsDeletedFalse(UUID id);
//    boolean existsByClassroomIdAndMaterialIdAndIsDeletedFalse(
//            UUID classroomId,
//            UUID materialId
//    );
//    Optional<ClassroomMaterial> findByClassroomIdAndMaterialId(
//            UUID classroomId,
//            UUID materialId
//    );
//    @Query("""
//    SELECT COUNT(cm) > 0
//    FROM ClassroomMaterial cm
//    JOIN cm.classroom c
//    WHERE cm.material.id = :materialId
//    AND cm.isDeleted = false
//    AND c.status <> 'CLOSED'
//""")
//    boolean isMaterialBeingUsedInNonClosedClassroom(
//            UUID materialId
//    );
}

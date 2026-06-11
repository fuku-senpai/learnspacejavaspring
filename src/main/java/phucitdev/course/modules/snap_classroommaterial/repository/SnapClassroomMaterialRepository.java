package phucitdev.course.modules.snap_classroommaterial.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import phucitdev.course.modules.snap_classroommaterial.entity.SnapClassroomMaterial;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SnapClassroomMaterialRepository extends JpaRepository<SnapClassroomMaterial, UUID> {
    boolean existsByClassroomIdAndSourceMaterialIdAndIsDeletedFalse(
            UUID classroomId,
            UUID sourceMaterialId
    );
    boolean existsByClassroomIdAndMaterialOrderAndIsDeletedFalse(
            UUID classroomId,
            Integer materialOrder
    );
    List<SnapClassroomMaterial> findAllByClassroomIdAndIsDeletedFalseOrderByMaterialOrderAsc(UUID classroomId);
    Optional<SnapClassroomMaterial> findByClassroomIdAndMaterialOrderAndIsDeletedFalse(
            UUID classroomId,
            Integer order
    );
    Optional<SnapClassroomMaterial> findByIdAndIsDeletedFalse(UUID id);

    @EntityGraph(attributePaths = {"snapLessons"})
    List<SnapClassroomMaterial> findByClassroomIdAndIsDeletedFalseOrderByMaterialOrderAsc(UUID classroomId);
}

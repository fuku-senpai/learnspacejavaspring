package phucitdev.course.modules.material.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import phucitdev.course.modules.material.dto.GetMaterialsOfClassroom;
import phucitdev.course.modules.material.dto.MaterialResponse;
import phucitdev.course.modules.material.entity.Material;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface MaterialRepository extends JpaRepository<Material, UUID> {

    @Query("""
    SELECT new phucitdev.course.modules.material.dto.MaterialResponse(
        m.id,
        m.title,
        m.description,
        m.createdAt,
        m.updatedAt
    )
    FROM Material m
    WHERE m.isDeleted = false
    AND
        (:title IS NULL OR :title = '' 
            OR LOWER(m.title) LIKE LOWER(CONCAT('%', :title, '%')))
""")
    Page<MaterialResponse> search(
            @Param("title") String title,
            Pageable pageable
    );
    Optional<Material> findByIdAndIsDeletedFalse(UUID materialId);
    boolean existsByTitleAndIsDeletedFalseAndIdNot(  String title, UUID materialId);
    List<Material> findAllByIdInAndIsDeletedFalse(List<UUID> ids);
}

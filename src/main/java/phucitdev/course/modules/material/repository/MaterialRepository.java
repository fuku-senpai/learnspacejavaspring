package phucitdev.course.modules.material.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phucitdev.course.modules.material.dto.GetMaterialsOfClassroom;
import phucitdev.course.modules.material.entity.Material;

import java.util.List;
import java.util.UUID;
public interface MaterialRepository extends JpaRepository<Material, UUID> {
    @Query("""
        SELECT COUNT(m) > 0
        FROM Classroom c
        JOIN c.materials m
        WHERE c.id = :classroomId
        AND LOWER(TRIM(m.title))
            = LOWER(TRIM(:title))
    """)
    boolean existsByTitleAndClassroom(
            UUID classroomId,
            String title
    );
    @Query("""
        SELECT new
        phucitdev.course.modules.material.dto.GetMaterialsOfClassroom(
            m.id,
            m.title,
            m.description,
            SIZE(m.lessons)
        )
        FROM Classroom c
        JOIN c.materials m
        WHERE c.id = :classroomId
    """)
    Page<GetMaterialsOfClassroom> getMaterialsOfClassroom(UUID classroomId, Pageable pageable);
}

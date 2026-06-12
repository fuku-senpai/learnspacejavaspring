package phucitdev.course.modules.classSchedule.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import phucitdev.course.modules.classSchedule.dto.GetClassScheduleResponse;
import phucitdev.course.modules.classSchedule.entity.ClassSchedule;
import phucitdev.course.modules.classrooms.entity.ClassroomStatus;
import phucitdev.course.modules.teacherProfile.dto.TeacherScheduleResponse;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, UUID> {
    boolean existsByClassroomIdAndDayOfWeekAndStartTimeAndEndTimeAndIsDeletedFalse(
            UUID classroomId,
            DayOfWeek dayOfWeek,
            LocalTime startTime,
            LocalTime endTime
    );
    boolean existsByClassroomIdAndDayOfWeekAndStartTimeAndEndTimeAndIdNotAndIsDeletedFalse(
            UUID classroomId,
            DayOfWeek dayOfWeek,
            LocalTime startTime,
            LocalTime endTime,
            UUID id
    );
    @Query("""
    SELECT new phucitdev.course.modules.classSchedule.dto.GetClassScheduleResponse(
        cs.id,
        cs.dayOfWeek,
        cs.startTime,
        cs.endTime,
        cs.studyMode,
        cs.location,
        cs.meetingUrl
    )
    FROM ClassSchedule cs
    WHERE cs.isDeleted = false
    AND cs.classroom.id = :classroomId
""")
    List<GetClassScheduleResponse> getClassSchedule(UUID classroomId);
    List<ClassSchedule> findByClassroomId(UUID classroomId);


    @Query("""
            SELECT new phucitdev.course.modules.teacherProfile.dto.TeacherScheduleResponse(
                c.id,
                c.name,
                c.code,
                c.status,
                c.startDate,
                c.endDate,
                cs.dayOfWeek,
                cs.startTime,
                cs.endTime,
                cs.studyMode,
                cs.location,
                cs.meetingUrl
            )
            FROM ClassSchedule cs
            JOIN cs.classroom c
            JOIN c.teacherProfile t
            WHERE t.id = :teacherId
            AND (
                :status IS NULL
                OR c.status = :status
            )
            """)
    Page<TeacherScheduleResponse> getTeacherSchedules(
            @Param("teacherId") UUID teacherId,
            @Param("status") ClassroomStatus status,
            Pageable pageable
    );
}

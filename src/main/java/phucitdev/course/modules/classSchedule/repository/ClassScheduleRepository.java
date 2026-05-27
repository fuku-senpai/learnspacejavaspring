package phucitdev.course.modules.classSchedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phucitdev.course.modules.classSchedule.dto.GetClassScheduleResponse;
import phucitdev.course.modules.classSchedule.entity.ClassSchedule;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, UUID> {
    boolean existsByClassroomIdAndDayOfWeekAndStartTimeAndEndTime(
            UUID classroomId,
            DayOfWeek dayOfWeek,
            LocalTime startTime,
            LocalTime endTime
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
    WHERE cs.classroom.id = :classroomId
""")
    List<GetClassScheduleResponse> getClassSchedule(UUID classroomId);
    List<ClassSchedule> findByClassroomId(UUID classroomId);
}

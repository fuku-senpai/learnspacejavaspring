package phucitdev.course.modules.classrooms.service;

import org.springframework.data.domain.Pageable;
import phucitdev.course.modules.classrooms.dto.*;

import java.util.List;

public interface ClassroomService {
    CreateClassroomResponse createNewClass(CreateClassroomRequest createClassRequest);
    GetClassesResponse getClasses(Pageable pageable, String code, String name);
    EnrollingClassroomResponse enrollingClassroom(EnrollingClassroomRequest enrollingClassroomRequest);
    List<ClassResponse> getMyClasses();
}

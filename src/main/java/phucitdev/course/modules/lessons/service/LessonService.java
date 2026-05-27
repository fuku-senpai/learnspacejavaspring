package phucitdev.course.modules.lessons.service;

import phucitdev.course.modules.lessons.dto.CreateNewLessonRequest;
import phucitdev.course.modules.lessons.dto.CreateNewLessonResponse;
import phucitdev.course.modules.lessons.dto.LessonResponse;

import java.util.List;
import java.util.UUID;

public interface LessonService {
    CreateNewLessonResponse createNewLesson(CreateNewLessonRequest request);
    List<LessonResponse> findAllLessons(UUID materialId);
}

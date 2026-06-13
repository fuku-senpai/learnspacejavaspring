package phucitdev.course.modules.lessons.service;

import phucitdev.course.modules.lessons.dto.*;

import java.util.List;
import java.util.UUID;

public interface LessonService {
    CreateNewLessonResponse createNewLesson(CreateNewLessonRequest request);
    List<LessonResponse> findAllLessons(UUID materialId);
    UpdateLessonResponse updateLesson(
            UUID lessonId,
            UpdateLessonRequest request
    );
    DeleteLessonResponse deleteLesson(
            UUID lessonId
    );
}

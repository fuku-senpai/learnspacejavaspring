package phucitdev.course.modules.lessonResource.service;

import phucitdev.course.modules.lessonResource.dto.*;

import java.util.List;
import java.util.UUID;
public interface LessonResourceService {
    CreateLessonResourceResponse createLessonResource(CreateLessonResourceRequest createLessonResourceRequest);
    List<GetLessonResourceResponse> getLessonResources(UUID snapLessonId);
    DeleteLessonResourceResponse deleteLessonResource(UUID lessonResourceId);
    UpdateLessonResourceResponse updateLessonResource(UUID lessonResourceId, UpdateLessonResourceRequest updateLessonResourceRequest);
}

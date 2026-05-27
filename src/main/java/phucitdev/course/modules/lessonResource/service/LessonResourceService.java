package phucitdev.course.modules.lessonResource.service;

import phucitdev.course.modules.lessonResource.dto.CreateLessonResourceRequest;
import phucitdev.course.modules.lessonResource.dto.CreateLessonResourceResponse;
import phucitdev.course.modules.lessonResource.dto.GetLessonResourceResponse;

import java.util.List;
import java.util.UUID;

public interface LessonResourceService {
    CreateLessonResourceResponse createLessonResource(CreateLessonResourceRequest createLessonResourceRequest);
    List<GetLessonResourceResponse> getLessonResources(UUID lessonId);
}

package phucitdev.course.modules.lessonVideo.service;

import jakarta.validation.Valid;
import phucitdev.course.modules.lessonVideo.dto.CreateLessonVideoRequest;
import phucitdev.course.modules.lessonVideo.dto.CreateLessonVideoResponse;
import phucitdev.course.modules.lessonVideo.dto.GetLessonVideoResponse;

import java.util.List;
import java.util.UUID;

public interface LessonVideoService {
    CreateLessonVideoResponse createLessonVideo(CreateLessonVideoRequest createLessonVideoRequest);
    List<GetLessonVideoResponse> getVideos(UUID lessonId);
}

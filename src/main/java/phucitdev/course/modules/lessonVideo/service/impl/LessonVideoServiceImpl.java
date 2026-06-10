package phucitdev.course.modules.lessonVideo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phucitdev.course.commo.exception.classroom.NotFoundException;
import phucitdev.course.modules.lessonVideo.dto.CreateLessonVideoRequest;
import phucitdev.course.modules.lessonVideo.dto.CreateLessonVideoResponse;
import phucitdev.course.modules.lessonVideo.dto.GetLessonVideoResponse;
import phucitdev.course.modules.lessonVideo.entity.LessonVideo;
import phucitdev.course.modules.lessonVideo.repository.LessonVideoRepository;
import phucitdev.course.modules.lessonVideo.service.LessonVideoService;
import phucitdev.course.modules.lessons.entity.Lesson;
import phucitdev.course.modules.lessons.repository.LessonRepository;
import phucitdev.course.modules.snap_lesson.entity.SnapLesson;
import phucitdev.course.modules.snap_lesson.repository.SnapLessonRepository;

import java.util.List;
import java.util.UUID;

@Service
public class LessonVideoServiceImpl implements LessonVideoService {
    @Autowired
    SnapLessonRepository snapLessonRepository;
    @Autowired
    LessonVideoRepository lessonVideoRepository;
    @Override
    public CreateLessonVideoResponse createLessonVideo(CreateLessonVideoRequest createLessonVideoRequest) {
        SnapLesson snapLesson = snapLessonRepository.findById(createLessonVideoRequest.getSnapLessonId()).orElseThrow(() ->
                new NotFoundException("Lesson không tìm thấy"));
        LessonVideo lessonVideo = new LessonVideo();
        lessonVideo.setSnapLesson(snapLesson);
        lessonVideo.setTitle(createLessonVideoRequest.getTitle());
        lessonVideo.setVideoUrl("abc");
        lessonVideo.setFileKey(createLessonVideoRequest.getFileKey());
        lessonVideoRepository.save(lessonVideo);
        return new CreateLessonVideoResponse("LessonVideo đã tạo thành công!");
    }
    @Override
    public List<GetLessonVideoResponse> getVideos(UUID snapLessonId) {
        snapLessonRepository.findById(snapLessonId)
                .orElseThrow(() ->
                        new NotFoundException("SnapLesson không tồn tại"));
        return lessonVideoRepository.findBySnapLessonId(snapLessonId);
    }
}

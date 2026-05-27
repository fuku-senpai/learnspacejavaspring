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

import java.util.List;
import java.util.UUID;

@Service
public class LessonVideoServiceImpl implements LessonVideoService {
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    LessonVideoRepository lessonVideoRepository;
    @Override
    public CreateLessonVideoResponse createLessonVideo(CreateLessonVideoRequest createLessonVideoRequest) {
        Lesson lesson = lessonRepository.findById(createLessonVideoRequest.getLessonId()).orElseThrow(() ->
                new NotFoundException("Lesson không tìm thấy"));
        LessonVideo lessonVideo = new LessonVideo();
        lessonVideo.setLesson(lesson);
        lessonVideo.setTitle(createLessonVideoRequest.getTitle());
        lessonVideo.setVideoUrl(createLessonVideoRequest.getVideoUrl());
        lessonVideoRepository.save(lessonVideo);
        return new CreateLessonVideoResponse("LessonVideo đã tạo thành công!");
    }
    @Override
    public List<GetLessonVideoResponse> getVideos(UUID lessonId) {
        lessonRepository.findById(lessonId)
                .orElseThrow(() ->
                        new NotFoundException("Lesson không tồn tại"));
        return lessonVideoRepository.findByLessonId(lessonId);
    }
}

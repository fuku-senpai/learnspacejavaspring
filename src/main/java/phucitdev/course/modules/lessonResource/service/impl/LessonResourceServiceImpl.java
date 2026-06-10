package phucitdev.course.modules.lessonResource.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phucitdev.course.commo.exception.classroom.NotFoundException;
import phucitdev.course.modules.LessonResourceUrl.entity.LessonResourceUrl;
import phucitdev.course.modules.lessonResource.dto.CreateLessonResourceRequest;
import phucitdev.course.modules.lessonResource.dto.CreateLessonResourceResponse;
import phucitdev.course.modules.lessonResource.dto.GetLessonResourceResponse;
import phucitdev.course.modules.lessonResource.entity.LessonResource;
import phucitdev.course.modules.lessonResource.repository.LessonResourceRepository;
import phucitdev.course.modules.lessonResource.service.LessonResourceService;
import phucitdev.course.modules.snap_lesson.entity.SnapLesson;
import phucitdev.course.modules.snap_lesson.repository.SnapLessonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LessonResourceServiceImpl implements LessonResourceService {
    @Autowired
    LessonResourceRepository lessonResourceRepository;
    @Autowired
    SnapLessonRepository snapLessonRepository;
    @Override
    public CreateLessonResourceResponse createLessonResource(CreateLessonResourceRequest createLessonResourceRequest) {
        SnapLesson snapLesson = snapLessonRepository.findById(createLessonResourceRequest.getSnapLessonId()).orElseThrow(() ->
                new NotFoundException("SnapLessonId không tìm thấy"));
        LessonResource lessonResource = new LessonResource();
        lessonResource.setTitle(createLessonResourceRequest.getTitle());
        lessonResource.setType(createLessonResourceRequest.getType());
        lessonResource.setNote(createLessonResourceRequest.getNote());
        lessonResource.setSnapLesson(snapLesson);
        List<LessonResourceUrl>  lessonResourceUrls = new ArrayList<>();
        for(String url: createLessonResourceRequest.getUrls()){
            LessonResourceUrl lessonResourceUrl = new LessonResourceUrl();
              lessonResourceUrl.setUrl(url);
              lessonResourceUrl.setLessonResource(lessonResource);
            lessonResourceUrls.add(lessonResourceUrl);
        }
        lessonResource.setLessonResourceUrls(lessonResourceUrls);
        lessonResourceRepository.save(lessonResource);
        return new CreateLessonResourceResponse("Tạo resource thành công!");
    }

    @Override
    public List<GetLessonResourceResponse> getLessonResources(UUID snapLessonId) {
        snapLessonRepository.findById(snapLessonId).orElseThrow(() -> new NotFoundException("SnapLesson không tồn tại"));
        return lessonResourceRepository
                .getLessonResources(snapLessonId)
                .stream()
                .map(lr -> new GetLessonResourceResponse(
                        lr.getId(),
                        lr.getTitle(),
                        lr.getNote(),
                        lr.getType(),
                        lr.getLessonResourceUrls()
                                .stream()
                                .map(
                                        LessonResourceUrl::getUrl
                                )
                                .toList()
                ))
                .toList();
    }
}

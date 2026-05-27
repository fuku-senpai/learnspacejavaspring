package phucitdev.course.modules.lessons.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phucitdev.course.commo.exception.classroom.NotFoundException;
import phucitdev.course.modules.lessons.dto.CreateNewLessonRequest;
import phucitdev.course.modules.lessons.dto.CreateNewLessonResponse;
import phucitdev.course.modules.lessons.dto.LessonResponse;
import phucitdev.course.modules.lessons.entity.Lesson;
import phucitdev.course.modules.lessons.repository.LessonRepository;
import phucitdev.course.modules.lessons.service.LessonService;
import phucitdev.course.modules.material.entity.Material;
import phucitdev.course.modules.material.repository.MaterialRepository;

import java.util.List;
import java.util.UUID;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    MaterialRepository materialRepository;
    @Autowired
    LessonRepository lessonRepository;
    @Override
    public CreateNewLessonResponse createNewLesson(CreateNewLessonRequest request) {
        Material material = materialRepository.findById(request.getMaterialId()).orElseThrow(() ->
                        new NotFoundException("Material không tìm thấy"));
        Lesson lesson = new Lesson();
        lesson.setTitle(request.getTitle());
        lesson.setLessonOrder(
                request.getLessonOrder()
        );
        lesson.setMaterial(material);
        lessonRepository.save(lesson);
        return new CreateNewLessonResponse("Tạo buổi học thành công!");
    }

    @Override
    public List<LessonResponse> findAllLessons(UUID materialId) {
        return lessonRepository
                .getLessonsByMaterialId(
                        materialId
                );
    }

}

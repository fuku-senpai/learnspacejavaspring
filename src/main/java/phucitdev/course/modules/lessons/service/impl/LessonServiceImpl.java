package phucitdev.course.modules.lessons.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phucitdev.course.commo.exception.auth.BadRequestException;
import phucitdev.course.commo.exception.classroom.NotFoundException;
import phucitdev.course.modules.lessons.dto.*;
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
    @Override
    @Transactional
    public UpdateLessonResponse updateLesson(
            UUID lessonId,
            UpdateLessonRequest request
    ) {

        try {

            Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() ->
                                    new NotFoundException("Không tìm thấy bài học"));

            lesson.setTitle(request.getTitle());
            lesson.setLessonOrder(request.getLessonOrder());
            lessonRepository.save(lesson);
            return new UpdateLessonResponse("Cập nhật bài học thành công!");
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public DeleteLessonResponse deleteLesson(UUID lessonId) {
        try {
            Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() -> new NotFoundException("Không tìm thấy bài học"));
            lesson.setIsDeleted(true);
            lessonRepository.save(lesson);
            return new DeleteLessonResponse("Xóa bài học thành công!");
        } catch (Exception e) {

            throw new BadRequestException(
                    e.getMessage()
            );
        }
    }
}

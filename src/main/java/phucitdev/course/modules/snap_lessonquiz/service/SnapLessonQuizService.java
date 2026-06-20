package phucitdev.course.modules.snap_lessonquiz.service;

import phucitdev.course.modules.snap_lessonquiz.dto.DeleteSnapLessonQuizResponse;

import java.util.UUID;

public interface SnapLessonQuizService {
    DeleteSnapLessonQuizResponse deleteSnapLessonQuiz(UUID snapLessonQuizId);
}

package phucitdev.course.modules.lesson_quiz.service;

import org.springframework.data.domain.Page;
import phucitdev.course.modules.lesson_quiz.dto.CreateLessonQuizRequest;
import phucitdev.course.modules.lesson_quiz.dto.CreateLessonQuizResponse;
import phucitdev.course.modules.lesson_quiz.dto.GetLessonQuizResponse;
import phucitdev.course.modules.lesson_quiz.dto.assignQuiz.*;
import phucitdev.course.modules.lesson_quiz.dto.quiz_bank.QuizDetailResponse;
import phucitdev.course.modules.lesson_quiz.dto.quiz_bank.QuizListResponse;
import phucitdev.course.modules.lesson_quiz.dto.result_quiz.QuizResultResponse;
import phucitdev.course.modules.lesson_quiz.dto.student_submit.SubmitQuizRequest;
import phucitdev.course.modules.lesson_quiz.dto.student_submit.SubmitQuizResponse;
import phucitdev.course.modules.lesson_quiz.entity.QuizType;

import java.util.List;
import java.util.UUID;

public interface LessonQuizService {
    CreateLessonQuizResponse createQuiz(CreateLessonQuizRequest request);
    GetLessonQuizResponse getQuizzes(UUID quizId);
    SubmitQuizResponse submitQuiz(UUID snapLessonQuizId, SubmitQuizRequest request);
    QuizResultResponse getQuizResult(UUID snapLessonQuizId);
    Page<QuizListResponse> getMyQuizzes(int page, int size, String title, QuizType quizType);
    AssignQuizResponse assignQuiz(AssignQuizRequest request);
    List<LessonAssignedQuizResponse> getAssignedQuizzes(UUID snapLessonId);
    QuizDetailResponse getQuizDetail(UUID quizId);
    UpdateAssignedQuizResponse updateAssignedQuiz(UUID snapLessonQuizId, UpdateAssignedQuizRequest request);
}

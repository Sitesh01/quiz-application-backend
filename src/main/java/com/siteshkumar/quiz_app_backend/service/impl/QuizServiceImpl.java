package com.siteshkumar.quiz_app_backend.service.impl;

import java.util.stream.Collectors;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.siteshkumar.quiz_app_backend.dto.QuizDTO;
import com.siteshkumar.quiz_app_backend.entity.QuizEntity;
import com.siteshkumar.quiz_app_backend.mapper.QuizMapper;
import com.siteshkumar.quiz_app_backend.repository.QuizRepository;
import com.siteshkumar.quiz_app_backend.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    // Constructor injection (preferred)
    public QuizServiceImpl(QuizRepository quizRepository){
        this.quizRepository = quizRepository;
    }

    @Override
    public ResponseEntity<Boolean> createQuiz(String title) {
        try {
            QuizEntity quiz = new QuizEntity();
            quiz.setTitle(title);

            quizRepository.save(quiz);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(false);
        }
    }

    @Override
    public ResponseEntity<?> getAllQuizzes(){
        try {
            List<QuizEntity> quizzes = quizRepository.findAll();

            List<QuizDTO> quizDtos = quizzes
                                    .stream()
                                    .map(QuizMapper::entityToDto)
                                    .collect(Collectors.toList());

            return ResponseEntity.ok(quizDtos);
        }

        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error fetching quizzes");
        }
    }
}

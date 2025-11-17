package com.siteshkumar.quiz_app_backend.service;

import org.springframework.http.ResponseEntity;
import com.siteshkumar.quiz_app_backend.dto.QuestionDTO;

public interface QuestionService {
    
    public ResponseEntity<String> addQuestionInQuiz(Long quizId, QuestionDTO questionDto);
    public ResponseEntity<?> getQuestionsByQuizId(Long quizId);
}

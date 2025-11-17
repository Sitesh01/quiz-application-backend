package com.siteshkumar.quiz_app_backend.service;

import org.springframework.http.ResponseEntity;

public interface QuizService {
    
    ResponseEntity<Boolean> createQuiz(String title);
    public ResponseEntity<?> getAllQuizzes();
}

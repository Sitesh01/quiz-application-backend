package com.siteshkumar.quiz_app_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.siteshkumar.quiz_app_backend.dto.QuizDTO;
import com.siteshkumar.quiz_app_backend.service.QuizService;

@RestController
@RequestMapping("/api/v1/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }


    @PostMapping("/create")
    public ResponseEntity<Boolean> createQuiz(@RequestBody QuizDTO quizDto) {
        return quizService.createQuiz(quizDto.getTitle());
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllQuizzes(){
        return quizService.getAllQuizzes();
    }
}

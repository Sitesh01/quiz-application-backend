package com.siteshkumar.quiz_app_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.siteshkumar.quiz_app_backend.dto.QuestionDTO;
import com.siteshkumar.quiz_app_backend.service.QuestionService;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
    
    private final QuestionService questionService;
    
    public QuestionController (QuestionService questionService){
        this.questionService = questionService;
    }

    @PostMapping("/add/{quizId}")
    public ResponseEntity<String> addQuestionInQuiz(@PathVariable Long quizId, @RequestBody QuestionDTO questionDto){
        return questionService.addQuestionInQuiz(quizId, questionDto);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsByQuizId(@PathVariable Long quizId){
        return questionService.getQuestionsByQuizId(quizId);
    }
}

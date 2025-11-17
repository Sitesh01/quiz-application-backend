package com.siteshkumar.quiz_app_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.siteshkumar.quiz_app_backend.dto.ScoreDTO;
import com.siteshkumar.quiz_app_backend.dto.SubmitScoreDTO;
import com.siteshkumar.quiz_app_backend.service.QuizAttemptService;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizAttemptController {
    
    private final QuizAttemptService quizAttemptService;

    public QuizAttemptController(QuizAttemptService quizAttemptService){
        this.quizAttemptService = quizAttemptService;
    }

    @PostMapping("/submit")
    public ResponseEntity<ScoreDTO> submitScore(@RequestBody SubmitScoreDTO dto){
        return quizAttemptService.submitScore(dto);
    }
}

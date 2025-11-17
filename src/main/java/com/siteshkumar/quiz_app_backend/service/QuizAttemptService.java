package com.siteshkumar.quiz_app_backend.service;

import org.springframework.http.ResponseEntity;
import com.siteshkumar.quiz_app_backend.dto.ScoreDTO;
import com.siteshkumar.quiz_app_backend.dto.SubmitScoreDTO;

public interface QuizAttemptService {
    
    public ResponseEntity<ScoreDTO> submitScore(SubmitScoreDTO dto);
}

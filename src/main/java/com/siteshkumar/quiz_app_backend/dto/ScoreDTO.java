package com.siteshkumar.quiz_app_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreDTO {
    
    private int score;
    private int total;
}

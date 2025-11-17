package com.siteshkumar.quiz_app_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAnswerDTO {
    
    private Long answerId;
    private Long quizId;
    private Long questionId;
    private Long optionId;
}

package com.siteshkumar.quiz_app_backend.dto;

import java.util.List;
import lombok.Data;

@Data
public class SubmitScoreDTO {

    private Long quizId;

    private List<AnswerItem> answers;

    @Data
    public static class AnswerItem {

        private Long questionId;
        private Long selectedOptionId;
    }
    
}

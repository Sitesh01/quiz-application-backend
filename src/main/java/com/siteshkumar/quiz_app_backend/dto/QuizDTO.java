package com.siteshkumar.quiz_app_backend.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {
    private Long quizId;
    private String title;
    private List<QuestionDTO> questions;
}

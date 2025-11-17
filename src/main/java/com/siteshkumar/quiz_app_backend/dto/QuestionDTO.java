package com.siteshkumar.quiz_app_backend.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Long questionId;
    private String text;
    private String type;
    private List<OptionDTO> options;
}

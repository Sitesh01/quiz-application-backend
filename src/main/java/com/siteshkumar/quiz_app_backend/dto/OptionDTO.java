package com.siteshkumar.quiz_app_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionDTO {
    
    private Long optionId;
    private String text;
    private boolean correct;
}

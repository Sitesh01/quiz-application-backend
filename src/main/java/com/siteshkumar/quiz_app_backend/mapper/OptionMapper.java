package com.siteshkumar.quiz_app_backend.mapper;

import com.siteshkumar.quiz_app_backend.dto.OptionDTO;
import com.siteshkumar.quiz_app_backend.entity.OptionEntity;
import com.siteshkumar.quiz_app_backend.entity.QuestionEntity;

public class OptionMapper {

    public static OptionDTO entityToDTO(OptionEntity entity) {
        if(entity == null) return null;

        return new OptionDTO(
            entity.getOptionId(),
            entity.getText(),
            entity.isCorrect()
        );
    };


    public static OptionEntity dtoToEntity(OptionDTO dto, QuestionEntity question) {
        if(dto == null) return null;
        
        OptionEntity entity = new OptionEntity();
        entity.setOptionId(dto.getOptionId());
        entity.setText(dto.getText());
        entity.setCorrect(dto.isCorrect());
        entity.setQuestion(question);
        return entity;
    }
}

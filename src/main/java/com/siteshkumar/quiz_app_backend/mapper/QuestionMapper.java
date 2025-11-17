package com.siteshkumar.quiz_app_backend.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.siteshkumar.quiz_app_backend.dto.OptionDTO;
import com.siteshkumar.quiz_app_backend.dto.QuestionDTO;
import com.siteshkumar.quiz_app_backend.entity.QuestionEntity;
import com.siteshkumar.quiz_app_backend.entity.QuizEntity;

public class QuestionMapper {

    public static QuestionDTO entityToDto(QuestionEntity entity) {
        if(entity == null) return null;

        List<OptionDTO> optionDTOs = entity.getOptions() != null ? entity.getOptions()
                                .stream()
                                .map(OptionMapper :: entityToDTO)
                                .collect(Collectors.toList()) : new ArrayList<>();

        return new QuestionDTO(
                entity.getQuestionId(),
                entity.getText(),
                entity.getType(),
                optionDTOs
        );
    }


    public static QuestionEntity dtoToEntity(QuestionDTO dto, QuizEntity quiz) {
        if (dto == null) return null;

        QuestionEntity entity = new QuestionEntity();
        entity.setQuestionId(dto.getQuestionId());
        entity.setText(dto.getText());
        entity.setType(dto.getType());
        entity.setQuiz(quiz); // <-- linking parent quiz

        return entity;
    }
}

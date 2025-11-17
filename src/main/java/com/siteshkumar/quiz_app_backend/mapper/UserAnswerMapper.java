package com.siteshkumar.quiz_app_backend.mapper;

import com.siteshkumar.quiz_app_backend.dto.UserAnswerDTO;
import com.siteshkumar.quiz_app_backend.entity.OptionEntity;
import com.siteshkumar.quiz_app_backend.entity.QuestionEntity;
import com.siteshkumar.quiz_app_backend.entity.QuizEntity;
import com.siteshkumar.quiz_app_backend.entity.UserAnswerEntity;

public class UserAnswerMapper {

    public static UserAnswerEntity dtoToEntity(
            UserAnswerDTO dto,
            QuizEntity quiz,
            QuestionEntity question,
            OptionEntity option) {

        if(dto == null) return null;
        
        UserAnswerEntity entity = new UserAnswerEntity();
        entity.setAnswerId(dto.getAnswerId());
        entity.setQuiz(quiz);
        entity.setQuestion(question);
        entity.setOption(option);
        return entity;
    }

    public static UserAnswerDTO entityToDto(UserAnswerEntity entity) {
        if(entity == null) return null;

        return new UserAnswerDTO(
            entity.getAnswerId(),
            entity.getQuiz() != null ? entity.getQuiz().getQuizId() : null,
            entity.getQuestion() != null ? entity.getQuestion().getQuestionId() : null,
            entity.getOption() != null ? entity.getOption().getOptionId() : null
        );
    }
}

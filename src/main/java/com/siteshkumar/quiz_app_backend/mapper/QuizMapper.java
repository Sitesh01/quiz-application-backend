package com.siteshkumar.quiz_app_backend.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.siteshkumar.quiz_app_backend.dto.QuestionDTO;
import com.siteshkumar.quiz_app_backend.dto.QuizDTO;
import com.siteshkumar.quiz_app_backend.entity.QuizEntity;

public class QuizMapper {

    // Entity -> DTO
    public static QuizDTO entityToDto(QuizEntity entity) {
        if (entity == null) return null;

        List<QuestionDTO> questionDTOs = entity.getQuestions() != null ? entity.getQuestions()
                                        .stream()
                                        .map(QuestionMapper :: entityToDto)
                                        .collect(Collectors.toList()) : new ArrayList<>();

        return new QuizDTO(
            entity.getQuizId(),
            entity.getTitle(),
            questionDTOs
        );
    }

    // DTO -> Entity (basic fields only; relationships should be set in service layer)
    public static QuizEntity dtoToEntity(QuizDTO dto) {
        if (dto == null) return null;

        QuizEntity entity = new QuizEntity();
        entity.setQuizId(dto.getQuizId());
        entity.setTitle(dto.getTitle());
        // DO NOT set questions/userAnswers here from IDs — resolve entities in the service
        return entity;
    }
}

package com.siteshkumar.quiz_app_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_answers")
public class UserAnswerEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @ManyToOne
    @JoinColumn(name = "quizId", nullable = false)
    private QuizEntity quiz;

    @ManyToOne
    @JoinColumn(name = "questionId", nullable = false)
    private QuestionEntity question;

    @ManyToOne
    @JoinColumn(name = "optionId", nullable = false)
    private OptionEntity option;
}

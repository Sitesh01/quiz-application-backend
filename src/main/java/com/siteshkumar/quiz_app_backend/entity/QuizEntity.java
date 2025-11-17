package com.siteshkumar.quiz_app_backend.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="quizzes")
public class QuizEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    private String title;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)               // Inverse side
    private List<QuestionEntity> questions;

    @OneToMany(mappedBy =  "quiz", cascade = CascadeType.ALL, orphanRemoval = true)              // Inverse side
    private List<UserAnswerEntity> userAnswers;
}

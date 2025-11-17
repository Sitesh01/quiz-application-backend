package com.siteshkumar.quiz_app_backend.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="questions")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String text;
    private String type;

    @ManyToOne
    @JoinColumn(name = "quizId", nullable = false)        // Owning side
    private QuizEntity quiz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)        // Inverse side
    private List<OptionEntity> options;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)           // Inverse side
    private List<UserAnswerEntity> userAnswers;
}

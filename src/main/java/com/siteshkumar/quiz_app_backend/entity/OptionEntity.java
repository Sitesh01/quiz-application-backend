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
@Table(name="options")
public class OptionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    private String text;
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "questionId", nullable = false)            // Owning side
    private QuestionEntity question;

    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL, orphanRemoval = true)             // Inverse side
    private List<UserAnswerEntity> userAnswers;
}

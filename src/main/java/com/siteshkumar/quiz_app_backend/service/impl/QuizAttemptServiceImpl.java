package com.siteshkumar.quiz_app_backend.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.siteshkumar.quiz_app_backend.dto.ScoreDTO;
import com.siteshkumar.quiz_app_backend.dto.SubmitScoreDTO;
import com.siteshkumar.quiz_app_backend.entity.OptionEntity;
import com.siteshkumar.quiz_app_backend.entity.QuestionEntity;
import com.siteshkumar.quiz_app_backend.entity.QuizEntity;
import com.siteshkumar.quiz_app_backend.entity.UserAnswerEntity;
import com.siteshkumar.quiz_app_backend.repository.OptionRepository;
import com.siteshkumar.quiz_app_backend.repository.QuestionRepository;
import com.siteshkumar.quiz_app_backend.repository.QuizRepository;
import com.siteshkumar.quiz_app_backend.repository.UserAnswerRepository;
import com.siteshkumar.quiz_app_backend.service.QuizAttemptService;

@Service
public class QuizAttemptServiceImpl implements QuizAttemptService{
    
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;
    private final UserAnswerRepository userAnswerRepository;

    public QuizAttemptServiceImpl(QuizRepository quizRepository, QuestionRepository questionRepository, OptionRepository optionRepository, UserAnswerRepository userAnswerRepository){
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
        this.userAnswerRepository = userAnswerRepository;
    }

    @Override
    public ResponseEntity<ScoreDTO> submitScore(SubmitScoreDTO dto){
        QuizEntity quiz = quizRepository.findById(dto.getQuizId()).orElse(null);

        if(quiz == null)
            return ResponseEntity.badRequest().build();

        int score = 0;
        int total = dto.getAnswers().size();

        for(SubmitScoreDTO.AnswerItem item : dto.getAnswers()){
            QuestionEntity question = questionRepository.findById(item.getQuestionId()).orElse(null);

            if(question == null)
                continue;

            OptionEntity selectedOption = optionRepository.findById(item.getSelectedOptionId()).orElse(null);

            if(selectedOption == null)
                continue;

            if (selectedOption.isCorrect())
                score++;

            UserAnswerEntity userAnswer = new UserAnswerEntity();
            userAnswer.setQuiz(quiz);
            userAnswer.setQuestion(question);
            userAnswer.setOption(selectedOption);

            userAnswerRepository.save(userAnswer);
        }
        return ResponseEntity.ok(new ScoreDTO(score, total));
    }
}

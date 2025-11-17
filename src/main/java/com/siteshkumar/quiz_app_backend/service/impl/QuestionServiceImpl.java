package com.siteshkumar.quiz_app_backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.siteshkumar.quiz_app_backend.dto.QuestionDTO;
import com.siteshkumar.quiz_app_backend.entity.OptionEntity;
import com.siteshkumar.quiz_app_backend.entity.QuestionEntity;
import com.siteshkumar.quiz_app_backend.entity.QuizEntity;
import com.siteshkumar.quiz_app_backend.mapper.OptionMapper;
import com.siteshkumar.quiz_app_backend.mapper.QuestionMapper;
import com.siteshkumar.quiz_app_backend.repository.QuestionRepository;
import com.siteshkumar.quiz_app_backend.repository.QuizRepository;
import com.siteshkumar.quiz_app_backend.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
    
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, QuizRepository quizRepository){
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public ResponseEntity<String> addQuestionInQuiz(Long quizId, QuestionDTO questionDto){
        try {
            QuizEntity quiz = quizRepository.findById(quizId).orElse(null);

            if(quiz == null)
                return ResponseEntity.badRequest().body("Quiz not found!");

            QuestionEntity question = QuestionMapper.dtoToEntity(questionDto, quiz);

            List<OptionEntity> optionEntities = questionDto.getOptions()
                                            .stream()
                                            .map(optDto -> OptionMapper.dtoToEntity(optDto, question))
                                            .collect(Collectors.toList());

            question.setOptions(optionEntities);

            questionRepository.save(question);

            return ResponseEntity.ok("Question added successfully!");
        }

        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error adding questions");
        }
    }

    @Override
    public ResponseEntity<?> getQuestionsByQuizId(Long quizId){
        try {
            QuizEntity quiz = quizRepository.findById(quizId).orElse(null);

            if(quiz == null) 
                return ResponseEntity.badRequest().body("Quiz not found!");

            List<QuestionEntity> questions = quiz.getQuestions();

            List<QuestionDTO> questionDTOs = questions
                                            .stream()
                                            .map(QuestionMapper::entityToDto)
                                            .collect(Collectors.toList());

            return ResponseEntity.ok(questionDTOs);
        }

        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error fetching questions");
        }
    }
}

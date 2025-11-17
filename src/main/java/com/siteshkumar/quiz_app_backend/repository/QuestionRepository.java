package com.siteshkumar.quiz_app_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siteshkumar.quiz_app_backend.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long>{
    
}

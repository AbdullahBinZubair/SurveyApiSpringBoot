package com.spring.survey.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.survey.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	public List<Question> findBySurveyId(int id); 

}

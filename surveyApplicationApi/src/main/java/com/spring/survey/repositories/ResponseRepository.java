package com.spring.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.survey.models.Response;

public interface ResponseRepository extends JpaRepository<Response, Integer> {
	
	public Response findBySurveyId(int surveyId);  
	public Response findByQuestionId(int QuestionId); 
	public Response findByUser(String name);
	

}

package com.spring.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.survey.models.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
	

}

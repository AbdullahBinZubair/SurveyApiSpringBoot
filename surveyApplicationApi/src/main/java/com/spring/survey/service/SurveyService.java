package com.spring.survey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.survey.models.Survey;
import com.spring.survey.repositories.SurveyRepository;

@Service
public class SurveyService {

	@Autowired
	SurveyRepository surveyRepository;
	
	public List<Survey> showAll() {
		// TODO Auto-generated method stub
		List<Survey> survey=new ArrayList<>();
		surveyRepository.findAll().forEach(survey::add);
		System.out.println(survey);
		return survey;
	}
	

	public Survey showSurvey(int id) {
		// TODO Auto-generated method stub
		System.out.println("////////////////");
		return surveyRepository.findById(id).get();
		
		
	}

	public void deleteSurvey(int id) {
		// TODO Auto-generated method stub
		
		surveyRepository.deleteById(id);
		
	}
	
	

	
}

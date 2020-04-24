package com.spring.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.survey.models.Survey;
import com.spring.survey.service.SurveyService;

@RestController//("/survey")
public class SurveyController {

	@Autowired
	SurveyService surveyService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/show/survey/all",method = RequestMethod.GET)
	public List<Survey> showAll() {
	return surveyService.showAll();
		
	}
	
	
	@RequestMapping(value = "/show/survey/{id}",method = RequestMethod.GET)
	public Survey showSurvey(@PathVariable int id) {
		
		return surveyService.showSurvey(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/survey/{id}")
	public String deleteSurvey(@PathVariable int id)
	{
		surveyService.deleteSurvey(id);
		return ("deleted survey of id=" + id);
	}
}

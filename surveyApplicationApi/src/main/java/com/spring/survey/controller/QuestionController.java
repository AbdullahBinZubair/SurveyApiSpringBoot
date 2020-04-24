package com.spring.survey.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.survey.models.Question;
import com.spring.survey.models.Survey;
import com.spring.survey.service.QuestionService;
import com.spring.survey.service.SurveyService;
import com.spring.survey.service.Answer_typeService;

@RestController   
public class QuestionController {

	@Autowired
	QuestionService questionService;
	@Autowired
	private SurveyService surveyService;
	@Autowired
	private Answer_typeService typeService;
	
	@RequestMapping("/show/question/{id}")
	public List<Question> showAll(@PathVariable int id){
		System.out.println("///////////////////////////////////////////");
		return questionService.showAll(id);
		
	}
	


	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST ,value = "/add/{surveyid}/question")
	public String add(@RequestBody String json,@PathVariable int surveyid) {
		
		

		Survey survey=surveyService.showSurvey(surveyid);	
		
		questionService.save(json,survey);
		
				
		
		
		
		return ("added succesfully");
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(method = RequestMethod.PUT ,value = "/update/{surveyid}/question/{questionid}")
	public String update(@RequestBody String json,@PathVariable int surveyid,@PathVariable int questionid) {

		Survey survey=surveyService.showSurvey(surveyid);	
		
		questionService.save(json,survey);
		
		
		return ("update succesfully");
	}
	
}

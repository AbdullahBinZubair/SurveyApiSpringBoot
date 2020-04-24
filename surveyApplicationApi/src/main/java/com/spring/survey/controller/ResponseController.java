package com.spring.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.survey.models.Response;
import com.spring.survey.service.ResponseService;
import com.spring.survey.service.SurveyService;

@RestController
public class ResponseController {
	
	@Autowired 
	ResponseService responseService;
	@Autowired
	SurveyService surveyService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/response/survey/{surveyid}")
	public Response getBySurveyid(@PathVariable int surveyid) {
		
		
		return responseService.getBySurveyId(surveyid);
		
	
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/response/question/{Questionid}")
	public Response getByQuestionid(@PathVariable int Questionid) {
		
		
		return responseService.getByQuestionId(Questionid);
		
	
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/response/{Responseid}")
	public Response getByResponseid(@PathVariable int Responseid) {
		
		
		return responseService.getById(Responseid);
		
	
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/response/name/{name}")
	public Response getBySurveyid(@PathVariable String name) {
		
		
		return responseService.getByUserName(name);
		
	
	}
	
	@PostMapping(value = "/response/{responseid}/{surveyid}/{questionid}")
	public String addResponse(@RequestBody String json,@PathVariable int responseid,@PathVariable int surveyid,@PathVariable int questionid) {
		
		responseService.save(json,responseid,surveyid,questionid);
		
		return "successfully added";
	}
	
	

}

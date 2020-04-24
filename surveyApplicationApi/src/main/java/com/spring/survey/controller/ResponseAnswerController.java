package com.spring.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.survey.models.ResponseAnswer;
import com.spring.survey.service.ResponseAnswerService;

@RestController
public class ResponseAnswerController {

	@Autowired 
	ResponseAnswerService answerService;
	@GetMapping(value = "/answer/response/{responseID}")
	public List<ResponseAnswer> getresponseByresponseId(@PathVariable int responseID){
		
		return answerService.getByResponse(responseID);
		
	}
	
	@GetMapping(value = "/answer/{answerID}")
	public ResponseAnswer getByAnswerID (@PathVariable int answerID){
		
		return answerService.getByAnswerID(answerID);
		
	}
	
}

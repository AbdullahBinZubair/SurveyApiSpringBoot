package com.spring.survey.service;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.survey.models.Question;
import com.spring.survey.models.Response;
import com.spring.survey.models.ResponseAnswer;
import com.spring.survey.models.Survey;
import com.spring.survey.repositories.ResponseRepository;

@Service
public class ResponseService {
	
	@Autowired
	ResponseRepository responseRepository;
	@Autowired
	ResponseAnswerService responseAnswerService;
	@Autowired
	QuestionService questionService;
	@Autowired 
	SurveyService surveyService;
	
	
	public Response getBySurveyId(int surveyid) {
		// TODO Auto-generated method stub
		return responseRepository.findBySurveyId(surveyid);
		
	}
	public Response getByQuestionId(int id) {
		// TODO Auto-generated method stub
		return responseRepository.findByQuestionId(id);
		
	}
	public Response getById(int id) {
		// TODO Auto-generated method stub
		return responseRepository.findById(id).get();
		
	}
	public Response getByUserName(String name) {
		// TODO Auto-generated method stub
		
		return responseRepository.findByUser(name);

	}
	public void save(String json, int responseid, int surveyid, int questionid) {
		// TODO Auto-generated method stub
		
		
		Object obj=JSONValue.parse(json);  
	    JSONObject jsonObject = (JSONObject) obj;
	   
	    String user=(String) jsonObject.get("name");
	
	    Long lint=(Long) jsonObject.get("id");
	    int answerId=lint.intValue();
	    String answer=(String) jsonObject.get("answer");

	    
		
		
		Question question=questionService.getquestion(questionid);
		
		Survey   survey=surveyService.showSurvey(surveyid);
		
		Response response=new Response(responseid,user,survey,question);
		
		
		ResponseAnswer responseanswer=new ResponseAnswer(answerId,answer,response);
		
		responseRepository.save(response);
		responseAnswerService.save(responseanswer);
		
		
		
		
	}
	
	
}

package com.spring.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.survey.models.ResponseAnswer;
import com.spring.survey.repositories.ResponseAnswerRepository;

@Service
public class ResponseAnswerService {

	@Autowired
	ResponseAnswerRepository responseAnswerRepository;
	
	public void save(ResponseAnswer answer) {
		
		responseAnswerRepository.save(answer);
		
	}

	public List<ResponseAnswer> getByResponse(int responseID) {
		
		return responseAnswerRepository.findByResponseId(responseID);
	}
	public ResponseAnswer getByAnswerID(int responseID) {
		
		return responseAnswerRepository.findById(responseID).get();
	}
	
}

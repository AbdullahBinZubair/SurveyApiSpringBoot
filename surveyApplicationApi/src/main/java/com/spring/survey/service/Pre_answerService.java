package com.spring.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.spring.survey.controller.Question;
import com.spring.survey.models.Pre_answer;
import com.spring.survey.repositories.Pre_answerRepository;

@Service
public class Pre_answerService {
	
	@Autowired
	private Pre_answerRepository preRepository;

	public List<Pre_answer> getAll(int questionid) {
		// TODO Auto-generated method stub
		return preRepository.findByQuestionId(questionid);
	}

	public void save(Pre_answer newAnswer) {
		// TODO Auto-generated method stub
		preRepository.save(newAnswer);
	}

	public void delete(int answerid) {
		// TODO Auto-generated method stub
		preRepository.deleteById(answerid);
	}

	
}

package com.spring.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.survey.models.Pre_answer;
import com.spring.survey.models.Question;
import com.spring.survey.service.Pre_answerService;
import com.spring.survey.service.QuestionService;

@RestController
public class Pre_answerController {
	
	@Autowired
	private Pre_answerService answerService;
	@Autowired
	private QuestionService questionService;
	
	
	@RequestMapping(value = "/pre/answers/{questionid}")
	public List<Pre_answer> getAnswer(@PathVariable int questionid) {
		
		return answerService.getAll(questionid) ;
	}
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/add/pre/answers/{questionid}",method = RequestMethod.POST)
	public String add(@RequestBody Pre_answer newAnswer,@PathVariable int questionid) {
		Question question=questionService.getquestion(questionid);
		System.out.println("////////////"+question);
		newAnswer.setQuestion(question);
		answerService.save(newAnswer);
		return "saved successfully";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/update/{questionid}/pre/answers/{answerid}",method = RequestMethod.PUT)
	public String update(@RequestBody Pre_answer updateAnswer,@PathVariable int questionid,@PathVariable int answerid) {
		Question question=questionService.getquestion(questionid);
		System.out.println("////////////"+question);
		updateAnswer.setQuestion(question);
		 //throw exception if it exist or not
		answerService.save(updateAnswer);
		return "update successfully";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/delete/{answerid}")
	public String delete(@PathVariable int answerid) {
		
		answerService.delete(answerid);
		
		return "deleted";
		
	}
	
}

package com.spring.survey.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.survey.models.Answer_type;
import com.spring.survey.models.Pre_answer;
import com.spring.survey.models.Question;
import com.spring.survey.models.Survey;
import com.spring.survey.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	Pre_answerService preAnswerService;
	@Autowired
	Answer_typeService typeService;
	
	public List<Question> showAll(int id){
		
		return questionRepository.findBySurveyId(id);
		
	}


	
	
	public Question getquestion(int id) {
		
		return questionRepository.findById(id).get();
	}
	


	public String save(String json,Survey survey ) {
		// TODO Auto-generated method stub
		
		Object obj=JSONValue.parse(json);  
	    JSONObject jsonObject = (JSONObject) obj;
	    JSONObject jquestion=(JSONObject) jsonObject.get("question");
	    //System.out.println(jquestion);
	   
	   

	   Long lint=(Long) jquestion.get("id");
	    int questionId=lint.intValue();
	    String questionText=(String) jquestion.get("text");
	    
	    lint=(Long) jsonObject.get("type_id");
	    int typeId=lint.intValue();
	    Answer_type type= typeService.getType(typeId);
	    System.out.println(type.getA_type());
	    
	    if (type.getA_type().equals("s")) {
	    	Question question=new Question(questionId,questionText,survey,type);
	    	questionRepository.save(question);
	    	
	    	return "Saved successfully";
	    }
	    else if (type.getA_type().equals("button") || type.getA_type().equals("drop")) {
	    	
	    	 JSONObject options=(JSONObject) jsonObject.get("option");
	    	lint=(Long) options.get("id");
	    	int optionId=lint.intValue();
	    	String optionText=(String) options.get("text");
	    	
	    	Question question=new Question(questionId,questionText,survey,type);
	    	questionRepository.save(question);
	    	Pre_answer preAnswer=new Pre_answer(optionId,optionText,question);
	    	preAnswerService.save(preAnswer);
	    	return "Saved successfully";
	    
	    }
	    else {
	    	return ("Incomplete data");
	    }
		
	}
	
	
	
		
}

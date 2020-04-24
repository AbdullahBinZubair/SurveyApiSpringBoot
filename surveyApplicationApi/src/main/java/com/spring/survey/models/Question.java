package com.spring.survey.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Question {
	
	@Id
	int id;
	String text;
	
	@ManyToOne
	private Survey survey;
	@ManyToOne 
	private Answer_type answer_type;
	
	
	
	public Answer_type getA_type() {
		return answer_type;
	}

	public void setA_type(Answer_type answer_type) {
		this.answer_type = answer_type;
	}

	public Question() {	
	}
	
	public Question(int id, String text, Survey survey,Answer_type answer_type) {
		super();
		this.id = id;
		this.text = text;
		this.survey = survey;
		this.answer_type=answer_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	
	

}

package com.spring.survey.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Response {
	
	@Id
	int id;
	String user;
	
	@ManyToOne
	private Survey survey;
	@ManyToOne
	private Question question;
	
	
	
	
	public Response(int id,String user, Survey survey, Question question) {
		super();
		this.id = id;
		this.survey = survey;
		this.question = question;
		this.user = user;
	}
	public Response() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
	
	
}

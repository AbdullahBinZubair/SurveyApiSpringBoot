package com.spring.survey.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pre_answer {

	@Id
	int id;
	@Column(name = "answer")
	String option;
	
	@ManyToOne
	private Question question;
	
	public Pre_answer() {
		
	}
	
	public Pre_answer(int id, String option, Question question) {
		super();
		this.id = id;
		this.option = option;
		this.question = question;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
	
	
}

package com.spring.survey.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "res_answer")
public class ResponseAnswer {

	@Id
	int id;
	String text;
	
	@ManyToOne
	private Response response;
	
	public ResponseAnswer() {
		
	}
	public ResponseAnswer(int id, String text, Response response) {
		super();
		this.id = id;
		this.text = text;
		this.response = response;
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
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	
	
	
}

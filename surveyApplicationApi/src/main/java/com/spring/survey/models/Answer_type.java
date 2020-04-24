package com.spring.survey.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name = "answer-type")
public class Answer_type {

	@Id
	int id;
	@Column(name = "type_a")
	String a_type;
	
//	@OneToOne(mappedBy = "a_type")
//	private Question question; 
//	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Answer_type(int id, String a_type) {
		super();
		this.id = id;
		this.a_type = a_type;
	}
	public String getA_type() {
		return a_type;
	}
	public Answer_type () {
		
	}
	public void setA_type(String a_type) {
		this.a_type = a_type;
	}
	
}

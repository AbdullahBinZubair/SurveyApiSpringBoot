package com.spring.survey.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "survey")
public class Survey {
	
	@Id
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public Survey() {
		
	}
	public Survey(int id, String description, String name) {
		super();
		this.id = id;
		this.description = description;
		Name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	String description;
	String Name;
	
	
}

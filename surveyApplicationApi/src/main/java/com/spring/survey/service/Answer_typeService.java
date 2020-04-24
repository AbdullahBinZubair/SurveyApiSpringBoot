package com.spring.survey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.survey.models.Answer_type;
import com.spring.survey.repositories.answer_typeRepository;

@Service
public class Answer_typeService {

	@Autowired
	private answer_typeRepository typeRepository;
	
	public void addType(Answer_type newType) {
		// TODO Auto-generated method stub
		
		typeRepository.save(newType);
		
	}

	public void delete(int typeId) {
		// TODO Auto-generated method stub
		typeRepository.deleteById(typeId);
		
	}

	public Answer_type getType(int typeId) {
		// TODO Auto-generated method stub
		
		return typeRepository.findById(typeId).get();
	}
	
}

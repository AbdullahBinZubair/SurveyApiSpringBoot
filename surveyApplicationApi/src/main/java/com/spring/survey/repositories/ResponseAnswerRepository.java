package com.spring.survey.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.survey.models.ResponseAnswer;

public interface ResponseAnswerRepository extends JpaRepository<ResponseAnswer, Integer>{

	
	public List<ResponseAnswer> findByResponseId(int id);
}

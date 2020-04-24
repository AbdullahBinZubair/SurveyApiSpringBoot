package com.spring.survey.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.survey.models.Pre_answer;

public interface Pre_answerRepository extends JpaRepository<Pre_answer, Integer>{

	public List<Pre_answer> findByQuestionId(int id);
}

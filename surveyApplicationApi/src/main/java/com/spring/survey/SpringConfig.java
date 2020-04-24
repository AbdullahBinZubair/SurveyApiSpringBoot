package com.spring.survey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.survey.authentications.JwtUtil;

//import com.spring.servey.filters.JwtRequestFilter;

@Configuration
public class SpringConfig {

	@Bean
	public JwtUtil jwtutil() {
		return new JwtUtil();
	}
	
	@Bean
	public com.spring.survey.filters.JwtRequestFilter jwtRequestFilter() {
		return new com.spring.survey.filters.JwtRequestFilter();
	}
	/*
	@Bean
	public com.spring.survey.survey.SurveyService surveyService(){
		return new com.spring.survey.survey.SurveyService();
	}
	*/
	
}

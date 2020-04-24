package com.spring.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.survey.models.Answer_type;
import com.spring.survey.service.Answer_typeService;

@RestController
public class Answer_typeController {

	@Autowired
	private Answer_typeService typeService;
	
	
	@RequestMapping(value = "/get/answer/type/{typeId}")
	public Answer_type getType(@PathVariable int typeId)
	{
		return typeService.getType(typeId);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/add/answer/type", method = RequestMethod.POST)
	public String addType(@RequestBody Answer_type newType) {
		
		typeService.addType(newType);
		return "Added successfully";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/update/answer/type/{typeId}", method = RequestMethod.PUT)
	public String updateType(@RequestBody Answer_type newType,@PathVariable int typeId) {
		//check id if exist
		typeService.addType(newType);
		return "Added successfully";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/delete/answer/type/{typeId}")
	public String delete(@PathVariable int typeId) {
		typeService.delete(typeId);
		return "deleted successfully";
	}
	
	
	
	
	
}

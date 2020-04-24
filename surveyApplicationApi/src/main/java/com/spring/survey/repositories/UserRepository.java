package com.spring.survey.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.survey.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByName(String username);

}

package com.spring.survey.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.survey.models.MyUserDetails;
import com.spring.survey.models.User;
import com.spring.survey.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user=userRepository.findByName(username) ; 
		
		
		user.orElseThrow(() -> new UsernameNotFoundException("not found " + username));
		//return user.map(MyUserDetails::new).get();
		return user.map(MyUserDetails::new).get();
				
		
	}
	
}

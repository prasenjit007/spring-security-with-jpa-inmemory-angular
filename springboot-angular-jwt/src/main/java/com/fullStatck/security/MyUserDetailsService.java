package com.fullStatck.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.fullStatck.service.UserServiceImpl;


@Service
public class MyUserDetailsService implements UserDetailsService{
	private Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		logger.info("loadUserByUsername email : {}", email);
		
		/*
		 * List<com.fullStatck.model.User> list = userServiceImpl.getUsers();
		 * for(com.fullStatck.model.User usrDtl: list) {
		 * logger.info("##############################"); logger.info("USER FOUND: {}",
		 * usrDtl); }
		 */
		
		Optional<com.fullStatck.model.User> user = userServiceImpl.UserByEmail(email);
		if(user.isPresent()) {
			com.fullStatck.model.User usr = user.get();
			return new User(usr.getEmail(),usr.getPassword(), new ArrayList<>());
		}else {
			return null;
		}
		//return new User("test", "test", new ArrayList<>());
	}

}

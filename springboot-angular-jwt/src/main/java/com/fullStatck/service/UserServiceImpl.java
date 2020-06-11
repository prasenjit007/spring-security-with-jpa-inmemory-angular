package com.fullStatck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullStatck.dao.UserDaoService;
import com.fullStatck.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDaoService userDaoService;
	
	
	@Override
	public void saveUser(User user) {
		userDaoService.save(user);
	}


	@Override
	public List<User> getUsers() {
		return userDaoService.findAll();
	}
	
	@Override
	public Optional<User> UserByEmail(String email) {
		//return userDaoService.findById(email);
		return userDaoService.findByEmail(email);
	}
	
	@Override
	public Long getReordCount() {
		return userDaoService.max();
	}
}

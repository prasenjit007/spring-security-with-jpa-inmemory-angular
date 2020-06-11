package com.fullStatck.service;

import java.util.List;
import java.util.Optional;

import com.fullStatck.model.User;

public interface UserService {

	void saveUser(User user);

	List<User> getUsers();

	Long getReordCount();

	Optional<User> UserByEmail(String email);

}

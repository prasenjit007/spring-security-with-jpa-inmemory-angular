package com.fullStatck.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fullStatck.model.User;

public interface UserDaoService extends JpaRepository<User, String>{
	//User findByEmail(String email);
	
	@Query(value = "SELECT min(userId) FROM User")
	public Long min();

	@Query(value = "SELECT max(userId) FROM User")
	public Long max();
	
	@Query(value = "SELECT u FROM User u where u.email =:emailValue")
	Optional<User> findByEmail(@Param("emailValue") String email);
}

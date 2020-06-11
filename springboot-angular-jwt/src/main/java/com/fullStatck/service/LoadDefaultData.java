package com.fullStatck.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullStatck.model.Authorities;
import com.fullStatck.model.Event;
import com.fullStatck.model.SpecialEvent;
import com.fullStatck.model.User;

@Service
public class LoadDefaultData {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorityService authorityService;
	
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private SpecialEventService specialEventService;

	
	public void loadData() {
		userService.saveUser(new User(1L, "support@p.com", "support", true));
		userService.saveUser(new User(2L, "admin@admin.com", "admin", true));
		
		authorityService.saveAuthority(new Authorities("support@p.com", "ROLE_USER"));
		authorityService.saveAuthority(new Authorities("admin@admin.com", "ROLE_USER"));
		
		for(long i=0; i<10; i++) {
			eventService.save(new Event(i, "Test Event"+i, "Test Event Description"+i, new Date()));
		}
		
		for(long i=0; i<10; i++) {
			specialEventService.save(new SpecialEvent(i, "Special Event"+i, "Special Event Description"+i, new Date()));
		}
	}

}

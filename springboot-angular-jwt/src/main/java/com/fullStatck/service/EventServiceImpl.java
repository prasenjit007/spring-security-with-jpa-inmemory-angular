package com.fullStatck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullStatck.dao.EventDaoService;
import com.fullStatck.model.Event;
import com.fullStatck.model.SpecialEvent;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDaoService eventDaoService;
	
	@Override
	public List<Event> retriveEvents(){
		return eventDaoService.findAll();
	}
	
	@Override
	public void save(Event event) {
		eventDaoService.save(event);
	}
}

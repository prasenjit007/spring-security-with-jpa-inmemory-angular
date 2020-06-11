package com.fullStatck.service;

import java.util.List;

import com.fullStatck.model.Event;

public interface EventService {

	List<Event> retriveEvents();

	void save(Event event);

}

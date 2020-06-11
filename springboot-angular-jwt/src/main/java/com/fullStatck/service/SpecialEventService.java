package com.fullStatck.service;

import java.util.List;

import com.fullStatck.model.SpecialEvent;

public interface SpecialEventService {

	List<SpecialEvent> retriveSpecialEvents();

	void save(SpecialEvent event);

}

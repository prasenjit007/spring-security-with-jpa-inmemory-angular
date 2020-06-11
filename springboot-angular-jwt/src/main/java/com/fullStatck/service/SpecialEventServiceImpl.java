package com.fullStatck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullStatck.dao.SpecialEventDaoService;
import com.fullStatck.model.SpecialEvent;

@Service
public class SpecialEventServiceImpl implements SpecialEventService {

	@Autowired
	private SpecialEventDaoService specialEventDaoService;
	
	@Override
	public List<SpecialEvent> retriveSpecialEvents(){
		return specialEventDaoService.findAll();
	}
	
	@Override
	public void save(SpecialEvent event) {
		specialEventDaoService.save(event);
	}
}

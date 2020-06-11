package com.fullStatck.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullStatck.model.Event;

public interface EventDaoService  extends JpaRepository<Event, Long>{

}

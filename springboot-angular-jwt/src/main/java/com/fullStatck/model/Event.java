package com.fullStatck.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event {
	@Id
	private Long id;
	private String name;
	private String description;
	private Date date;
	
	public Event() {
	}
	
	

	public Event(Long id, String name, String description, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + "]";
	}
	
	
}

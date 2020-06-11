package com.fullStatck.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private Boolean enabled;
	
	public User() {
	}

	public User(Long userId, String email, String password, Boolean enabled) {
		super();
		this.userId=userId;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password  + ", enabled=" + enabled+ "]";
	}

	
}

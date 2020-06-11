package com.fullStatck.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authorities implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="authority ")
	private String authority;
	
	public Authorities() {
	}

	
	
	public Authorities(String email, String authority) {
		super();
		this.email = email;
		this.authority = authority;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Authorities [email=" + email + ", authority=" + authority + "]";
	}
	
	
}

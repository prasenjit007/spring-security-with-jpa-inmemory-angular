package com.fullStatck.security;

import java.io.Serializable;

public class AuthenticationResponse  implements Serializable{
	private static final long serialVersionUID = 1L;
	private final String token;
	
	public AuthenticationResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}
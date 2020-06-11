package com.fullStatck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullStatck.dao.AuthorityDaoService;
import com.fullStatck.model.Authorities;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	private AuthorityDaoService authorityDaoService;
	
	@Override
	public void saveAuthority(Authorities authoritie) {
		authorityDaoService.save(authoritie);
	}
}

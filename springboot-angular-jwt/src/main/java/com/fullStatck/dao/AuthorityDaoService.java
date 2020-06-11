package com.fullStatck.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullStatck.model.Authorities;

public interface AuthorityDaoService   extends JpaRepository<Authorities, String>{

}

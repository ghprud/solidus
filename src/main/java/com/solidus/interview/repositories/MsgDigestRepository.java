package com.solidus.interview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solidus.interview.entities.MsgDigest;


public interface MsgDigestRepository 
	extends JpaRepository<MsgDigest, Long>, MDigestRepository{
		
}

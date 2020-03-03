package com.solidus.interview.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solidus.interview.entities.MsgDigest;


@Repository
public class MDigestRepositoryImpl implements MDigestRepository{
	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	private static final String getDigest = "select message, digest from msg_digest where " +
			"digest like :digest";
	
	@Autowired
	MDigestRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional(readOnly = true)
	@Override
	public MsgDigest findByDigest(String digest) {
		Map<String, String> queryParams = new HashMap<>();
		MsgDigest msgDigest = null;
		
		queryParams.put("digest", digest);
		
		System.out.println(queryParams.get("digest"));
		
		List<MsgDigest> searchResults = jdbcTemplate.query(getDigest,
                queryParams,
                new BeanPropertyRowMapper<>(MsgDigest.class)
        );
		
		if (searchResults.size() > 0) {
			msgDigest = searchResults.get(0);
		}
 
        return msgDigest;
	}
	
	
}

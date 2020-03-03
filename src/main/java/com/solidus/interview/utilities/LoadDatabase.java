package com.solidus.interview.utilities;


import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.solidus.interview.entities.MsgDigest;
import com.solidus.interview.repositories.MsgDigestRepository;

@Configuration
@Slf4j
public class LoadDatabase {
	@Bean
	CommandLineRunner initDatabase(MsgDigestRepository repository) {
		return args -> {
			repository.save(new MsgDigest("test", "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08"));
		};
	
}
}

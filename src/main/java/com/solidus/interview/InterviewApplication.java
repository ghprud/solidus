package com.solidus.interview;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.solidus.interview.repositories.MDigestRepository;

@EnableJpaRepositories(basePackageClasses = MDigestRepository.class)
@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class InterviewApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				SpringApplication.run(InterviewApplication.class, args);
		
	}

}

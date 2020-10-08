package com.java.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class StudentApplication {

	private static final Logger logger = LoggerFactory.getLogger(StudentApplication.class);

	public static void main(String[] args) {
		logger.info("Starting Student Application");
		SpringApplication.run(StudentApplication.class, args);
		logger.info("Application started successfully");
	}

}

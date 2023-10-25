package com.example.forummicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@SpringBootApplication
@EnableWebFluxSecurity
public class ForumMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumMicroServiceApplication.class, args);
	}

}

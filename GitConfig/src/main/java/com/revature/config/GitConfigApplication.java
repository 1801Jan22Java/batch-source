package com.revature.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class GitConfigApplication {
	
	public static void main(String... args) {
		SpringApplication.run(GitConfigApplication.class, args);
	}
	
}

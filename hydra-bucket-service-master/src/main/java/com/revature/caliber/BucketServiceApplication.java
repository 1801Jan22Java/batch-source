package com.revature.caliber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan
//@EntityScan("com.revature.caliber.model")
public class BucketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BucketServiceApplication.class, args);
	}
}

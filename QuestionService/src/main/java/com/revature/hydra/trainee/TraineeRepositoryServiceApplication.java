package com.revature.hydra.trainee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.revature.hydra.trainee.data.TraineeRepository;
import com.revature.hydra.trainee.service.TraineeCompositionService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableEurekaClient 
@EnableSwagger2
@ComponentScan
@EntityScan("com.revature.beans")
public class TraineeRepositoryServiceApplication {
	@Autowired
	TraineeCompositionService tcs;
	
	@Autowired
	TraineeRepository tr;

	public static void main(String[] args) {
		SpringApplication.run(TraineeRepositoryServiceApplication.class, args);
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.revature.hydra.trainee.controller"))              
          .paths(PathSelectors.any())                          
          .build();
    }
}

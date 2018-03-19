package com.revature.hydra.trainee.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.revature.hydra.trainee.service.TraineeCompositionService;

public class TraineeRepositoryServiceConfiguration {
	@Autowired
	TraineeCompositionService tcs;
	
	@Bean
	public AmqpTemplate rabbitTemplate(ConnectionFactory factory) {
		return new RabbitTemplate(factory);
	}
	
	@Bean
	public CommandLineRunner runner() {
		return args -> {
			
		};
	}
}

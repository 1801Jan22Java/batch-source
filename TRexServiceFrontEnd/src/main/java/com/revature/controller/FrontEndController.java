package com.revature.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.beans.TRex;

@RestController
public class FrontEndController {
	
	@Autowired
	TRexSource mySource;
	
	@GetMapping("/sendMessage")
	public String sendMessage(){
		mySource.tRexChannel().send(MessageBuilder.withPayload("Hello from Spring Boot").build());
		return "";
	}
	
	@Bean
	public RestTemplate restTemplate (RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fakeDinos")
	@GetMapping("/getDinos")
	public ArrayList<TRex> getTRexes(){
		ResponseEntity<? extends ArrayList<TRex>> response = 
				this.restTemplate.getForEntity("http://localhost:9090/api/tbs/trex/all",(Class<? extends ArrayList<TRex>>)ArrayList.class);
		return response.getBody();
	}
	
	public ArrayList<TRex> fakeDinos(){
		ArrayList<TRex> dinoList = new ArrayList<>();
		dinoList.add(new TRex("Fake T-Rex","red"));
		return dinoList;
	}
}

package com.revature.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="personService")
@Scope(value="prototype")
public class PersonService {

	private static int maxHumanSpeed = 15;
	
	public static int getSpeed() {
		return maxHumanSpeed;
	}
	
	public void wakeUpAnimal() {
		System.out.println("Woke up animal");
		
	}
	
	
	

}

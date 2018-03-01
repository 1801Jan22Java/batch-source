package com.revature.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="personService")
@Scope(value="prototype")
public class PersonService {
	
	private static int maxHumanSpeed = 15;
	
	public static int getSpeed() {
		return PersonService.maxHumanSpeed;
	}
	
	public void wakeUpAnimal() {
		System.out.println("woke up animal");
	}

}

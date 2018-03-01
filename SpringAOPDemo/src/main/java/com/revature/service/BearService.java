package com.revature.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(value="bearService") //could be something else 
@Scope(value="prototype")
public class BearService extends AnimalService {
	
	private static int bearSpeed = 10;
	private Boolean bearFull = true; //bears eat before they hibernate
	private static Boolean isWinter = false;
	
	@Override
	public int getSpeed() {
		return bearSpeed;
	}
	
	public Boolean getIsWinter(){
		return isWinter;
	}
	
	public void setIsWinter(Boolean isWinter){
		BearService.isWinter = isWinter;
	}

	@Override
	public void setFull(Boolean full) {
		this.bearFull = full;
	}

	@Override
	public Boolean getFull() {
		return this.bearFull;
	}

	@Override
	public void animalChasesYou() {
		System.out.println("Bear is chasing you");
	}
	
	public void bearHibernates() throws Exception {
		if (!BearService.isWinter) {
			throw new Exception("bears hibernate in the winter");
		}
		System.out.println("ZZZZZZZZZZZZZZ");
	}

}
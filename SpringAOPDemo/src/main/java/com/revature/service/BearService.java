package com.revature.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="bearService")
@Scope(value="prototype")
public class BearService extends AnimalService{

	private static int bearSpeed = 10;
	private Boolean bearFull = true;
	private static Boolean isWinter = false;
	
	
	public Boolean getIsWinter() {
		return isWinter;
	}
	
	public void setIsWinter(Boolean isWinter) {
		BearService.isWinter = isWinter;
	}
	
	@Override
	public int getSpeed() {
		
		return bearSpeed;
	}

	@Override
	public void setFull(boolean full) {
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
		System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
	}

}

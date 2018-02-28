package com.revature.service;

import org.springframework.stereotype.Component;

@Component(value="bearService")
public class BearService extends AnimalService{

	private static int bearSpeed = 10;
	private static Boolean isWinter = false;
	private boolean bearFull = true;
	// cuz bears eat before they hibernate 
	
	@Override
	public int getSpeed() {
		return BearService.bearSpeed;
	}
	
	public Boolean isWinter() {
		return isWinter;
	}
	
	public void setWinter(Boolean winter) {
		BearService.isWinter = winter;
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
	
	public void bearHibernates() throws Exception{
		if(!BearService.isWinter)
			throw new Exception("bears hibernate in the winter");
		
		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzz");
	}
}

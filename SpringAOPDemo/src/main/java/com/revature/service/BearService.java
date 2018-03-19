package com.revature.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="bearService")  // same as @Service(value="bearService")
@Scope(value="prototype")
public class BearService extends AnimalService {
	
	private static int bearSpeed = 10;
	private Boolean bearFull = false;
	private static Boolean isWinter = false;

	@Override
	public int getSpeed() {
		return BearService.bearSpeed;
	}
	
	public Boolean getIsWinter() {
		return isWinter;
	}
	
	public void setIsWinter(Boolean isWinter) {
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
		System.out.println("Tiger is chasing you");
	}
	
	public void bearHibernates() throws Exception {
		if (!BearService.isWinter) {
			throw new Exception("bears hibernate in winter");
		}
		System.out.println("ZZZZZZZZZZZZZZZ");
	}

}

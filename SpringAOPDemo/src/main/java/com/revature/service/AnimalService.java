package com.revature.service;


public abstract class AnimalService {
	
	// how fast is the animal?
	public abstract int getSpeed();
	
	// is the animal hungry?
	public abstract void setFull(Boolean full);
	public abstract Boolean getFull();
	
	// actions of the animal
	public abstract void animalChasesYou();
	
	public void animalCatchesYou() {
		System.out.println("Hope it's not hungry!");
	}
	
}

package com.revature.beans;

public class BearWithConstructor extends Bear {

	private Cave cave;
	
	public BearWithConstructor() {
		super();
	}
	public BearWithConstructor(Cave cave) {
		super();
		this.cave = cave;
	}
	@Override
	public void methodInBear() {
		
		System.out.println("method in BearWithConstructor. this bear is: " + this.toString());
		System.out.println("cave: " + cave.getName());

	}


}

package com.revature.beans;

public class AutoBearByName extends Bear {
	
	private Cave cave;
	
	//method identifier must match the name of the dependency
	public void setCave(Cave cave){
		this.cave = cave;
	}

	@Override
	public void methodInBear() {
		System.out.println("method in AutoBearByName. this bear is: " + this.toString());
		System.out.println("cave: " + cave.toString());
	}

}

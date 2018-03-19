package com.revature.beans;

public class AutoBearByType extends Bear {

	private Cave cave;
	
	//this is fine because we're wiring by type
	public void setSomethingWhichHasTypeCave(Cave somethingElse){
		this.cave = somethingElse;
	}
	
	@Override
	public void methodInBear() {
		System.out.println("method in AutoBearByType. this bear is: " + this.toString());
		System.out.println("cave: " + cave.toString());
	}

}

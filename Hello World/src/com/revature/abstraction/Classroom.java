package com.revature.abstraction;

public class Classroom extends Rectangle implements Room{
	
	public ClassType classType;
	
	public Classroom (double length, double width, ClassType classType) throws ImpossibleRoomException{
		if((length <= 0.0) || (width <= 0.0)) {
			throw new ImpossibleRoomException();
		}
		this.classType = classType;
		super.setLength(length);
		super.setWidth(width);
	}
	
	public void openDoor() {
		System.out.println("Walk to door, turn handle clockwise");
	}
	
	public void closeDoor() {
		System.out.println("Walk to door, turn handle, push");
	}
	
}

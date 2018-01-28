package com.revature.abstraction;

public class Classroom extends Rectangle implements Room{

	public ClassType classType;
	
	@Override
	public void openDoor() {
		System.out.println("Walk to door, turn handle clockwise");
	}

	@Override
	public void closeDoor() {
		System.out.println("Walk to door, push closed");
	}

	
	public Classroom(Double length, Double width, ClassType classType) throws ImpossibleRoomException{
		super(length, width);
		if(length<= 0.0 || width <= 0.0) {
			throw new ImpossibleRoomException();
		}
		this.classType = classType;
	}

	public ClassType getClassType() {
		return classType;
	}

	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	

}

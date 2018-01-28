package com.revature.abstraction;

public class Classroom extends Rectangle implements Room {

	public ClassType classType;			// enum example

	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Note: exceptions can be thrown for constructors
	public Classroom(Double length, Double width, ClassType classType) throws ImpossibleRoomException {
		super(length, width);
		if(length <= 0.0 || width <= 0.0) {
			throw new ImpossibleRoomException();
		}
		this.classType = classType; 
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openDoor() {
		System.out.println("Walk to door, turn handle clockwise");
		
	}

	@Override
	public void closeDoor() {
		System.out.println("Walk to door, push close");
		
	}

}

package com.revature.abstraction;

public class Classroom extends Rectangle implements Room {

	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Classroom(Double length, Double width) throws ImpossibleRoomException {
		super(length, width);
		if (length <= 0.0 || width <= 0.0) {
			throw new ImpossibleRoomException();
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openDoor() {
		// TODO Auto-generated method stub
		System.out.println("Opened the door");
	}

	@Override
	public void closeDoor() {
		// TODO Auto-generated method stub
		System.out.println("Closed the door");
	}

}

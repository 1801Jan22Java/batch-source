package com.revature.abstraction;

public class Classroom extends Rectangle implements Room{
	
	public ClassType classtype;
	
	
	public Classroom(Double length, Double width, ClassType classtype) throws ImpossibleRoomException {
		
		super(length, width);
		if (length <= 0.0 || width <= 0.0) {
			throw new ImpossibleRoomException();
		}
		this.classtype = classtype;
	}

	@Override
	public void openDoor() {
		System.out.println("walk to door, turn handle clockwise");
	}

	@Override
	public void closeDoor() {
		System.out.println("walk to door, push closed");
	}

}

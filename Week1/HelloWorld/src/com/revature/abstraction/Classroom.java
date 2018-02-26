package com.revature.abstraction;

public class Classroom extends Rectangle implements Room
{
	public ClassType classType;
	
	public Classroom()
	{
		super();
	}
	
	public Classroom(Double length, Double width, ClassType classType) throws ImpossibleRoomException
	{
		super(length, width);
		if(length <= 0.0 || width <= 0.0)
			throw new ImpossibleRoomException();
		this.classType = classType;
	}
	
	public void openDoor() {
		System.out.println("Walk to door, turn handle clockwise");
	}
	
	public void closeDoor()
	{
		System.out.println("Walk to door, and close the door.");
	}
	
}

package com.revature.abstraction;

public class Classroom extends Rectangle implements Room
{
	public ClassType classType;

	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classroom(Double length, Double width, ClassType classType) throws ImpossibleRoomException
	{
		if(length <= 0.0 || width <= 0.0)
		{
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
		System.out.println("Walk to door, punch closed");
	}

}

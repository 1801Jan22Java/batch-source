package com.revature.abstraction;

public class Classroom extends Rectangle implements Room {
	
	
	public ClassType classtipa;
	
	public Classroom(Double length, Double width,ClassType tipa) throws ImpossibleRoomException {
		
		
		super(length, width);
		if(length<=0.0 || width <=0.0)
		{
			throw new ImpossibleRoomException();
		}
		classtipa = tipa;
		
	}

	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openDoor() {
		System.out.println("Walk to door, turn handle clockwise, pull open");
	}

	@Override
	public void closeDoor() {
		System.out.println("Walk to door, push closed");
		
	}

}

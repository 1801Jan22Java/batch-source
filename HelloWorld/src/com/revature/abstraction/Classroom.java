package com.revature.abstraction;

public class Classroom extends Rectangle implements Room {

	public ClassType classType;
	
	public Classroom(double height, double width, ClassType classType) throws ImpossibleRoomException{
		super(height, width);
		if(height <= 0.0 || width <= 0.0) {
			throw new ImpossibleRoomException();
		}
		this.classType = classType;
	}

	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openDoor() {
		System.out.println("Walk to door, turn handle clockwise, pull");
	}

	@Override
	public void closeDoor() {
		System.out.println("Walk to door, push");
	}
	
	public double calculateArea() {
		return height*width;
	}
	
	public double calculatePerimeter() {
		return (2*height + 2*width);
	}
}

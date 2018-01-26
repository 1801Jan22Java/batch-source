package com.revature.abstraction;

public class Classroom extends Rectangle implements Room {
	
<<<<<<< HEAD

	public ClassType classType;

	public Classroom(Double length, Double width, ClassType classType) throws ImpossibleRoomException {
		super(length, width);

		if(length <= 0.0 || width <=0.0) {
			throw new ImpossibleRoomException();
		}
		
		this.classType = classType;
=======
	public ClassType classType;

	public Classroom() {
		super();
	}

	public Classroom(Double length, Double width, ClassType classType) throws ImpossibleRoomException {
		super(length, width);
		if(length <= 0.0 || width <= 0.0){
			throw new ImpossibleRoomException();
		}
		this.classType = classType;
	
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	}

	@Override
	public void openDoor() {
<<<<<<< HEAD
		System.out.println("Walk to door, open door.");
=======
		System.out.println("Walk to door, turn handle clockwise");
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	}

	@Override
	public void closeDoor() {
<<<<<<< HEAD
		System.out.println("Walk to door, close door.");
=======
		System.out.println("Walk to door, push closed");
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	}

}

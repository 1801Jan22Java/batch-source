package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
<<<<<<< HEAD
		try {
			Classroom room203 = new Classroom(25.0, 20.0, ClassType.JAVA);
			
			System.out.println("Area of 203: " + room203.calculateArea());
			System.out.println("Perimeter of 203: " + room203.calculatePerimeter());
			room203.openDoor();
			room203.closeDoor();
			System.out.println(room203.classType.getDetails());
		} catch(ImpossibleRoomException e) {
			System.out.println(e.getMessage());
		}
		
	}
=======

		Classroom room203;
		try {
			room203 = new Classroom(20.0, 20.0,ClassType.JAVA);
			System.out.println("Area of 203 is: " + room203.calculateArea());
			System.out.println("Perimeter of 203 is: " + room203.calculatePerimeter());
			room203.openDoor();
			room203.closeDoor();
			System.out.println(room203.classType);
		} catch (ImpossibleRoomException e) {
			System.out.println(e.getMessage());
		}

	}

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
}

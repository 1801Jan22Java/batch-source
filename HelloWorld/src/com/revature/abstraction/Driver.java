package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {

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

}
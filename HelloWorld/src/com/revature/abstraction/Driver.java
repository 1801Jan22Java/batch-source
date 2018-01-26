package com.revature.abstraction;

public class Driver {
	public static void main(String[] args) {
		Classroom room203;
		try {
			room203 = new Classroom(16.0, 24.0);
			System.out.println("Area = " + room203.calculateArea());
			System.out.println("Perimeter = " + room203.calculatePerimeter());
			room203.openDoor();
			room203.closeDoor();
		} catch (ImpossibleRoomException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}

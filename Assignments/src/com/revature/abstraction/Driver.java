package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Classroom room203 = new Classroom(25.0,20.0,ClassType.JAVA);
			System.out.println("Area of 203 is: " + room203.calculateArea());
			System.out.println("Perimeter of 203 is: " + room203.calculatePerimeter());
			
			room203.openDoor();
			room203.closeDoor();
			System.out.println(room203.classtype.getDetails());
		}
		catch (ImpossibleRoomException e) {
			System.out.println(e.getMessage()); 
		}
		
	}

}

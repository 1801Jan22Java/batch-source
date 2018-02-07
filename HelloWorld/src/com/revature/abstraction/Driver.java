package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Classroom room203;
		
		try {
			room203 = new Classroom(20.0, 20.0, ClassType.JAVA);
			System.out.println("Area of room 203 is: "+room203.calculateArea());
			System.out.println("Perimeter of room203 is: "+room203.calculatePerimeter());
			System.out.println(room203.classType.getDetails());
			room203.openDoor();
			room203.closeDoor();
		} catch (ImpossibleRoomException e) {
			System.out.println(e.getMessage());
		}
		
		
		

	}

}

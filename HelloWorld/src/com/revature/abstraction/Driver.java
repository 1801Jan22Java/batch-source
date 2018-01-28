package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
		
		Classroom room203;
		try {
			room203 = new Classroom(25.0,20.0, ClassType.JAVA);
			
			System.out.println("Area of Room 203 is "+room203.calculateArea());
			System.out.println("Perimeter of Room 203 is "+room203.calculatePerimeter());
			System.out.println(room203.getClassType().getDetails());
			
			room203.openDoor();
			room203.closeDoor();
			
		} catch (ImpossibleRoomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

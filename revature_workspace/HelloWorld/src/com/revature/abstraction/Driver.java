package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
		Classroom room203;
		
		try{
		
		room203 = new Classroom(25.0,20.0,ClassType.JAVA);
	//	Classroom room204 = new Classroom(0.0,0.0,ClassType.CSHARP);
		System.out.println("area of 203 is " + room203.calculateArea());
		System.out.println("perimteter of 203 is " + room203.calculatePerimeter());
		System.out.println(room203.classtipa.getDetails());
		room203.openDoor();
		room203.closeDoor();
		
		}
		
		catch(ImpossibleRoomException e)
		{
			System.out.println(e.getMessage());
		}
		

	}

}

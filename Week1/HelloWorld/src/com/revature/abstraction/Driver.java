package com.revature.abstraction;

public class Driver
{
	public static void main(String[] args)
	{
		Classroom room203 = null;
		try {
			room203 = new Classroom(25.0,20.0, ClassType.JAVA);
		} catch (ImpossibleRoomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(room203 != null)
		{
			System.out.println("Area of Room 203 is: " + room203.calculateArea());
			System.out.println("Area of Room 203 is: " + room203.calculatePerimeter());

			room203.openDoor();
			room203.closeDoor();
			System.out.println(room203.classType.getDetails());
		}
	}
}

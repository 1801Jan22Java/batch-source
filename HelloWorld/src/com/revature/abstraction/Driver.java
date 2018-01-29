package com.revature.abstraction;

public class Driver 
{
	public static void main(String args[])
	{
		try
		{
			Classroom room203 = new Classroom(10.0,20.0,ClassType.JAVA);
			System.out.println("Area of 203 is: "+room203.calculatePerimeter());
			
			room203.closeDoor();
			room203.openDoor();
			System.out.println(room203.classType.getDetails());
		}
		catch(ImpossibleRoomException e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
}

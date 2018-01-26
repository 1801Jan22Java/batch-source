package com.revature.abstraction;

public class Classroom extends Rectangle implements Room {

	public ClassType classtype;
	
	public Classroom(double length, double width, ClassType classtype) throws ImpossibleRoomException{
		super(length, width);
		if (length==0||width==0)
		{
			throw new ImpossibleRoomException();
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.revature.abstraction.Room#openDoor()
	 */
	@Override
	public void openDoor() {
		// TODO Auto-generated method stub
		System.out.println("Walk to door, turn handle");
	}

	/* (non-Javadoc)
	 * @see com.revature.abstraction.Room#closeDoor()
	 */
	@Override
	public void closeDoor() {
		// TODO Auto-generated method stub
		System.out.println("Walk to door, push closed");
	}
	
	

}

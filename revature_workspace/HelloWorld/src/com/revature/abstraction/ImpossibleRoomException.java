package com.revature.abstraction;

public class ImpossibleRoomException extends Exception{


	private static final long serialVersionUID = 4608904459643470707L;
	
	public ImpossibleRoomException()
	{
		super("This room has no dimensions.  Cannot enter.");
	}

}

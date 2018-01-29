package com.revature.abstraction;

//checked exception
public class ImpossibleRoomException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public ImpossibleRoomException()
	{
		super("this room is impossible, what are you doing?");
	}
}

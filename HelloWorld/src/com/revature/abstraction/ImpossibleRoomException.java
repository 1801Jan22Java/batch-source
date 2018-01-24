package com.revature.abstraction;

// This is a check exception
public class ImpossibleRoomException extends Exception {

	private static final long serialVersionUID = 4608904459643470707L;
	
	public ImpossibleRoomException() {
		super("this room is impossible.");
	}
	
}

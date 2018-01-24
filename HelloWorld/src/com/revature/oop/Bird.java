package com.revature.oop;

public class Bird {

	{System.out.println("b1");}
	
	Bird(){
		// super(); is hidden
		System.out.println("b2");
	}
	
	static {System.out.println("b3");}
}

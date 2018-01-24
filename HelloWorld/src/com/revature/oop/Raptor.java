package com.revature.oop;

public class Raptor extends Bird{
	
	static {System.out.println("r1");}
	
	public Raptor () {
		// super(); is hidden. that's why Bird is executed first than Raptor.
		System.out.println("r2");
	}
	
	{System.out.println("r3");}
	
	static {System.out.println("r4");}
}

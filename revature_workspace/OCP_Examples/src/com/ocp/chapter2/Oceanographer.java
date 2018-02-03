package com.ocp.chapter2;

public class Oceanographer {
	
	public void checkSound(LivesInOcean animal){
		animal.makeSound();
	}
	
	public static void main(String [] arg)
	{
		Oceanographer o = new Oceanographer();
		o.checkSound(new Dolphin());
		o.checkSound(new Whale());;
	}
}

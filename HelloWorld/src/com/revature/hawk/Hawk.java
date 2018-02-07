package com.revature.hawk;

class Bird{
	//top of class hierarchy
	
	{System.out.println("b1");}
	
	Bird(){
		System.out.println("b2");
	}
	
	static {
		System.out.println("b3");
	}
}

class Raptor extends Bird{
	static {
		System.out.println("r1");
	}
	
	public Raptor() {
		System.out.println("r2");
	}
	{
		System.out.println("r3");
	}
	static {
		System.out.println("r4");
	}
}

public class Hawk extends Raptor{
	
	//static code blocks executes before the main method.
	public static void main(String[] args) {
		System.out.println("init");		
		//when object is being constructed, it goes to the top of the class hierarchy
		//because hawk needs raptor to be constructed, and raptor needs bird to be constructed.
		//Due to this, runtime goes through class Bird first and goes through its code block and constructor
		//then it enters class Raptor and executes its code block and constructor.
		new Hawk();
		System.out.println("hawk");
	}
}

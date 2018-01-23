package com.revature.oop;
class Bird {

	{
		System.out.println("b1 block ");
	}
	Bird() {
		System.out.println("b2 constructor");
	}

	static {
		System.out.println("b3 static");
	}
}

class Raptor extends Bird {

	static {
		System.out.println("r1 static");
	}

	public Raptor() {
		System.out.println("r2 constructor");
	}
	
	{
		System.out.println("r3 block");
	}

	static {
		System.out.println("r4 static");
	}

}
	public  class Hawk extends Raptor{

		public static void main (String [] args)
		{
			System.out.println("init");
			new Hawk();
			System.out.println("Hawk");
		}
	}


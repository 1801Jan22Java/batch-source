package com.ocp.chapter1;

abstract class Animal 
{

	String name = "???";
	public void printName()
	{
		System.out.println(name);
	}
	
	public void careFor(){
		play();
	}
	
	public void play()
	{
		System.out.println("pet animal");
	}
}

class Lion extends Animal 
{
	String name = "Leo";  
	// instance variable does not override superclass 
	// instance variable
	
	public void play() 
	//Virtual method - overrides method in Abstract class
	{
		System.out.println("toss meat");
	}
}

class Bobcat 
{
	public void findDen(){}
	
}

class BobcatMother extends Bobcat
{
	//@Override public void findDen(boolean b){} //DOES NOT COMPILE
	
	//Properly overriding method
	@Override public void findDen(){}
	
	//Overloaded method (Different method signature)
	public void findDen(boolean b){} //Compiles - not attempting to override
	
}

public class PlayWithAnimal {

	public static void main(String[] args) {
		Animal animal = new Lion();
		animal.printName();
		animal.careFor();
	}

}

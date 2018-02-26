package com.revature.hello;

import com.revature.oop.*;
import static com.revature.oop.Cat.*;

public class HelloWorld {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
		//access things from our OOP package
		//could use our fully qualified class name
		com.revature.oop.Animal a = new com.revature.oop.Animal("Fred");
		
		// Can also use the import keyword
		//Dog dog = new Dog();
		
		// Exmaple: using static import
		System.out.println(catLatinName);
	}
}

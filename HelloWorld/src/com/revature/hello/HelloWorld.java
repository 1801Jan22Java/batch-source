package com.revature.hello;
/*
 * package - a namespace that organizes a set of related classes and interfaces
 * corresponds to a folder structure
 * base package for Java is java.lang
 */

import com.revature.oop.*;
import static com.revature.oop.Cat.*; //must specify a class, not a package

public class HelloWorld {
	
	/*
	 * Naming conventions:
	 * Classes and Projects are PascalCased
	 * Methods and Properties are camelCased
	 * Package names are all lowercase, separated by periods (com.revature.[stuffs])
	 * 	Each period separated word corresponds to the level in the structure
	 * Constants are ALL_CAPS_WITH_UNDERSCORES
	 */
	
	/*
	 * main method
	 * JVM looks for  a method with this signature for an entry point
	 */
	
	public static void main(String [] args) {
		// static: won't need instance of HelloWorld to execute this method
		System.out.println("Hello World!");
		
		// access things from the OOP package
		// could use fully qualified classname
		com.revature.oop.Animal animal = new com.revature.oop.Animal("Fred");
		
		//or use an import;
		Dog d = new Dog();
		
		// using static import
		// we don't have to specify Cat.catinName
		System.out.println(catinName);
	}
	
	// STS (basically also Eclipse)  does incremental compiling
	// every time a file is saved, it and any of its dependencies are compiled
	// compiling: converting from Java code to bytecode
	// 		.java (source code) to .class (bytecode, to be executed by JVM)
	//
	
	
	
}

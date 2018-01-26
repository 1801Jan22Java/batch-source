package com.revature.hello;
/*
 * package - a namespace that organizes a set of related classes and interfaces
 * corresponds to a folder structure
 * base package for Java is java.lang
 */

import com.revature.oop.*;
<<<<<<< HEAD
import static com.revature.oop.Cat.*; //must specify a class, not a package
=======
import static com.revature.oop.Cat.*;
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e

public class HelloWorld {
	
	/*
	 * Naming conventions:
<<<<<<< HEAD
	 * Classes and Projects are PascalCased
	 * Methods and Properties are camelCased
	 * Package names are all lowercase, separated by periods (com.revature.[stuffs])
	 * 	Each period separated word corresponds to the level in the structure
	 * Constants are ALL_CAPS_WITH_UNDERSCORES
=======
	 * classes and projects: pascal casing, FirstSecondThird
	 * methods and variables: camel casing, firstSecondThird
	 * package names: lowercase, separated by periods, e.g. com.revature.[other stuff]
	 * constants: FIRST_SECOND_THIRD
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	 */
	
	/*
	 * main method
<<<<<<< HEAD
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
	
	
=======
	 * JVM looks for a method with this signature as an entrance point to the program
	 */
	public static void main(String[] args){
		//static: don't need an instance of HelloWorld to execute the method
		//void: return type, doesn't return anything
		//String[] args: array of string parameter to pass to main()
		
		//sysout+ctrl+space
		System.out.println("Hello World!");
		
		//STS (and, under the hood, Eclipse) does incremental compiling 
		//every time a file is saved, it and any of its dependencies are compiled
		//compiling: converting .java source files into .class bytecode for execution by the JVM 
	
		
		//access things from our OOP package 
		//could use our fully qualified classname 
		com.revature.oop.Animal a = new com.revature.oop.Animal("Fred");
		
		//or use an import 
		Dog d = new Dog();
		
		//using static import
		System.out.println(catinName);
	
	}
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	
}

package com.revature.hello;
/*
 * package is a name space that organizes a set of related clsses and interfaces
 * corresponds to a folder structure
 * base package for Java is java.lang
 */

import com.revature.oop.*;
import static com.revature.oop.Cat.*;

public class HelloWorld {
	
	/*
	 * Naming Conventions:
	 * classes and projects: pascal casing, FirstSecondThird
	 * methods and variables: camel casing, firstSecondThird
	 * package names: lowercase, separated by periods, com.revature.[other stuff]
	 * constants: FIRST_SECOND_THIRD
	 */
	
	/*
	 * main method
	 * JVM looks for a method with this signature as an entrance point to the program
	 */
	public static void main(String [] args) {
		//static: don't needs an instance of helloworld to execute
		//void: return type, does not return anything
		//String[] args: array of string parameters to pass to main()
		
		//sysout+ctrl+space
		System.out.println("Hello World!");
		
		//STS (and, under the hood, Eclipse) does incremental compiling
		//every time a file is saved, it and any of its dependencies are compiled
		//compiling: converting .java source files into .class bytecode
		
		//access things from our package
		//could use our fully qualified class name
		com.revature.oop.Animal a = new com.revature.oop.Animal("Fred");
		
		//or use import
		Dog d = new Dog();
		
		//using static import
		System.out.println(catLatinName);
		
	}

}

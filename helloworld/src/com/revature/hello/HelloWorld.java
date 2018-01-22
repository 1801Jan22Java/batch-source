package com.revature.hello;
/*
 * package: a namespace that organizes a set of related calsses and interfaces
 * corresponds to a folder structure
 * base package for Java is java.lang
 */

public class HelloWorld {
	/*
	 * Naming convention:
	 * Classes and Projects are PascalCased
	 * Methods and Properties are camelCased
	 * Package names are all lowercase, separated by periods (com.revature.[stuffs])
	 *     Each period separated word corresponds to the level in the structure
	 * Constants are ALL_CAPS_WITH_UNDERSCORES	
	 */
	
	/*
	 * main method
	 * JVM looks for a method with this signature for an entry point
	 */

	public static void main(String[] args){
		//static: don't need an instance of HelloWorld to execute the method
		//void: return type, doesn't need to return anything
		//String[] args: array of string parameter to pass to main()

		//sysout+ctrl+space
		System.out.println("Hello World!");
		
	}
	
	/*
	 * STS (aka Eclipse) does incremental compiling
	 * every time a file is saved, it and any of its dependencies ar ecompiled
	 * compiling: converting from Java code to bytecode
	 *     .java (source code) to .class bytecode to be executed by the JVM
	 */
	
}



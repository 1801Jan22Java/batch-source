package com.revature.datetime;

public interface Thing {
	void methodOne( );

	default void methodTwo(){
		System.out.println("default method");
	}

	//Can be implemented by a class or interface.  
	//Default method is also considered public
	// Can also define static methods in interfaces. 

	static void methodThree () {
		System.out.println("static method");
	}  // We don't get the polymorphic effect with this, 


}

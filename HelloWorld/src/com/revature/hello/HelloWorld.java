package com.revature.hello;
/*
 * Author: Calvin Milliron
 */
import com.revature.oop.*;
import static com.revature.oop.Cat.*;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
	//without import
	com.revature.oop.Animal a = new com.revature.oop.Animal("Fred");
	//with import
	Dog d = new Dog();
	
	
}

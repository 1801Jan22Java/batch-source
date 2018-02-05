package com.revature.hello;
/*
 * Author: Calvin Milliron
 */
import com.revature.oop.*;
import static com.revature.oop.Cat.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World");
		new String();
		//without import
		com.revature.oop.Animal a = new com.revature.oop.Animal("Fred");
		//with import
		
		HashMap<Integer, String> b = new HashMap<>();
		b.put(1, "Zello");
		b.put(2, "Hello");

		System.out.println("calculating");
	      Calculator x = null;
	      x.calculate();
		
		
	}
	
}

abstract class Calculator{
	   abstract void calculate();
}

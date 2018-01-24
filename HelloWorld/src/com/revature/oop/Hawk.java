package com.revature.oop;

public class Hawk extends Raptor {

	public static void main(String[] args) {
		
		System.out.println("init");
		
		// even without this line, still all 'static' blocks in other classes still execute.
		// Bird / Raptor are in heirarchy, so they execute but everything else wouldn't be loaded.
		new Hawk();			
		
		System.out.println("hawk");
	}
}



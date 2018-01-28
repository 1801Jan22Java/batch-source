package com.revature.homework1;

/*
 *  Display the triangle on the console as follows using any type of loop. Do NOT use a simple
group of print statements to accomplish this.
 0
 1 0
 1 0 1
 0 1 0 1

 */
public class Question13 {
	
	
	public void doThing() {
		boolean foo = true;
		for(int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				if(foo)
					System.out.print("0 ");
				else
					System.out.print("1 ");
			
				foo = !foo;
			}
			System.out.println();
		}
	}

}

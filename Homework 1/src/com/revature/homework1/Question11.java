//Done!

package com.revature.homework1;
import com.revature.homework1.question11.*;		//The other package being referenced

public class Question11 {
	public static void main(String[] args) {
		
		//Simply print the values of float1 and float2 contained in the imported package
		System.out.println("First number is: " + Question11OtherClass.float1);
		System.out.println("Second number is: " + Question11OtherClass.float2);
	}
}

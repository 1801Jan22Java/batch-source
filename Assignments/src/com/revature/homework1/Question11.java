package com.revature.homework1;

public class Question11 {
	public static void accessExternalVariable () {
		System.out.println("Here is an external variable: " + com.revature.externalpackage.ExternalClass.PI);
		System.out.println("Here is another variable    : " + com.revature.externalpackage.ExternalClass.E + "\n");
	}
}

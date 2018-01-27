package com.revature.homework1a;

public class Question11 {
	//Declaring aStatic and bStatic as a public static float that can be accessed from another package
	public static float aStatic=5.0f;
	public static float bStatic= 5.32f;
	//Declaring cNotStatic as a public non-static float that cannot be accessed from another package
	public float cNotStatic=343.34f;
	
	/*
	 * getter method for cNotStatic for access cNotStatic from another package 
	 * @param none
	 * @return float  cNotStatic
	 * */
	public float getNotStatic()
	{
		return cNotStatic;
	}
	

}

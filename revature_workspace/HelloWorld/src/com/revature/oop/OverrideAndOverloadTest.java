package com.revature.oop;

public class OverrideAndOverloadTest {
	
	
	
	int a =0;
	
	public static int add(int a, int b)
	{
		System.out.println("Adding ints");
		return a+ b;
	}
	public static float add(float a, float b)
	{
		System.out.println("Adding floats");
		return a+b;
	}
	
	public static String add() 
	{
		System.out.println("return string");
		return "Blah";
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add(5,6);
		add(4.3f,5.6f);
		add();
		int a=5;
		for(int i=0;i<3;i++)
		{
		a=0;
		a++;	
		}
		System.out.println(a);
	
		
		
		

	}

}

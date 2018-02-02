package com.revature.homework1;
import java.util.*;
public class Question19 {
	
	private static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args)
	{
		int even =0 , odd =0;
		for (int i=1; i<=10; i++)
		{
			if (i%2 ==0)
			{
				even += i;
				continue;
			}
			odd += i;
		}
		System.out.println("the sum of all the even numbers between 1 and 10 is " + even);
		System.out.println("the sum of all the odd numbers between 1 and 10 is " + odd);
	}
}

package com.revature.homework1;
import java.util.*;

public class Question9 {
	private static ArrayList<Integer> list = new ArrayList();
	
	private static boolean isPrime(int num)
	{
		if (num==1)
		{
			return false;
		}
		else if (((num%2)> 0) && ((num%3) > 0) && ((num%5) > 0) && ((num%7) > 0))
		{
			return true;
		}
		else if(num == 2 || num == 3 || num ==5 || num ==7)
		{
			return true;
		}
		 
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 1; i <=100; i++)
		{
			list.add(i);
		}
		System.out.println("list of prime numbers");
		for(int x: list)
		{
			if(isPrime(x))
			{
				System.out.println(x);
			}
		}
	}

}

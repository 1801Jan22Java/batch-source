package com.revature.homework1;

import java.util.Comparator;

public class EmployeeComparator implements Comparator
{
	@Override
	public int compare(Object arg0, Object arg1) 
	{
		Employee emp1 = (Employee)arg0;
		Employee emp2 = (Employee)arg1;
		if(emp1.getName() == emp2.getName())
		{
			
		}
		return 0;
	}

}

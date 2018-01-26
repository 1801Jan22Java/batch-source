package com.revature.homework1;

import java.util.Comparator;

public class EmployeeCompare implements Comparator<Employee>
{

	@Override
	public int compare(Employee e1, Employee e2) 
	{
		if(e1.getName().compareTo(e2.getName())!=0)
		{
			return e1.getName().compareTo(e2.getName());
		}
		else if(new Integer(e1.getAge()).compareTo(new Integer(e2.getAge()))!=0)
		{
			return new Integer(e1.getAge()).compareTo(new Integer(e2.getAge()));
		}
		else
		{
			return e1.getDepartment().compareTo(e2.getDepartment());
		}
	}

}

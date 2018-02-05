package com.revature.cc2.challenge;
import com.revature.cc2.beans.Department;
import com.revature.cc2.dao.DepartmentDaoImpl;
/*
public class Driver {
	public static void main(String []args)
	{
		DepartmentDaoImpl ddi = new DepartmentDaoImpl();
		Department dept =ddi.getDepartmentByID(1001);
	//	System.out.println(dept.getDeptName());
		float prevAvgSalary = ddi.getPreviousAverageSalary(1001);
		float avgSalary = ddi.getAverageSalary(1001);
		
		//Float avg =( Float)avgSalary;
	
		
	}

}*/


public class Driver {
	public static void main(String []args)
	{
		DepartmentDaoImpl ddi = new DepartmentDaoImpl();
		Department dept =ddi.getDepartmentByID(1000);
		System.out.println(dept.getDeptName());
		float prevAvgSalary = ddi.getPreviousAverageSalary(1000);
		float avgSalary = ddi.getAverageSalary(1000);
		
		Float avg =( Float)avgSalary;
		System.out.println("Average salary was: " +prevAvgSalary);
		System.out.println("Average salary is: " +avgSalary);
	}

}

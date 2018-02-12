package com.revature.main;

import java.util.ArrayList;

import com.revature.beans.Department;
import com.revature.dao.DepartmentDaoImpl;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Welcome to the Department Place");
		DepartmentDaoImpl DDI = new DepartmentDaoImpl();
		Department d = new Department(1007, "Nonhuman Resources");
		ArrayList<Integer> money = DDI.getSalaries(d);
		Integer avg = 0;
		Integer count = 0;
		for(Integer i: money) {
			count++;
			avg += i;
		}
		
		avg /= count;
		System.out.println("Average Salary for " + d.getDepartmentName() + " is " + avg);
		
		DDI.giveRaise(d);
		money = DDI.getSalaries(d);
		count = 0;
		avg = 0;
		for(Integer i: money) {

			count++;
			avg += i;
		}
		avg /= count;
		System.out.println(" New Average Salary for " + d.getDepartmentName() + " is " + avg);
		
		

	}

}

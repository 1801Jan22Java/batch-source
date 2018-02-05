package com.revature.main;

import java.util.Map;
import java.util.Scanner;

import com.revature.dao.DepartmentDAO;
import com.revature.dao.DepartmentDAoImpl;

public class Driver {
	public static void main(String[] args) {
		
		DepartmentDAO depDao  = new DepartmentDAoImpl();
		Scanner scan = new Scanner(System.in);
		int depId = 1;
		Map<String, Double> deps = depDao.getAverageSalary();
		
		
		printDeps(deps);
		
		System.out.println("Give a department id to give a raise to");
		depId = scan.nextInt();
		
		depDao.giveRaiseToDepartmentById(depId);
		
		deps = depDao.getAverageSalary();
		
		printDeps(deps);
		
		System.out.println("Give a department id to give a raise to");
		depId = scan.nextInt();
		System.out.println("Give a percentage to increase by");
		int perIncr = scan.nextInt();
		
		depDao.giveRaiseToDepartmentById(depId, perIncr);
		deps = depDao.getAverageSalary();
		
		printDeps(deps);
		
	}
	
	private static void printDeps(Map<String, Double> deps) {
		System.out.println("Name     Average Salary");
		for (String name : deps.keySet()) {
			System.out.println(name + "     " + deps.get(name));
		}
		System.out.println();
	}
}

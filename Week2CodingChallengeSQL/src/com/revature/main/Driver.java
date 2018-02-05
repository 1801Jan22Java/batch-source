package com.revature.main;

import java.util.Scanner;

import com.revature.dao.WalmartEmployeeDaoImpl;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WalmartEmployeeDaoImpl w = new WalmartEmployeeDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Which department would you like to give a raise to?");
		int deptID = sc.nextInt();		//The ID of the department you'd like to give a raise to.
		sc.nextLine();
		
		
		System.out.println("Before the raises");
		w.printDeptNameSalary();
		
		w.giveRaise(deptID);

		System.out.println();
		System.out.println("After the raises");
		w.printDeptNameSalary();
	}

}

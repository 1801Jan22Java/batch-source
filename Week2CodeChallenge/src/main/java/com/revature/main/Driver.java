package com.revature.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Department;
import com.revature.dao.*;

public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Company");
		int mainChoice = 0;
		int deptChoice = 0;
		DepartmentDao dd = new DepartmentDaoImpl();
		EmployeeDao ed = new EmployeeDaoImpl();
		ArrayList<Department> departments = dd.getAverages();
		while(true) {
			mainChoice = getMainMenuOption();
			switch(mainChoice) {
			case 1:
				for(Department d : departments) {
					System.out.println(d.toString());
				}
				break;
			case 2:
				deptChoice = getDepartmentList(departments);
				int deptId = dd.getDeptIdByName(departments.get(deptChoice - 1).getDepartmentName());
				if (deptId == departments.size()) {
					break;
				} else {
					if (ed.giveRaise(deptId)) {
						departments = dd.getAverages();
						for(Department d : departments) {
							System.out.println(d.toString());
						}
					} else {
						System.out.println("Sorry, the raise didn't work.");
					}
				}
				break;
			}
			
		}
	}
	
	public static int getMainMenuOption() {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int menuOption = 0;
		System.out.println();
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.println("1 - View Averages");
			System.out.println("2 - Give Raise");
			System.out.print("What would you like to to? ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				menuOption = input.nextInt();
				input.nextLine();
				if (menuOption > 2 || menuOption < 1) {
					System.out.println("Sorry, that wasn't one of the options.\n");
					validInput = false;
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Sorry, that wasn't one of the options.\n");
				validInput = false;
				input.nextLine();
			}
		}
		System.out.println();
		return menuOption;
	}
	
	public static int getDepartmentList(ArrayList<Department> departments) {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int menuOption = 0;
		System.out.println();
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			int i = 1;
			for(Department d : departments) {
				System.out.println(i + " - " + d.toString());
				i++;
			}
			System.out.println(i + " - Quit");
			System.out.print("Which department? ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				menuOption = input.nextInt();
				input.nextLine();
				if (menuOption > i || menuOption < 1) {
					System.out.println("Sorry, that wasn't one of the options.\n");
					validInput = false;
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Sorry, that wasn't one of the options.\n");
				validInput = false;
				input.nextLine();
			}
		}
		System.out.println();
		return menuOption;
	}
}

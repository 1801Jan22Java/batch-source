package challenge.main;

import java.util.Scanner;
import challenge.dao.*;

public class Driver {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		boolean loggedOn = true;
		while (loggedOn) {
			System.out.println("welcome to the database please select an option\n");
			System.out.println(
					"1: view average salary of all departments\n" + "2: give a department a raise\n" + "3: logout");
			int choice = s.nextInt();
			s.nextLine();
			DepartmentDaoImpl ddi = new DepartmentDaoImpl();
			switch (choice) {

			case 1:
				ddi.printAllDeptNameAndSalary();
				break;

			case 2:
				break;

			case 3:
				s.close();
				loggedOn = false;
				break;

			}

		}

	}

}

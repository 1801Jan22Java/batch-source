package com.revature.project1.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.project1.beans.Employee;
import com.revature.project1.beans.ReimbursementRequest;
import com.revature.project1.dao.EmployeeDaoImpl;
import com.revature.project1.dao.ReimbursementRequestDaoImpl;
import com.revature.project1.util.ConnectionUtil;

public class Driver {
	public static void main(String [] args) 
	{
		String filename = "connection.properties";
		ConnectionUtil cu = new ConnectionUtil();
		//try here for connection
			try {
				Connection conn = cu.getConnectionFromFile(filename);
				EmployeeDaoImpl edi = new EmployeeDaoImpl();
				ReimbursementRequestDaoImpl rrdi = new ReimbursementRequestDaoImpl();
			//	Employee emp = new Employee("Mikhail","Bulgakov","mbulgakov","margarita","mbulgakov@yandex.ru",0,0);
				//System.out.println(emp.getEmail());
				//edi.addEmployee(emp);
				List<ReimbursementRequest> rl=rrdi.getReimbursementRequests();
				List<Employee> el = edi.getEmloyees();
				System.out.println("after getEmployee");
				//System.out.println(el);
				for(int i =0;i<rl.size();i++) 
				{
					System.out.println(rl.get(i));
				}
				
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}

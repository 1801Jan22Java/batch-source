package com.revature.project1.main;

import java.io.File;
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
				Connection conn = cu.getConnectionFromFile();
				EmployeeDaoImpl edi = new EmployeeDaoImpl();
				ReimbursementRequestDaoImpl rrdi = new ReimbursementRequestDaoImpl();
				Employee manager =edi.getEmployeeById(1022);
				Employee notManager = edi.getEmployeeById(1042);
				Employee emp2= edi.getEmployeeByCredentials("ngogol", "nose");
				System.out.println(emp2);
				Employee emp = new Employee("Marina","Tsvetaeva","mtsvetaeva","tsardevitsa","mtsvetaeva@yandex.ru",0,manager);
				List<ReimbursementRequest> rl=rrdi.getReimbursementRequestsByEmployee(emp2);
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

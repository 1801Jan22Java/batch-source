package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Files;
import com.revature.beans.Notes;
import com.revature.beans.Request;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.FilesDao;
import com.revature.dao.FilesDaoImpl;
import com.revature.dao.NotesDao;
import com.revature.dao.NotesDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {

		/*
		//Employee emp = new Employee(1001, "John", "Doe", "JohnDoeDontKnow@hotmail.com", "JohnDoe55", "coolpassword", 0);
		EmployeeDao edi = new EmployeeDaoImpl();
		//edi.createEmployee(1001, "John", "Doe", "JohnDoeDontKnow@hotmail.com", "JohnDoe55", "coolpassword", 0);
		Employee emp2 = edi.getEmpByID(1021);
		//System.out.println(emp2.toString());
		edi.modifyEmployeeField("EMPLOYEE_PASSWORD", "I no longer remember", emp2);
		ArrayList<Employee> allEmps = edi.getAllEmployees();
		for (int i = 0; i < allEmps.size(); i++)
		{
			System.out.println(allEmps.get(i).toString());
		}
		
		
		//Request req = new Request(1001, 1001, 12, 1, "I am going to Hawaii and I need money to make sure I do not get permanently lost there.", 200.00, LocalDate.now(), LocalDate.now());
		RequestDao rdi = new RequestDaoImpl();
		rdi.createRequest(1002, 1021, 19, 5, "I like turtles.", 999, LocalDate.now(), LocalDate.now(), 1021);
		Request req = rdi.getReqByID(1021);
		//System.out.println(req.toString());
		//rdi.modifyReqStatus(6, req);
		ArrayList<Request> incReq = rdi.getIncompleteRequests();
		ArrayList<Request> compReq = rdi.getCompleteRequests();
		System.out.println("Incomplete: ");
		for (int i = 0; i < incReq.size(); i++)
		{
			System.out.println(incReq.get(i).toString());
		}
		System.out.println("Complete: ");
		for (int i = 0; i < compReq.size(); i++)
		{
			System.out.println(compReq.get(i).toString());
		}
		*/
		
		/*
		RequestDao rdi = new RequestDaoImpl();
		Request req2 = rdi.getRequestByEmployee(1021);
		System.out.println(req2.toString());
		*/
		
		/*
		FilesDao fdi = new FilesDaoImpl();
		fdi.createFile(1001, "awesome.jpeg", 1023, null);
		Files files = fdi.getFileByID(1001);
		System.out.println(files.toString());
		*/
		/*
		NotesDao ndi = new NotesDaoImpl();
		ndi.createNote(1022, 1023, LocalDate.now(), "I feel like I did something wrong... but what?", 1021);
		Notes notes = ndi.getNoteByID(1002);
		System.out.println(notes.toString());*/
		
		/*
		EmployeeDao edi = new EmployeeDaoImpl();
		//edi.createEmployee(1001, "John", "Doe", "JohnDoeDontKnow@hotmail.com", "JohnDoe55", "coolpassword", 0);
		Employee emp2 = edi.getEmpByAcc("JohnDoe55");
		System.out.println(emp2.toString());*/
	}

	

}

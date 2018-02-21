package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import beans.Employee;
import beans.Manager;
import dao.DocumentDAOImpl;
import dao.EmployeeDAOImpl;
import dao.ManagerDAOImpl;
import dao.RequestDAOImpl;
import dao.StatusDAOImpl;

public class ServerManager 
{
	public DocumentDAOImpl docDao = new DocumentDAOImpl();
	public EmployeeDAOImpl empDao = new EmployeeDAOImpl();
	public RequestDAOImpl reqDao = new RequestDAOImpl();
	public StatusDAOImpl statDao = new StatusDAOImpl();
	public ManagerDAOImpl manDao = new ManagerDAOImpl();
	
	public Employee currentEmployee;
	public Manager currentManager;
	
	public int login(String username, String password)
	{
		for(Employee e: empDao.getEmployees())
		{
			if(e.getUserName().equals(username) && e.getPassword().equals(password))
			{
				this.currentEmployee = e;
				return 1;
			}
		}
		return -1;
	}
	public int managerLogin(String username, String password)
	{
		for(Manager m: manDao.getManagers())
		{
			if(m.getUserName().equals(username) && m.getPassWord().equals(password))
			{
				this.currentManager = m;
				return 1;
			}
		}
		return -1;
	}
	public void changePic( int empId)
	{
		byte[] pic = empDao.getEmployee(empId).getProfilePic();
		System.out.println(pic.toString());
		File file = new File("C:/Users/panda/Documents/GitRepos/1801-jan22-java/batch-source/Project1Reimbersments/src/main/resources/pics/temp.jpg");
		OutputStream out=null;
		try {
			out = new FileOutputStream(file);
			out.write(pic);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void managerChangePic( int manId)
	{
		byte[] pic = manDao.getManagerById(manId).getProfilePicture();
		System.out.println(pic.toString());
		File file = new File("C:/Users/panda/Documents/GitRepos/1801-jan22-java/batch-source/Project1Reimbersments/src/main/resources/pics/manager.jpg");
		OutputStream out=null;
		try {
			out = new FileOutputStream(file);
			out.write(pic);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void changeRequestDocument( int requestId, byte[] pic)
	{
		docDao.uploadDocument(requestId, pic);
	}
}

package com.revature.project1.dao;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.revature.project1.beans.Employee;
import com.revature.project1.util.ConnectionUtil;


public class EmployeeDaoImpl implements EmployeeDao{

	private static String filename = "connection.properties";

	
	@Override
	public List<Employee> getEmployees(){
		//System.out.println("Entered method");
		List<Employee> el = new ArrayList<Employee>();
		Employee emp = null;
		Connection con;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement prepStmt= con.prepareStatement("SELECT * FROM EMPLOYEE");
			
			prepStmt.execute();
			ResultSet rs = prepStmt.getResultSet();
			//System.out.println("executing query");
			while(rs.next()) {
				//System.out.println("Getting employee");
				String user_name=rs.getString("USER_NAME");
				String pass = rs.getString("USER_PASS");
				String fname = rs.getString("FIRST_NAME");
				String lname= rs.getString("LAST_NAME");
				String email=rs.getString("EMP_EMAIL");
				int isManager= rs.getInt("MANAGING");
				int managerId=rs.getInt("MANAGED_BY");
				Employee managedBy= getEmployeeById(managerId);
				emp=new Employee(fname,lname,user_name,pass,email,isManager,managedBy);
				el.add(emp);			
			}	
		} 
		catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return el;
	}

	public Employee getEmployeeById(int id) {
		Employee emp = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{

			PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMP_ID="+id);
			prepStmt.execute();
			ResultSet rs= prepStmt.getResultSet();
			if(rs.next())
			{
				//System.out.println("Getting employee");
				String user_name=rs.getString("USER_NAME");
				String pass = rs.getString("USER_PASS");
				String fname = rs.getString("FIRST_NAME");
				String lname= rs.getString("LAST_NAME");
				String email=rs.getString("EMP_EMAIL");
				int isManager= rs.getInt("MANAGING");
				int managerID=rs.getInt("MANAGED_BY");
				Employee managedBy=getEmployeeById(managerID);
				emp=new Employee(fname,lname,user_name,pass,email,isManager,managedBy);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			return emp;
		}
	}

	private Employee createEmployeeObject(){
		Employee user = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter user firstname");
		String name = sc.nextLine();
		System.out.println("Please enter user lastname");
		String lname = sc.nextLine();
		System.out.println("Please enter user username");
		String username=sc.nextLine();
		System.out.println("Please enter user password");
		String pw = sc.nextLine();
		//user =new Employee(username,pw,name,lname,ssn);
		return user;
	}

	/*
	public void addEmployee(Employee user) {

		if(!validateManager(user))
		{
			System.out.println("You do not carry the membership");
			System.out.println(user.getManagerID());
		}
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			Employee employee= createEmployeeObject();
			conn.setAutoCommit(false);
			//	System.out.println("In try statement"); //DEBUGGING
			String sqlStmt="{CALL SP_ADD_EMPLOYEE(?,?,?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sqlStmt);
			cs.setString(1,employee.getUserName());
			cs.setString(2,employee.getPassword());
			cs.setString(3, employee.getFirstName());
			cs.setString(4,employee.getLastName());
			cs.setString(5, employee.getEmail());
			cs.setInt(6, employee.getIsManager());
			cs.setInt(7, employee.getManagerID());
			cs.execute();
			conn.commit();
			System.out.println("Employee added");

		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			System.out.println("A user with that username already exists!");
		}
		catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}
	*/
	public void addEmployee(Employee employee) {
		int managerID = getEmployeeID(employee.getManager());
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			if(verifyUniqueUsername(employee)) {
			conn.setAutoCommit(false);
			//	System.out.println("In try statement"); //DEBUGGING
			String sqlStmt="{CALL SP_ADD_EMPLOYEE(?,?,?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sqlStmt);
			cs.setString(1,employee.getUserName());
			cs.setString(2,employee.getPassword());
			cs.setString(3, employee.getFirstName());
			cs.setString(4,employee.getLastName());
			cs.setString(5,employee.getEmail());
			cs.setInt(6,employee.getIsManager());
			cs.setInt(7,managerID);
			cs.execute();
			conn.commit();
			System.out.println("Employee added");
			}
			else {
				System.out.println("Username must be unique!");
			}
			

		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			System.out.println("A user with that username already exists!");
		}
		catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}

	/*public void addManager(Employee employee) {

		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{

			conn.setAutoCommit(false);
			//System.out.println("In try statement");//DEBUGGING
			String sqlStmt="{CALL SP_ADD_EMPLOYEE(?,?,?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sqlStmt);
			cs.setString(1,employee.getUserName());
			cs.setString(2,employee.getPassword());
			cs.setString(3, employee.getFirstName());
			cs.setString(4,employee.getLastName());
			cs.setString(5, employee.getEmail());
			cs.setInt(6, employee.getIsManager());
			cs.setInt(7, getEmployeeByID(employee.getManagerID()));
			cs.execute();
			conn.commit();

		}catch(SQLIntegrityConstraintViolationException e)
		{
			System.out.println("A user with that username already exists!");
		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}


	}
*/
	public boolean validateCredentials(String username, String password) {
		boolean validated=false;
		String userPass=null;
		String userName= null;
		//	String sql = "SELECT USER_ID,USER_NAME,USER_PASS FROM USERS WHERE USER_NAME=?";
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT EMP_ID,USER_NAME,USER_PASS FROM EMPLOYEE WHERE USER_NAME=?");
			ps.setString(1, username);
			ps.execute();
			ResultSet rs =ps.getResultSet();
			if(rs.next())
			{
				userName=rs.getString("USER_NAME");
				userPass=rs.getString("USER_PASS");	
				if(username.equals(userName)&&password.equals(userPass))
				{
					validated=true;
					//	System.out.println("validated");//DEBUGGING
				}
			}
		}
		catch(SQLException | IOException e){ e.printStackTrace();
		}
		finally{
			return validated;
		}
	}

	private boolean verifyUniqueUsername(Employee employee) {
		boolean unique =false;
		String username=employee.getUserName();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{

			PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE USER_NAME=?");
			prepStmt.setString(1, username);
			prepStmt.execute();
			ResultSet rs= prepStmt.getResultSet();
			if(rs.next())
			{
				String usename=rs.getString("USER_NAME");
				unique=false;
			}
			else {
				unique=true;
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		return unique;
		}
	}
	/*
	 * createEmployee for average users.  
	 * Does not attempt any kind of user validation for a super user. 
	 * This is for first time users.
	 * calls createEmployee object and returns a user.
	 * Then adds that user to the database.
	 * @param none
	 * @return Employee user
	 * */
	public Employee createEmployee() {
		Employee employee = createEmployeeObject();
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			conn.setAutoCommit(false);
			//	System.out.println("In try statement");//DEBUGGING
			String sqlStmt="{CALL SP_ADD_EMPLOYEE(?,?,?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sqlStmt);
			cs.setString(1,employee.getUserName());
			cs.setString(2,employee.getPassword());
			cs.setString(3, employee.getFirstName());
			cs.setString(4,employee.getLastName());
			cs.setString(5, employee.getEmail());
			cs.setInt(6, employee.getIsManager());
			cs.setInt(7, getEmployeeID(employee.getManager()));
			cs.execute();
			conn.commit();
			System.out.println("Employee added");

		} 
		catch(SQLIntegrityConstraintViolationException e)
		{
			System.out.println("A user with that username already exists!");
		}
		catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}
		System.out.println("Employee creation successful!");
		return employee;

	}

	public int getEmployeeID(Employee employee) {
		int userId=0;
		String username=employee.getUserName();
		String sql = "SELECT EMP_ID FROM EMPLOYEE WHERE USER_NAME=?";
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.execute();
			ResultSet rs =ps.getResultSet();
			if(rs.next())
			{
				userId=rs.getInt("EMP_ID");
			}
		}
		catch(SQLException | IOException e){ e.printStackTrace();}
		return userId;
	}
	/*
	 *getEmployeeByCredentials takes in two strings, username and password and 
	 *returns a Employee.
	 *
	 *
	 * @param String username, String password
	 * @return Employee user
	 * */
	
	public Employee getEmployeeByCredentials(String username, String password) {
		Employee employee = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{

			PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE USER_NAME=? AND USER_PASS=?");
			prepStmt.setString(1, username);
			prepStmt.setString(2,password);
			prepStmt.execute();
			ResultSet rs= prepStmt.getResultSet();
			if(rs.next())
			{
				String usenam=rs.getString("USER_NAME");
				String pass = rs.getString("USER_PASS");
				String fname = rs.getString("FIRST_NAME");
				String lname= rs.getString("LAST_NAME");
				String email=rs.getString("EMP_EMAIL");
				int isManager= rs.getInt("MANAGING");
				int managerID=rs.getInt("MANAGED_BY");
				Employee managedBy = getEmployeeById(managerID);
				employee=new Employee(fname,lname,username,password,email,isManager,managedBy);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			return employee;
		}
	}

	
	public Employee logout() {
		Employee user =null;
		try(Connection conn = new ConnectionUtil().getConnectionFromFile(filename))
		{
			try{
				conn.close();
				System.out.println("You have been logged out. Thank you for using the JDBC Banking console!");
			}
			catch(SQLException e)
			{
				//e.printStackTrace();
			}


		}
		catch(SQLException | IOException e){//e.printStackTrace();
		}
		finally{return user;}
	}

	public boolean validateManager(Employee user) {
		boolean isSuperEmployee=  false;
		try(Connection conn = new ConnectionUtil().getConnectionFromFile(filename))
		{
			String username = user.getUserName();
			String password = user.getPassword();
			PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM USERS WHERE USER_NAME=? AND USER_PASS=?");
			prepStmt.setString(1, username);
			prepStmt.setString(2,password);
			prepStmt.execute();
			ResultSet rs= prepStmt.getResultSet();
			while(rs.next())
			{
				int superEmployee = rs.getInt("SUPER_USER");
				if(superEmployee==1)
				{
					isSuperEmployee=true;
				}
			}
		}
		catch(IOException | SQLException e)
		{e.printStackTrace();
		}
		return isSuperEmployee;
	}

	public void deleteEmployee(Employee user1, Employee user2) {

		if(!validateManager(user1))
		{
			System.out.println("You do not carry the membership");
			System.out.println(user1.getManager());
		}
		else
		{
			int userID = getEmployeeID(user2);
			try(Connection conn=  ConnectionUtil.getConnectionFromFile(filename))
			{
				String sqlStr = "{CALL SP_DELETE_EMPLOYEE(?)}";
				CallableStatement cs = conn.prepareCall(sqlStr);
				cs.setInt(1, userID);
				cs.execute();
				System.out.println("Employee "+ userID + " has been deleted");
			} 
			catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public Employee getManagerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee createUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmloyees() {
		System.out.println("Entered method");
		List<Employee> el = new ArrayList<Employee>();
		Employee emp = null;
		Connection con;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement prepStmt= con.prepareStatement("SELECT * FROM EMPLOYEE");
			
			prepStmt.execute();
			ResultSet rs = prepStmt.getResultSet();
			System.out.println("executing query");
			while(rs.next()) {
				System.out.println("Getting employee");
				String user_name=rs.getString("USER_NAME");
				String pass = rs.getString("USER_PASS");
				String fname = rs.getString("FIRST_NAME");
				String lname= rs.getString("LAST_NAME");
				String email=rs.getString("EMP_EMAIL");
				int isManager= rs.getInt("MANAGING");
				int managerID=rs.getInt("MANAGED_BY");
				Employee managedBy = getEmployeeById(managerID);
				emp=new Employee(fname,lname,user_name,pass,email,isManager,managedBy);
				el.add(emp);			
			}	
		} 
		catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return el;
	}

}





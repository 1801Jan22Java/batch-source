package dao;
//Fin
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Document;
import beans.Employee;
import util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO
{
	@Override
	public ArrayList<Employee> getEmployees() 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "SELECT * FROM EMPLOYEE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(stmt);
			ArrayList<Employee> emps = new ArrayList<Employee>();
			while (rs.next())
			{
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				String userName = rs.getString("USER_NAME");
				String passWord = rs.getString("PASS_WORD");
				int managerId = rs.getInt("MANAGER_ID");
				Blob pic = null;
				pic = rs.getBlob("PROFILE_PIC");
				InputStream in = pic.getBinaryStream();
				ByteArrayOutputStream bao = new ByteArrayOutputStream();
				int i = 0;
				while((i=in.read())!=-1)
				{
					bao.write(i);
				}
				Employee e = new Employee(employeeId, firstName, lastName, email, userName, passWord, managerId, bao.toByteArray());
				emps.add(e);
			}
			con.close();
			return emps;
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployee(int id) {
		ArrayList<Employee> emps = this.getEmployees();
		for(Employee emp : emps)
		{
			if(emp.getEmployeeId()==id)
				{
					return emp;
				}
		}
		return null;
	}

	@Override
	public boolean addEmployee(Employee e) {
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "INSERT INTO EMPLOYEE(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, USER_NAME, PASS_WORD, MANAGER_ID, MANAGER) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, e.getEmployeeId());
			pstmt.setString(2, e.getFirstName());
			pstmt.setString(3, e.getLastName());
			pstmt.setString(4, e.getUserName());
			pstmt.setString(5, e.getPassword());
			pstmt.setInt(6, e.getManagerId());
			return pstmt.execute();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		} 
		catch (IOException e2) 
		{
			e2.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeEmployee(int id) {
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = null;;
			pstmt.setInt(1, id);
			return pstmt.execute();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		} 
		catch (IOException e2) 
		{
			e2.printStackTrace();
		}
		return false;
	}
	@Override
	public ArrayList<Employee> getEmployeesByManager(int managerId) {
		
		ArrayList<Employee> emps = new ArrayList<Employee>();
		for(Employee e: this.getEmployees())
		{
			if(e.getManagerId()==managerId)
			{
				emps.add(e);
			}
		}
		return emps;
	}

}


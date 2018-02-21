package dao;
import java.io.ByteArrayOutputStream;
//Fin
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

import beans.Employee;
import beans.Manager;
import util.ConnectionUtil;

public class ManagerDAOImpl implements ManagerDAO
{
	private static String filename = "Properties";
	@Override
	public ArrayList<Manager> getManagers() {
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "SELECT * FROM MANAGER";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(stmt);
			ArrayList<Manager> mans = new ArrayList<Manager>();
			while (rs.next())
			{
				int employeeId = rs.getInt("EMPLOYEE_ID");
				int manager = rs.getInt("MANAGER");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				String userName = rs.getString("USER_NAME");
				String passWord = rs.getString("PASS_WORD");
				int managerId = rs.getInt("MANAGER_ID");
				Blob pic = null;
				ByteArrayOutputStream bao = null;
				pic = rs.getBlob("PROFILE_PIC");
				if(pic != null)
				{InputStream in = pic.getBinaryStream();
				bao = new ByteArrayOutputStream();
				int i = 0;
				while((i=in.read())!=-1)
				{
					bao.write(i);
				}
				Manager m = new Manager(employeeId, manager,managerId, firstName, lastName, email, userName, passWord,  bao.toByteArray());
				mans.add(m);
				}
				else {
					Manager m = new Manager(employeeId, manager,managerId, firstName, lastName, email, userName, passWord,  null);
					mans.add(m);
				}
				
				
			}
			con.close();
			return mans;
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
	public boolean addManager(Manager m) {
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "INSERT INTO MANAGER(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, USER_NAME, PASS_WORD, MANAGER_ID) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m.getEmployeeId());
			pstmt.setString(2, m.getFirstName());
			pstmt.setString(3, m.getLastName());
			pstmt.setString(4, m.getUserName());
			pstmt.setString(5, m.getPassWord());
			pstmt.setInt(6, m.getManagerId());
			pstmt.setInt(7, m.getManager());
			return true;
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
	public boolean removeManager(int id) {
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "DELETE FROM MANAGER WHERE EMPLOYEE_ID = ?";
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
	public Manager getManagerById(int id) 
	{
		for(Manager man : this.getManagers())
		{
			if(man.getEmployeeId()==id)
			{
				return man;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		ManagerDAOImpl man = new ManagerDAOImpl();
		System.out.println(man.getManagers());
	}

}

package DOA;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.department;
import beans.employee;
import util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO
{
	private String filename = "PropertiesCCW2";
	@Override
	public ArrayList<employee> getEmployees() {
		
			ArrayList<employee> emp = new ArrayList<>();
			try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
			{
				String sql = "SELECT * FROM EMPLOYEE";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next())
				{
					int employeeId = rs.getInt("EMPLOYEE_ID");
					String firstName = rs.getString("EMPLOYEE_FIRST_NAME");
					String lastName = rs.getString("EMPLOYEE_LAST_NAME");
					int departmentId = rs.getInt("DEPARTMENT_ID");
					float salary = rs.getFloat("SALARY");
					String email = rs.getString("EMPLOYEE_EMAIL");
					employee e = new employee(employeeId, firstName, lastName, departmentId, salary, email);
					emp.add(e);
				}
				con.close();
			} catch (SQLException e){
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return emp;
	}

	@Override
	public department addEmployee(String fistName, String lastName, int departmentId, float salary, String email) {
		// TODO Auto-generated method stub
		return null;
	}

}

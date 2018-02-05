package DOA;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.*;


import beans.department;

public class DepartmentDAOImpl implements DepartmentDAO
{
	private static String filename = "PropertiesCCW2";
	@Override
	public ArrayList<department> getDepartments() {
		ArrayList<department> dep = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM DEPARTMENT";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				int departmentId = rs.getInt("DEPARTMENT_ID");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				department d = new department(departmentId,departmentName);
				dep.add(d);
			}
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return dep;
	}

	@Override
	public department addDepartment(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

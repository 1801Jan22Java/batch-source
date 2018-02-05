import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Week2CodingChallenge implement W2ChallengeDAO{
	private static String filename = "Connections.properties";

	
	@Override
   public void printDepartmentNameSalary(String department) {
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			// using a Statement - beware SQL injection
			PreparedStatement stmt = con.createStatement();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void giveRaise(int department_id) {
		CallableStatement callable = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
	
}
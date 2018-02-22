package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Position;
import com.revature.util.ConnectionUtil;

public class PositionDAOImpl implements PositionDAO{

	@Override
	public Position getPositionById(int id) {
		Position positionTitle = new Position();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM POSITIONS WHERE POSITION_ID = ?");
			pstmt.setInt(1,  id);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				String positionName = results.getString("POSITION_CODE");
				positionTitle.setPositionName(positionName);
				positionTitle.setPositionId(id);
			};
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return positionTitle;
	}

	@Override
	public List<Position> viewAllPositions() {
		List<Position> allPositions = new ArrayList<Position>();
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM POSITIONS");
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				String positionName = results.getString("POSITION_CODE");
				int id = results.getInt("POSITION_ID");
				allPositions.add(new Position(id, positionName));
			};
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allPositions;
	}

}

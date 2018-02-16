package com.revature.dao;

import java.util.List;

import com.revature.beans.Position;

public interface PositionDAO {
	public Position getPositionById(int id);
	public List<Position> viewAllPositions();
}

package com.revature.beans;

public class Position {
	public Position() {
		super();
	}
	public Position(int positionId, String positionName) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
	}
	private int positionId;
	private String positionName;
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", positionName=" + positionName + "]";
	}
	
}

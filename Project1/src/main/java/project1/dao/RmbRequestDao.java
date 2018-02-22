package project1.dao;

import java.util.List;

import project1.beans.RmbRequest;

public interface RmbRequestDao {

	public void submitRequest(int empId, String image);
	public List<RmbRequest> viewPendingByEmpId(int empId);
	public List<RmbRequest> viewResolvedByEmpId(int empId);
	public List<RmbRequest> viewAllPending();
	public List<RmbRequest> viewAllResolved();
	public List<RmbRequest> viewRequestsByEmpId(int empId);
	public void approveDenyRequest(int reqId, int status, String managerName);
}

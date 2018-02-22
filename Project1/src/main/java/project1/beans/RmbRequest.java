package project1.beans;

public class RmbRequest {

	public RmbRequest(int requestId, int empId, int status, String image, String manager) {
		super();
		this.requestId = requestId;
		this.empId = empId;
		this.status = status;
		this.image = image;
		this.manager = manager;
	}
	public RmbRequest() {
		super();
	}
	private int requestId;
	private int empId;
	private int status;
	private String image;
	private String manager;
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
}

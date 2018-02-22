package beans;


public class Request 
{
	public Request(int requestId, int employeeId, float amountRequested, int statusId ,String description) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.amountRequested = amountRequested;
		this.statusId = statusId;
		this.description = description;
	}
	private int requestId;
	private int employeeId;
	private float amountRequested;
	private int statusId;
	private String description;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public float getAmountRequested() {
		return amountRequested;
	}
	public void setAmountRequested(float amountRequested) {
		this.amountRequested = amountRequested;
	}
	public int getStatus() {
		return statusId;
	}
	public void setStatus(int status) {
		this.statusId = status;
	}
	public String toString() {
		return this.getRequestId()+" "+this.getAmountRequested();
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

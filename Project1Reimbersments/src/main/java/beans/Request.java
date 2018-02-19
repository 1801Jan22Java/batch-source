package beans;


public class Request 
{
	public Request(int requestId, int employeeId, float amountRequested, int statusId) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.amountRequested = amountRequested;
		this.statusId = statusId;
	}
	private int requestId;
	private int employeeId;
	private float amountRequested;
	private int statusId;
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
}

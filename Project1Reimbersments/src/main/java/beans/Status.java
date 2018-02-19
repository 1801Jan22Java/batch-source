package beans;

public class Status 
{
	public Status(String name, int statusId) {
		super();
		this.name = name;
		this.statusId = statusId;
	}
	private String name;
	private int statusId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
}

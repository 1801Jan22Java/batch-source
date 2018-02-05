package beans;
//Columns: Columns: DEPARTMENT_ID, DEPARTMENT_NAME
public class department 
{
	public department(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	private int departmentId;
	private String departmentName;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String toString()
	{
		return this.departmentName;
	}
}

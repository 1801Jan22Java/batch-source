package challenge.beans;

public class Employee {

	public Employee() {
		super();
	}
	public Employee(int employeeId, String firstName, String lastName, int departmentId, int salary, String email) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
		this.salary = salary;
		this.email = email;
	}
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private int departmentId;
	private int salary;
	private String email;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", departmentId=" + departmentId + ", salary=" + salary + ", email=" + email + "]";
	}
}

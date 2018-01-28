package question7;

// Q7. Sort two employees based on their name, department, and age using the Comparator
// interface.
public class Employee {

	private String name;
	private String department;
	private int age;
	
	public Employee () {
		
	}

	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
}

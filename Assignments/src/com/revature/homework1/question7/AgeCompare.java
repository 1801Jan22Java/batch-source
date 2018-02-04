package question7;

import java.util.Comparator;

public class AgeCompare implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		Integer age1 = employee1.getAge();
		return age1.compareTo(employee2.getAge());
	}

}

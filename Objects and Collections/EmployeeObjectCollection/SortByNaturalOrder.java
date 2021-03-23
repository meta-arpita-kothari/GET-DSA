package EmployeeObjectCollection;

import java.util.Comparator;

/*
 * Comparator in Java compares two different class objects provided.
 * 
 */
class SortByNaturalOrder implements Comparator<Employee> {

	/*
	 * compare two employee objects
	 */
	public int compare(Employee e1, Employee e2) {
		// sort in ascending order by EmpId
		return e1.getEmpId() - e2.getEmpId();
	}
	
}

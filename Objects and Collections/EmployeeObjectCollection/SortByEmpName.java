package EmployeeObjectCollection;

import java.util.Comparator;
/*
 * Comparator in Java compares two different class objects provided.
 * 
 */
class SortByEmpName implements Comparator<Employee> {

	// Sorting in ascending order by Employee name
	/*
	 * compare two employee objects
	 */
	public int compare(Employee e1, Employee e2) {
		
		return e1.getEmpName().compareTo(e2.getEmpName());
	}

}
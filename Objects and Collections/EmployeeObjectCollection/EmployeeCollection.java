package EmployeeObjectCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Class to contain employee collection and its methods
 */
public class EmployeeCollection {
	List<Employee> empList = new ArrayList<Employee>();
	
	/**
	 * helper method to check duplicate entry of given id
	 * 
	 * @param empId
	 * @return
	 */
	public boolean checkDuplicateEmployeeEntry(int empId){
		for(Employee e : empList){
			
			if(e.getEmpId() == empId)
				return true;
		}
		return false;
	}
	/**
	 * method to add employee to Employee list
	 * @param empId
	 * @param empName
	 * @param empAddress
	 */
	public void addEmployee(int empId, String empName, String empAddress){
		empList.add(new Employee(empId, empName, empAddress));
	}
	
	/**
	 * display employees in the list
	 */
	public void displayEmployees(){
		System.out.println("Employee List: ");
		
		int i =1;
		for(Employee e : empList){
			System.out.println("---------------------------------------------------");
			System.out.println(i+".) EMPLOYEE ID : "+ e.getEmpId());
			System.out.println("   EMPLOYEE NAME : " + e.getEmpName());
			System.out.println("   EMPLOYEE Address : " + e.getEmpAddress());
			System.out.println("---------------------------------------------------");
			
			i++;
		}
		
	}
	
	/**
	 * method to sort by natural order
	 * create object of SortByNaturalOrder class
	 * override sort method of Collections class
	 */
	public void sortByNaturalOrder(){
		if(empList == null){
			System.out.println("Employee list is empty!");
		}
		else{
			SortByNaturalOrder naturalOrder = new SortByNaturalOrder();
			Collections.sort(empList, naturalOrder);
			System.out.println("Sorting by Natural Order done successfully !");
		}
			
	}
	
	/**
	 * method to sort by employee name in ascending order
	 * create object of SortByEmpName class
	 * override sort method of Collections class
	 */
	public void sortByEmpName(){
		
		if(empList == null){
			System.out.println("Employee list is empty!");
		}
		else{
			SortByEmpName sortByEmpName = new SortByEmpName();
			Collections.sort(empList, sortByEmpName);
			System.out.println("Sorting by Employee Name done successfully !");
		}
				
	}
}

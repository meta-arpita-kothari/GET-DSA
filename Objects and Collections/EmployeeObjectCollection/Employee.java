package EmployeeObjectCollection;

/*
 * Class containing information on employee 
 * Employee with fields as empId, name and address
 * Employee id would be unique
 */
public class Employee {

	private Integer empId;
	private String empName;
	private String empAddress;

	/**
	 * Constructor to initialize employee attributes
	 * @param empId
	 * @param empName
	 * @param empAddress
	 */
	public Employee(Integer empId, String empName, String empAddress) {
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}
	
	/**
	 * return employeeId
	 * @return Integer
	 */
	public int getEmpId(){
		return this.empId;
	}
	
	/**
	 * return employee Name
	 * @return String
	 */
	public String getEmpName(){
		return this.empName;
	}
	
	/**
	 * return employee Address
	 * @return
	 */
	public String getEmpAddress(){
		return this.empAddress;
	}

}

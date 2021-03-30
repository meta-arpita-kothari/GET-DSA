package Employee_QuickSort;

/*
 * class for employee node
 */
class EmpNode {
	String name;
	int age;
	double salary;
	EmpNode nextEmployee;

	/**
	 * Constructor is used to initialize the value of employee
	 * 
	 * @param name
	 *            string type value
	 * @param age
	 *            integer type value
	 * @param salary
	 *            integer type value
	 */
	public EmpNode(String name, int age, double salary) {
		this.age = age;
		this.salary = salary;
		this.name = name;
		this.nextEmployee = null;
	}
}


/*
 * class containing methods performed on linked list of Employees
 */
public class Employees {
	public EmpNode headEmloyee = null;

	/**
	 * method to insert employee node
	 * @param name
	 * @param salary
	 * @param salary
	 */
	public void addEmployee(String name,int age, Double salary) {
		EmpNode newNode = new EmpNode(name, age, salary);
		if (headEmloyee == null) {
			headEmloyee = newNode;
		} else {
			EmpNode temp = headEmloyee;
			while (temp.nextEmployee != null) {
				temp = temp.nextEmployee;
			}
			temp.nextEmployee = newNode;
		}
		System.out.println("\nEmployees added successfully.");
		
	}

	/**
	 * method to print the data of employees
	 */
	public void displayEmployee() {
		if (this.headEmloyee == null) {
			System.out.println("No employee data available.");
		}
		EmpNode temp = this.headEmloyee;
		while (temp != null) {
			System.out.println("-----------------------------------");
			System.out.println("Employees Name :"+temp.name);
			System.out.println("Employees Age :"+temp.age);
			System.out.println("Employees Salary :"+temp.salary);
			temp = temp.nextEmployee;
		}
	}

	/**sorting of linked list through quick sort
	 * takes first and last node, but do not break any links in
	 *  the whole linked list
	 *  
	 * @param start, end
	 */
	/**
	 * this compare the both of employees on bases of their salary and ages
	 * @param employee1 the first employee to compare
	 * @param employee2 the second employee to compare
	 * @return the comparison result after comparing both the employees
	 */
	public int compareEmployees(EmpNode employee1,EmpNode employee2)
	{
		if(employee1.salary > employee2.salary)
		{
			return 1;
		}
		else if(employee1.salary < employee2.salary)
		{
			return -1;
		}
		else
		{
			if(employee1.age >  employee2.age)
			{
				return -1;
			}
			else if(employee1.age < employee2.age)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}
	
	/*
	 * method to get last node of list
	 */
	public EmpNode getLast(EmpNode head)
	{
		EmpNode employee=head;
		while(employee!=null && employee.nextEmployee!=null)
		{
			employee=employee.nextEmployee;
		}
		return employee;
	}
	
	/**
	 * this method do partition of the linked list using pivot element
	 * @param head the starting node after partition
	 * @param end the last node of linked list after partition
	 * @return the head ,pivot and end node of linked list in array form
	 */
	public EmpNode[] doPartition(EmpNode start,EmpNode end)
	{
		if (start == end || start == null || end == null){
			EmpNode employees[]= {start,end,end};
			return employees;
		}
          
		EmpNode pivot=end;
		EmpNode current=start;
		EmpNode previous=null;
		EmpNode newHead=null;
		EmpNode newEnd=null;
		while(current!=pivot)
		{
			int comparisonResult=this.compareEmployees(current,pivot);
			if(comparisonResult==1)
			{
				if(newHead==null)
				{
					newHead=current;
				}
				previous=current;
				current=current.nextEmployee;
			}
			else
			{
				if(previous!=null)
				{
					previous.nextEmployee=current.nextEmployee;
				}
				EmpNode temp=current.nextEmployee;
				current.nextEmployee=null;
				end.nextEmployee=current;
				end=current;
				current=temp;
			}
		}
		if(newHead==null)
		{
			newHead=pivot;
		}
		newEnd=end;
		EmpNode employees[]= {newHead,pivot,newEnd};
		return employees;
	}
	
	
	/**
	 * this method sort the linked list using quick sort algorithm
	 * @param head the head of the linked list
	 * @param end the end of linked list
	 * @return it return the head of linked list after sorting
	 */
	public EmpNode quickSort(EmpNode head,EmpNode end)
	{
		if(head==null || head==end)
		{
			return head;
		}
		EmpNode employees[]=this.doPartition(head, end);
		EmpNode newHead=employees[0];
		EmpNode pivot=employees[1];
		EmpNode newEnd=employees[2];
		if(newHead!=pivot)
		{
			EmpNode employee=newHead;
			while(employee.nextEmployee!=pivot)
			{
				employee=employee.nextEmployee;
			}
			employee.nextEmployee=null;
			newHead=this.quickSort(newHead, employee);
			employee=this.getLast(newHead);
			employee.nextEmployee=pivot;
		}
		pivot.nextEmployee=this.quickSort(pivot.nextEmployee, newEnd);
		return newHead;
	}
}
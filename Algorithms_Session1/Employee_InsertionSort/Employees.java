package Employee_InsertionSort;

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
	EmpNode sorted; // for sorting

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
		System.out.println("Employee added successfully.");
		
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
			System.out.println("Employee Name :"+temp.name);
			System.out.println("Employee Age :"+temp.age);
			System.out.println("Employee Salary :"+temp.salary);
			temp = temp.nextEmployee;
		}
	}

	/**sorting of linked list through insertion sort
	 * this method is used to call the sorting function which hold reference
	 * of head node and next of head node
	 * 
	 * @param headref
	 */
	public void insertionSort(EmpNode headref) {
		if(headref == null){
			System.out.println("No employee data available.");
			return;
		}
		sorted = null;
		EmpNode current = headref;
		while (current != null) {
			EmpNode next = current.nextEmployee;
			sortedInsert(current);
			current = next;
		}
		this.headEmloyee = sorted;
		System.out.println("Employee sorted successfully.");
	}

	/**
	 * function to insert a new_node in a list. Note that this function expects
	 * a pointer to head_ref as this can modify the head of the input linked
	 * list (similar to push())
	 */
	/*
	 *  1)Create an empty sorted (or result) list
		2) Traverse the given list, do following for every node.
			......a) Insert current node in sorted way in sorted or result list.
		3) Change head of given linked list to head of sorted (or result) list.
	 */
	private void sortedInsert(EmpNode newnode) {
		if (sorted == null || sorted.salary < newnode.salary) {
			newnode.nextEmployee = sorted;
			sorted = newnode;
		} else if (sorted.salary == newnode.salary && sorted.age > newnode.age) {
			newnode.nextEmployee = sorted;
			sorted = newnode;
		} else {
			EmpNode current = sorted;
			while (current.nextEmployee != null
					&& current.nextEmployee.salary > newnode.salary) {
				current = current.nextEmployee;
			}
			newnode.nextEmployee = current.nextEmployee;
			current.nextEmployee = newnode;
		}
	}
}
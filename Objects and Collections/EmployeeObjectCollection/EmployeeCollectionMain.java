package EmployeeObjectCollection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeCollectionMain {
	/*
	 * main method
	 */
	public static void main(String[] args) {
		EmployeeCollection emp = new EmployeeCollection();
		
		Scanner scan = new Scanner(System.in);
		boolean exit = false;
		int choice;
		boolean flag = true;
		try {
			System.out.println("Employee Management");
			while (flag) {
				System.out
						.println("\n1. Add Employee\n"
								+ "2. Natural Sort\n"
								+ "3. Sort by Name\n"
								+ "4. Display employees\n"
								+ "5. Exit\n");
				System.out.println("Enter your choice( number) :");
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter employee id:");
					int id = scan.nextInt();
					// check if given input id is already present or not
					if(emp.checkDuplicateEmployeeEntry(id))
						System.out.println("Duplicate Entry for this ID.");
					else{
						scan.nextLine();
						System.out.println("Enter employee name:");
						String name = scan.nextLine();
						System.out.println("Enter employee address:");
						String address = scan.nextLine();
						//function call to add employee 
						emp.addEmployee(id,name,address);
						System.out.println("Employee added successfully!!");
					}
					break;
				case 2:
					emp.sortByNaturalOrder();
					break;
				case 3:
					emp.sortByEmpName();
					break;
				case 4:
					emp.displayEmployees();
					break;
				case 5:
					flag = false;
					System.out.println("Byee !!");
					break;
				default:
					System.out.println("Wrong choice !");
				}
	
			}
		}
		catch(InputMismatchException e){
			System.out.println("Input mistmatched!");
		}
		scan.close();

	}
}

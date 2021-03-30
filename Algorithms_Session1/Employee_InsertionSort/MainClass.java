package Employee_InsertionSort;

import java.util.Scanner;

/*
 * program to sort linked list of employees through insertion sort
 */

public class MainClass {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Employees empList = new Employees();
		boolean flag = true;
		while (flag) {
			System.out.println("\n\nMenu");
			System.out.println("1.Add employee to list");
			System.out.println("2.Display employee");
			System.out.println("3.Sort Employee");
			System.out.println("4.Exit");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter name of employee:");
				scan.nextLine();
				String name = scan.nextLine();
				System.out.println("Enter age of employee:");
				int age = scan.nextInt();
				System.out.println("Enter salary of employee:");
				Double salary = scan.nextDouble();
				empList.addEmployee(name, age, salary);
				break;
				
			case 2:
				empList.displayEmployee();
				break;
				
			case 3:
				// passing the head reference of list
				empList.insertionSort(empList.headEmloyee);
				break;
			case 4:
				System.out.println("Okay, bye!!");
				flag = false;
				break;
			default:
				System.out.println("Wrong Input.");
			}
		}

	}

}
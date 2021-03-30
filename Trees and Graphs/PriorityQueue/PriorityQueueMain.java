package PriorityQueue;

import java.util.Scanner;

/*
 * main class containing main method
 * 
 */
public class PriorityQueueMain {

	
	public static void main(String args[]) {
		// initialize the queue object
		PriorityQueueInterface queue = new PriorityQueueInterface(4);
		
		Scanner scan = new Scanner(System.in);
		int choice =0;
		boolean flag = true;
		
		while (flag) {
			System.out.println("\nPriority Queue Menu");
			System.out.println("\nEnter your choice: \n"
					+ "1.Add element\n"
					+ "2.Delete element  \n"
					+ "3.Is queue full  \n"
					+ "4.Is queue empty  \n"
					+ "5.Display queue \n"
					+ "6.Exit\n");
			choice = scan.nextInt();

			switch (choice) {
			
				case 1:
					if(queue.isQueueFull()){
						System.out.println("Queue is Full!");
					}
					else{
						
						System.out.println("Enter element: ");
						int element=scan.nextInt();
						System.out.println("Enter priority: ");
						int priority=scan.nextInt();
						queue.enqueue(element,priority);
						queue.displayQueueElements();
					}
					break;
					
				case 2:
					int temp =queue.dequeue();
					if( temp !=0)
						System.out.println("Element deleted is : " + temp);
					queue.displayQueueElements();
					break;
					
				case 3:
					System.out.println("Is Queue Full: "+queue.isQueueFull());
					break;
					
				case 4:
					System.out.println("Is Queue empty: "+queue.isQueueEmpty());
					break;
					
				case 5 :
					queue.displayQueueElements();
					break;
					
				case 6:
					System.out.println("Bye !!");
					flag = false;
					break;
					
				default:
					System.out.println("Wrong Input !");
					
			}
		}
	}
	
	
	
	
}
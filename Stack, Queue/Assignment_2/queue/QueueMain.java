package queue;

import java.util.Scanner;

/*
 * main class containing main method
 * 
 */
public class QueueMain {

	
	public static void main(String args[]) {
		// initialize the queue object
		QueueUsingArray queue = new QueueUsingArray(100);
		
		Scanner scan = new Scanner(System.in);
		int choice =0;
		boolean flag = true;
		
		while (flag) {
			System.out.println("\nenter your choice: 1.add element\n"
					+ "2.delete element  \n"
					+ "3.is queue full  \n"
					+ "4.is queue empty  \n"
					+ "5.Display queue \n"
					+ "6.exit");
			choice = scan.nextInt();

			switch (choice) {
			
				case 1:
					System.out.println("Enter element: ");
					int element=scan.nextInt();
					queue.enqueue(element);
					queue.displayQueueElements();
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
					System.exit(0);
					
				default:
					System.out.println("Program terminated !");
					flag = false;
					System.exit(0);
				}
		}
	}
	
	
	
	
}
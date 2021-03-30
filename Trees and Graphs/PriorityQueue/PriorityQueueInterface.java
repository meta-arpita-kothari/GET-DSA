package PriorityQueue;

import java.util.Arrays;

/*
 * class containing methods of priority queue
 */
public class PriorityQueueInterface {
	private int queueMaxSize;
	private int frontIndex = -1;
	private int rearIndex = -1;
	private int queueArray[];
	private int priorityArray[];
	

	public PriorityQueueInterface (int queueMaxSize) {
		this.queueMaxSize=queueMaxSize;
		queueArray = new int[queueMaxSize];
		priorityArray = new int[queueMaxSize];
	}
	
	/*
	 * method to add elements to queue
	 * 
	 */
	public void enqueue(int element, int priority) {
		int i;
		if((frontIndex==0)&&(rearIndex==queueMaxSize-1)) //Check if Queue is full
			System.out.println("Queue is full");
		else
		{
			int count =0;
			if(frontIndex==-1)//if Queue is empty
			{
				frontIndex = rearIndex = 0;
				queueArray[rearIndex] = element;
				priorityArray[rearIndex] = priority;

			}
			else if(rearIndex == queueMaxSize-1)//if there there is some elements in Queue
			{	
				for(i=frontIndex;i<=rearIndex;i++) {
					
					if(priority  <  priorityArray[i]){
						queueArray[i-1] = queueArray[i]; 
						priorityArray[i-1] = priorityArray[i]; 
						count++;
					}
					else
						break;
					
				}
				
				queueArray[i-1] = element;
				priorityArray[i-1] = priority;
				if(count == 0)
					frontIndex--;
				else
					frontIndex-=count;
			}
			else
			{
				for(i = rearIndex;i>=frontIndex;i--)
				{
					if(priority>priorityArray[i])
					{
						queueArray[i+1] = queueArray[i];
						priorityArray[i+1] = priorityArray[i];	
					}
					else
						break;
				}
				queueArray[i+1] = element;
				priorityArray[i+1] = priority;
				rearIndex++;
			}	
		}
	}
	
		
	/*
	 * method removes the element from front of the queue
	 * returns element if successfully removed otherwise return 0
	 */
	public int dequeue() {
		int temp =0;
		if (frontIndex == -1) {
			System.out.print("Queue is Empty");
			return 0;
		}
		if (frontIndex == rearIndex) {
			temp = queueArray[frontIndex];
			frontIndex = -1;
			rearIndex = -1;
		}else {
			temp = queueArray[frontIndex];
			frontIndex++;
		}
		return temp;
	}

	/*
	 * method tells whether the list is full or not
	 */
	public boolean isQueueFull() {
		return (frontIndex == 0 && rearIndex == queueMaxSize - 1);
	}

	/*
	 * method tells whether the list is empty or not
	 */
	public boolean isQueueEmpty() {
		return ((frontIndex == -1 ) || (rearIndex == -1));
	}

	public void displayQueueElements() {
		if(isQueueEmpty()){
			System.out.println("Queue is empty!!");
			return ;
		}
		System.out.println("\nYour queue: ");
		
		for(int i= frontIndex; i <= rearIndex ; i++){
			System.out.println("Element: "+queueArray[i] + " , Priority: " + priorityArray[i]);
			
		}
		System.out.println("\n");

		
	}


}

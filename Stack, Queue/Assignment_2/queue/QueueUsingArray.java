package queue;

/*
 * class containing methods of the queue using array
 * 
 */
public class QueueUsingArray {

	private int queueMaxSize;
	private int frontIndex = -1;
	private int rearIndex = -1;
	private int queueArray[];
	
	public QueueUsingArray (int queueMaxSize) {
		this.queueMaxSize=queueMaxSize;
		queueArray = new int[queueMaxSize];
	}
	
	/*
	 * method to add elements to queue
	 * 
	 */
	public void enqueue(int element) {
		if((frontIndex == 0 && rearIndex == queueMaxSize - 1) || (rearIndex == (frontIndex - 1))) {
			System.out.println("Queue overflowed !");
			return ;
		}
		// Empty queue
		else if (frontIndex == -1) {
			frontIndex = 0;
			rearIndex = 0;
			queueArray[rearIndex] = element;
		} else if (rearIndex == queueMaxSize - 1 && frontIndex != 0) {
			rearIndex = 0;
			queueArray[rearIndex] = element;
		} else {
			rearIndex = (rearIndex + 1);
			queueArray[rearIndex] = element;
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
		} else if (frontIndex == queueMaxSize - 1) {
			temp = queueArray[frontIndex];
			frontIndex = 0;
		} else {
			temp = queueArray[frontIndex];
			frontIndex = frontIndex + 1;
		}
		return temp;
	}

	/*
	 * method tells whether the list is full or not
	 */
	public boolean isQueueFull() {
		return ((frontIndex == 0 && rearIndex == queueMaxSize - 1) || (rearIndex == (frontIndex - 1)));
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
		System.out.println("Your queue: ");

		// if rear < size
		if (rearIndex >= frontIndex) {
			for (int i = frontIndex; i <= rearIndex; i++) {
				System.out.print(queueArray[i]);
				System.out.print(" ");
			}
		}

		// if rear < front
		else {
			// front to size
			for (int i = frontIndex; i < queueMaxSize; i++) {
				System.out.print(queueArray[i]);
				System.out.print(" ");
			}

			// 0 to rear
			for (int i = 0; i <= rearIndex; i++) {
				System.out.print(queueArray[i]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}

}
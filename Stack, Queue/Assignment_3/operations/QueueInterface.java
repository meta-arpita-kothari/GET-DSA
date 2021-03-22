package operations;

/*
 * class containing queue interface
 * enqueue and dequeue
 * 
 */
public class QueueInterface {

	public int queueMaxSize;
	public int frontIndex, rearIndex;
	public Object[] queue;

	public QueueInterface(int queueMaxSize) {
		this.frontIndex = -1;
		this.rearIndex = -1;
		this.queueMaxSize = queueMaxSize;
		queue = new Object[queueMaxSize];
	}

	public void enqueue(Object obj) {
		// If queue is full
		if ((frontIndex == 0 && rearIndex == queueMaxSize - 1) || (rearIndex == (frontIndex - 1))) {
			System.out.print("Queue is Full !");
		}

		// Empty queue
		else if (frontIndex == -1) {
			frontIndex = 0;
			rearIndex = 0;
			queue[rearIndex] = obj;
		} else if (rearIndex == queueMaxSize - 1 && frontIndex != 0) {
			rearIndex = 0;
			queue[rearIndex] = obj;
		} else {
			rearIndex = (rearIndex + 1);
			queue[rearIndex] = obj;
		}
	}

	public Object dequeue() {
		Object obj = null;
		if (frontIndex == -1) {
			System.out.print("Queue is Empty");
		}
		if (frontIndex == rearIndex) {
			obj = queue[frontIndex];
			frontIndex = -1;
			rearIndex = -1;
		} else if (frontIndex == queueMaxSize - 1) {
			obj = queue[frontIndex];
			frontIndex = 0;
		} else {
			obj = queue[frontIndex];
			frontIndex = frontIndex + 1;
		}
		return obj;
	}


}
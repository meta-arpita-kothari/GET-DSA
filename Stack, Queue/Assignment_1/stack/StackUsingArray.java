package stack;

/*
 * class containing concrete implementation of stack using array
 * it stores integer elements
 */

class StackUsingArray {
	private  int stackMaxSize = 0;
	private Object stackArray[];
	int top;

	StackUsingArray(int size) {
		this.stackMaxSize = 100;
		this.stackArray = new Object[stackMaxSize];
		this.top = -1;
	}

	public void push(Object element) {
		if (top == stackMaxSize - 1) {
			System.out.println("Stack is full");

		} else {
			top++;
			stackArray[top] = element;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Object pop() {
		if (!isEmpty()) {
			int index = top;
			top--;
			return stackArray[index];
		} else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	public Object peek() {
		if (!isEmpty())
			return stackArray[top];
		else {
			System.out.println("Stack is Empty");
			return -1;
		}
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		int size = 0;
		for (int i = 0; i <= top; i++) {
			size++;
		}
		return size;
	}

}
package overview;

import java.util.HashMap;


class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

/*
 * Class to implement Singly LinkedList
 * here are the functions :
 * 1. Add - add at last, beginning , at given index
 * 2. Remove - remove from last, begin
 * 3. Size - length of list
 * 4. Display list
 * 5. Get element at given index
 * 6. Update element at given index
 * 7. Rotate sublist
 * 8. Detect loop
 */
public class SinglyLinkedList {
		Node headNode, tailNode; // headNode and tailNode of list
	
		
		/* Method to insert a new node at end */
		public void add(int data) {
			// Create a new node with given data
			Node newNode = new Node(data);

			// If the Linked List is empty
			if (headNode == null) {
				headNode = newNode;
				tailNode = newNode;
			} else {
				tailNode.next = newNode;
				tailNode = newNode;
			}
		}
		/* Method to insert a new node at begin */
		public void addFirst( int data) {
			// Create a new node with given data
			Node newNode = new Node(data);

			// If the Linked List is empty
			if (headNode == null) {
				headNode = newNode;
				tailNode = newNode;
			} 
			else{
				newNode.next = headNode;
				headNode = newNode;
			}
		}
		
		/* Method to insert a new node at end*/
		public void addAtIndex( int data, int index) {
			// Create a new node with given data
			Node newNode = new Node(data);
			
			if (index < 1){
	            System.out.print("Invalid position");
	            return;
			}
			// If the Linked List is empty
			if (headNode == null && index == 1) {
				headNode = newNode;
				tailNode = newNode;
			} else {
				if(index == 1){
					newNode.next = headNode;
					headNode = newNode;
				}
				else{
					int i = 1; //for traversing till the index
					Node tempNode = headNode;
					while(i<index){
						if(tempNode.next == null){
							System.out.print("Invalid position");
				            return;
						}
						tempNode = tempNode.next;
						
					}
					if(tempNode == tailNode){
						newNode.next = tailNode;
						tailNode = newNode;
					}
					else{
						newNode.next = tempNode;
					}
				}
				
			}
		}
		
		/* Method to remove start node */
		public int removeFirst() {
			// Create a new node with given data
			Node tempNode;
			int temp = 0;

			// If the Linked List is empty
			if (headNode == null) {

			} else {
				tempNode = headNode;
				headNode = headNode.next;
				temp = tempNode.data;
			}

			return temp;
		}

		/* Method to remove end node */
		public int removeEnd() {
			// Create a new node with given data
			Node tempNode;
			int temp = 0;

			// If the Linked List is empty
			if (headNode == null) {

			} else {
				tempNode = headNode;
				while (tempNode.next != tailNode) {
					tempNode = tempNode.next;
				}
				temp = tailNode.data;
				tailNode = tempNode;
				tailNode.next = null;
			}

			return temp;
		}

		/* size of list */
		public int size() {
			Node tempNode = headNode;
			int len =0;
			// Traverse through the LinkedList
			while (tempNode != null) {
				len++;
				tempNode = tempNode.next;
			}
			return len;
		}

		/* Method to print the LinkedList */
		public void displayList() {
			Node tempNode = headNode;

			System.out.print("\nLinkedList:\n");

			// Traverse through the LinkedList
			while (tempNode != tailNode.next) {
				// Print the data at current node
				System.out.print(tempNode.data + " ");

				// Go to next node
				tempNode = tempNode.next;
			}
			System.out.println("\n");
		}
		
		/* get element at given position */
		public int getData( int pos) {
			Node tempNode = headNode;
			int data = 0;
			int j = 0;
			
			if(pos <1 || headNode == null)
				return -1;
			
			
			while (j++ < pos) {
				if(tempNode.next == null)
					return -1;
				
				tempNode = tempNode.next;
			}
			data = tempNode.data;
			return data;
		}
		
		
		/* update element at given position */
		public void putData( int pos , int data) {
			Node tempNode = headNode;
			int j = 0;
			
			if(pos <1 || headNode == null){
				System.out.print("Invalid position");
            	return;
			}
			while (j++ < pos) {
				if(tempNode.next == null){
					System.out.print("Invalid position");
            		return;
				}

				tempNode = tempNode.next;
			}
			tempNode.data = data;
		
		}

		
		void rotateSubList(int left, int right, int noOfSteps) throws Exception {
			// check the limits of sublist are correct or not
			
			int len = size();
			if (left < 1 || left > len  || right < 1 || right > len) {
				throw new Exception(
						"Left and Right positions are not input range of main list !");
			}
			
			Node leftAddr = headNode;
			Node rightAddr =  headNode;
			Node rotationAddr = headNode;
			int rotationIndex = right - (noOfSteps%(right-left));
			while(--left>1){
				leftAddr = leftAddr.next;
			}
			while(--right>0){
				rightAddr = rightAddr.next;
			}		
			while(--rotationIndex>0){
				rotationAddr = rotationAddr.next;
			}
			
			Node tempAddr = rotationAddr.next;
			rotationAddr.next = rightAddr.next;
			rightAddr.next = leftAddr.next;
			leftAddr.next = tempAddr;
		}

		/*
		 * Method to detect loop
		 */
		boolean detectLoop(){
			HashMap<Node,Integer> map =  new HashMap<>();
			Node tempNode  = headNode;
			while(tempNode.next != null){
				if(map.containsKey(tempNode)){
					return true;
				}
				map.put(tempNode, 1);
				tempNode = tempNode.next;
			}
			return false;
		}


}

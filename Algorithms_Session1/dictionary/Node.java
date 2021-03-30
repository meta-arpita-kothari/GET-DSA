package dictionary;

/**
 * class containing attributes of a node in BST
 * 
 */
public class Node implements Comparable<Node> {
	
	private Pair valuePair;
	private Node leftChild;
	private Node rightChild;
	
	public Node (Pair valuePair, Node leftChild, Node rightChild) {
		this.valuePair = valuePair;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public Pair getValuePair() {
		return valuePair;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}
	
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public void setValuePair(Pair valuePair) {
		this.valuePair = valuePair;
	}

	//compare key of dictionary
	@Override
	public int compareTo(Node node) {
		return ((this.valuePair.getKey()).compareTo((node.getValuePair().getKey())));
	}
	
	
}
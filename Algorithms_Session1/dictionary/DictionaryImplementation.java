package dictionary;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * class containing implementation of methods of Dictionary interface
 * 
 */
public class DictionaryImplementation implements Dictionary {

	private Node root = null;
	private String jsonFilePath = "";
	List<Pair> listOfValuesInBST = new ArrayList<Pair>();
	
	public DictionaryImplementation (String jsonFilePath) {
		this.jsonFilePath = jsonFilePath;
		insertJsonDataIntoDictionary();
	}
	
	/**
	 * method initializing dictionary with json data
	 */
	private void insertJsonDataIntoDictionary() {
		JSONParser jsonParser = new JSONParser();
		List<String> listOfKeys = new ArrayList<String>();
		List<String> listOfValues = new ArrayList<String>();

		try {
			Object obj = jsonParser.parse(new FileReader(jsonFilePath));
			JSONObject jsonObject = (JSONObject) obj;
			listOfKeys = (List)jsonObject.get("keys");
			listOfValues = (List)jsonObject.get("values");
			for(int index=0 ; index<listOfKeys.size() ; index++){
				addKeyValuePairToDictionary(listOfKeys.get(index),listOfValues.get(index));
			}
			getInorderSortedList(root);
			System.out.println("List of keys added: ");
			printTreeWithKeys(root);
		} catch (Exception e) {
			System.out.println("Some Exception occurred !");
		}
	}
	
	/**
	 * method adds value to BST with help of createNode and addToTree methods
	 * @param String value as key
	 * @param String value as value
	 * @return node added
	 */
	@Override
	public Node addKeyValuePairToDictionary(String key, String value) {
		try {
			Node node = createNode(key,value);
			if(root==null) {
				root=node;
				return root;
			}
			return (addToTree(node,root));
		} catch (Exception e) {
			System.out.println("Exception Occurred !");
		}
		listOfValuesInBST.removeAll(listOfValuesInBST);
		return null;
	}

	@Override
	public Node deleteKeyValuePairFromDictionary(String key, Node node) {
		try {
			if(node==null) {
				return node;
			} 
			
			//traversing the BST
			if ((key.compareTo(node.getValuePair().getKey()) > 0 )) {
				node.setRightChild(deleteKeyValuePairFromDictionary(key, node.getRightChild())); 
			} else if((key.compareTo(node.getValuePair().getKey()) < 0 )) {
				node.setLeftChild(deleteKeyValuePairFromDictionary(key, node.getLeftChild()));
			}
			// if key is same as root's
	        // key, then This is the
	        // node to be deleted
			else {
				
				//deleting node having single child or no child
				if(node.getLeftChild()==null) {
					return node.getRightChild();
				} else if(node.getRightChild()==null) {
					return node.getLeftChild();
				} 
				
				// node with two children: Get the inorder
	            // successor (smallest in the right subtree)
				node.setValuePair(getMinValue(node.getRightChild())); //getting minimum value from right side as it will be suitable for maintaining tree
				node.setRightChild(deleteKeyValuePairFromDictionary(key, node.getRightChild()));
			}
		} catch (Exception e) {
			System.out.println("Exception occurred !");
		}
		listOfValuesInBST.removeAll(listOfValuesInBST);
		
		return node;
	}

	/**
	 * method to get corresponding value of the key from tree
	 * @return value as string
	 */
	@Override
	public String getValueOfGivenKey(String key,Node node) {
		try {
			if(node.getValuePair().getKey().equals(key)) {
				return node.getValuePair().getValue();
			} else {
				if(key.compareTo(node.getValuePair().getKey()) >0 ) {
					return getValueOfGivenKey(key,node.getRightChild());
				} else {
					return getValueOfGivenKey(key,node.getLeftChild());
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occurred !");
			return null;
		}
	}

	/**
	 * method sorts the key value pair of the BST
	 * @return sorted list of key values
	 */
	@Override
	public List<Pair> getSortedListOfKeys() {	
		getInorderSortedList(root);
		return listOfValuesInBST;
	}
	

	@Override
	public List<Pair> getSortedListOfKeysInRange(String k1, String k2) {
		List<Pair> sortedList = new ArrayList<Pair>();
		int start = findKey(k1);
		int end = findKey(k2);
		if(start == -1 || end == -1)
			return sortedList; // empty list return
		for(int i = start ; i<=end;i++){
			sortedList.add(listOfValuesInBST.get(i));
		}
		return sortedList;
	}
	
	/**
	 * helper function to find a key in tree
	 * @param key
	 * @return index of key if found , else -1
	 */
	public int findKey(String key){
		for(Pair p : listOfValuesInBST){
			if(p.getKey().equals(key)){
				return listOfValuesInBST.indexOf(p);
			}
		}
		return -1;
	}
	
	/**helper function
	 * method create new Node with pair values
	 * @param String key value pair
	 * @return node created
	 */
	private Node createNode(String key, String value) {
		Node node = null;
		Pair valuePair = null;
		try {
			if(key == null || value == null) {
				System.out.println("Either the key or value is null !");
				return null;
			} else {
				valuePair = new Pair(key,value);
				node = new Node (valuePair, null, null);
			}
		} catch (Exception e) {
			System.out.println("Exception Occurred !");
		}
		return node;
	}
	
	/**
	 * method adds newly created node its appropriate position in BST
	 * @param node value to be added
	 * @param node at which we have to add
	 * @return node added
	 */
	private Node addToTree(Node nodeToBeAdded, Node node) {
		try {
			if(node == null) {
				node = nodeToBeAdded;
			} else {
				if(nodeToBeAdded.compareTo(node) >= 0) {
					//if value is greater than current node
					node.setRightChild(addToTree(nodeToBeAdded,node.getRightChild())); 
				} else {
					//if value is less than current node
					node.setLeftChild(addToTree(nodeToBeAdded,node.getLeftChild())); 
				}
			}
		} catch (Exception e) {
			System.out.println("Exception Occurred !");
		}
		
		return node;
	}
	
	/**
	 * helper function for deletion of a node
	 * it find the inorder successor for a node having two children
	 * @param root
	 * @return
	 */
	private Pair getMinValue(Node root) {
		Pair minValue= null;
		while(root.getLeftChild()!=null) {
			minValue=root.getLeftChild().getValuePair();
			root = root.getLeftChild();
		}
		return minValue;
	}
	
	/**
	 * method create list of inorder traversal nodes
	 */
	private void getInorderSortedList(Node root) {
		if(root==null) {
			return;
		} else {
			getInorderSortedList(root.getLeftChild());
			listOfValuesInBST.add(root.getValuePair());
			getInorderSortedList(root.getRightChild());
		}
	}
	
	/**
	 * print inorderTraversal of tree
	 */
	public void printTreeWithKeys(Node root) {
		if(root==null) {
			return;
		} else {
			printTreeWithKeys(root.getLeftChild());
			System.out.print(root.getValuePair().getKey()+" , ");
			printTreeWithKeys(root.getRightChild());
		}
	}

	public void printListOfValuesInBST(Pair pair) {
		if(pair!=null) {
			System.out.println(pair.getKey()+"---> "+pair.getValue());
			System.out.println();
		} else {
			return;
		}
	}
	
	/**
	 * @ root of the BST
	 */
	public Node getRoot() {
		return root;
	}
	
	
}
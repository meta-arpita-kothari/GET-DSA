package dictionary;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 * class containing main method
 * 
 */
public class DictionaryMain {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		DictionaryImplementation dictionary = new DictionaryImplementation("D:\\programs\\DSA\\src\\dictionary\\inputDataFile.json");
		try {
			boolean flag = true;
			int choice = 0;
			while (flag) {
				System.out.println("\nEnter your choice :\n"
						+ "1. Add Key Value Pair to Dictionary\n"
						+ "2. Delete a key value pair\n"
						+ "3. Get Value Of Specified Key\n"
						+ "4. Get Sorted List Of Key Value Pair\n"
						+ "5. Get Sorted List In Specified Range\n"
						+ "6. Exit");
				choice = scan.nextInt();
				switch (choice) {
					case 1:
						scan.nextLine();
						System.out.print("\nKey : ");
						String keyToBeAdded = scan.nextLine();
						if(dictionary.findKey(keyToBeAdded) == -1){
							System.out.print("\nValue : ");
							String valueToBeAdded = scan.nextLine();
							System.out.println();
							dictionary.addKeyValuePairToDictionary(keyToBeAdded, valueToBeAdded);
							dictionary.getSortedListOfKeys();
							dictionary.printTreeWithKeys(dictionary.getRoot());
						}
						else{
							System.out.println("Duplicate key!!");
						}
						break;
						
					case 2:
						scan.nextLine();
						System.out.println("Enter key to be Deleted: ");
						String keyToBeDeleted = scan.nextLine();
						dictionary.deleteKeyValuePairFromDictionary(keyToBeDeleted,dictionary.getRoot());
						dictionary.getSortedListOfKeys();
						dictionary.printTreeWithKeys(dictionary.getRoot());
						break;
						
					case 3:
						scan.nextLine();
						System.out.println("Enter key : ");
						String key = scan.nextLine();
						String value = dictionary.getValueOfGivenKey(key,dictionary.getRoot());
						if(value==null) {
							System.out.println("No such word present ! You can add this by pressing 1.");
						} else {
							System.out.println("Value---> "+value);
						}
						break;
						
					case 4:
						List<Pair> listOfKeys = dictionary.getSortedListOfKeys();
						for(Pair val : listOfKeys) {
							dictionary.printListOfValuesInBST(val);
						}
						break;
						
					case 5:
						scan.nextLine();
						System.out.println("Enter K1: ");
						String k1 = scan.nextLine();
						System.out.println("Enter K2: ");
						String k2 = scan.nextLine();
						List<Pair> list = dictionary.getSortedListOfKeysInRange(k1, k2);
						if(list == null){
							System.out.println("No data found. Key range might be wrong!");
						}else{
							for(Pair val : list) {
								dictionary.printListOfValuesInBST(val);
							}
						}
						
						break;
					case 6:
						System.out.println("\nExiting system.....");
						flag= false;
						break;
						
					default:
						System.out.println("Invalid choice !");
						break;
				}
				
			} 
		}catch (InputMismatchException e) {
			System.out.println("Invalid input given !");
		} catch (Exception e) {
			System.out.println("Some error occured !");
		}	
	}
	
}
package uniqueCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/*
 * class to count number of unique characters
 * whose occurrence is one time
 */
public class NumberofUniqueCharactersInString {
	/* to store the string whole unique characters are counted
	* map<String , NoOfUniqueCharacters>
	*/
	private static Map<String,Integer> cache = new HashMap<String,Integer>();
	
	/**
	 * method to count unique characters in given string
	 * @param str
	 * @return
	 */
	public static int countNumberofUniqueCharacters(String str){
		// to check is given string is calculated before
		Integer count = cache.get(str);
		//if null, then str needs to be calculated, else get the value from map
		if(count == null){
			count = countUtil(str);
			cache.put(str,count);
			return count ;
		}
		else{
			System.out.println("Cached Data !!");
			return count;
		}
	}
	/**
	 * utility function to count unique characters
	 * @param str
	 * @return
	 */
	private static int countUtil(String str){
		// convert str to character array
		char[] strArray = str.toCharArray();
		
		// declare a set to contain unique characters
		Set<Character> charSet = new HashSet<Character>();
		int count =0;
		
		for(Character ch : strArray){
			if(charSet.contains(ch)){
				count--;
			}
			else{
				charSet.add(ch);
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		int choice =0;
		boolean flag = true;
		
		while(flag){
			System.out.println("\nMenu\n"
					+ "1. Enter String to count unique characters.\n"
					+ "2. Exit\n");
			System.out.println("Enter choice(number) : ");
			choice = scan.nextInt();
			scan.nextLine();
			switch(choice){
			case 1: 
				System.out.println("Enter string: ");
				String str = scan.nextLine();
				System.out.println("Number of unique characters in given string: "
						+ countNumberofUniqueCharacters(str));
				break;
			
			case 2:
				flag = false;
				System.out.println("Bye!");
				break;
				
			default :
				System.out.println("Wrong input!");
			}
		}
		
		
	}
	
}

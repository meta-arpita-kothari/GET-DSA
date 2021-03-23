package OrganicChemistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
/*
 * Class to solve formula of organic chemistry
 */
public class OrganicChemistry {
	// map to store values of each atom of Carbon, Hydrogen, Oxygen
	private final static Map<Character, Integer> compoundValue = new HashMap<Character, Integer>();

	private static void initCompoundValue() {
		compoundValue.put('C', 12);
		compoundValue.put('O', 16);
		compoundValue.put('H', 1);
	}
	
	private static int solveFormula(String compound){
		int molecularMass = 0;
		// convert compound string to character array
		char[] tokens = compound.toUpperCase().toCharArray();
		//stack for storing calculated molecular mass
		Stack<Integer> massValue = new Stack<Integer>();
		// stack for storing compound elements
		Stack<Character> compCharacter = new Stack<Character>(); 
		
		// count of elements surrounded by parenthesis
		// like (OH2) , count = 1
		int parenthesisCount =0;
		
		for(int i =0; i< tokens.length ; i++){
			//if token is character, push into stack "compCharacter"
			if(tokens[i]== 'C' || tokens[i]== 'H' || tokens[i]== 'O' || tokens[i]=='(' ){
				compCharacter.push(tokens[i]);
			}
			
			else if(tokens[i]==')'){
				molecularMass = 0;
				// it calculates the mass for elements in parenthesis 
				// like (OH)
				
				int temp = massValue.size();
				while(temp > parenthesisCount && !massValue.isEmpty()  ){
					molecularMass += massValue.pop();
					temp--;
				}
				while( !compCharacter.isEmpty() && compCharacter.peek()!='('){
					char ch = compCharacter.pop();
					molecularMass += compoundValue.get(ch);
				}
				
				//  push calculated mass to stack "massValue"
				massValue.push(molecularMass);
				compCharacter.pop(); // pop '(' 
				
				// element surrounded by parenthesis()
				parenthesisCount++;
			}
			else if(Character.isDigit(tokens[i])){
				molecularMass = 0;
				// if stack massValue already has value from calculation 
				// like (OH)2
				if(!massValue.isEmpty() && tokens[i-1] == ')'){
					molecularMass = massValue.pop()*Character.getNumericValue(tokens[i]);
					massValue.push(molecularMass);
				}
				// else if massValue is empty then
				// it means element is like C2
				// it will calculate  as C=12 * 2
				else{
					molecularMass = compoundValue.get(compCharacter.pop()) * Character.getNumericValue(tokens[i]);
					massValue.push(molecularMass);
				}
				
			}
		}
		// calculate for remaining elements in compCharacter stack
		molecularMass =0;
		while(!compCharacter.isEmpty()){
			
			molecularMass += compoundValue.get(compCharacter.pop());
		}
		
		// if massValue not empty, add all the values
		while(!massValue.empty()){
			molecularMass += massValue.pop();
		}
		
		massValue.push(molecularMass);
		
		// last element in stack is the result
		return massValue.pop();
	}
	

	public static void main(String[] args) {
		initCompoundValue();
		System.out.println("Molecular mass of C(OH)2  : " + solveFormula("C(OH)2"));
		System.out.println("Molecular mass of C2H4O2  : " + solveFormula("C2H4O2"));
		System.out.println("Molecular mass of CHOC(CH3)3  : " + solveFormula("CHOC(CH3)3"));
		System.out.println("Molecular mass of "+ "CHOC(CH3)3ch(ch2)2".toUpperCase()+" : " + solveFormula("CHOC(CH3)3ch(ch2)2"));
	}
}
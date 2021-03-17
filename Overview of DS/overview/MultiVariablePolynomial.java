package overview;
/*
 * Class for multi-variable node
 */

class MultiVariableNode{
	int coeff;  // coefficient
	char var;	// variable
	int exp;	// exponent (degree)
	MultiVariableNode nextNode ; // next polynomial term
	MultiVariableNode downNode; // points to next node of Variable in the same term
	
	MultiVariableNode(int coeff,char var,int exp){
		this.coeff = coeff;
		this.exp = exp;
		this.var = var;
		downNode = null;
		nextNode = null;
	}
}


//This class handle work related to multivariable polynomial
/*
* This class provide following methods:
* 1. addterm - add the term to the existing polynomail
* 2. display Node - return the single term as string
* 3. displayPoly -  add all the return term by displayNode and return the whole polyNomial
*/

class MultiVariablePolynomial{
	
	private MultiVariableNode tail = null ,head = null;
	char[] availableVar = {'X','Y','Z','A','B','C','P','N'}; // here 'N' indicates no variable
	int len = 0;
	private int degree=0;
	
	
	
	//add term to the polynomial 
	//@param - coefficient ,  exponent array of all the variable
	void addterm(int coeff,int[] expo) {
		if(coeff == 0){
			return;
		}
		MultiVariableNode node = new MultiVariableNode(coeff,availableVar[0],expo[0]);
		int degree = expo[0];
		for(int index=1;index<expo.length;index++){
				MultiVariableNode tempNode = node;
				while(tempNode.downNode!=null){
					tempNode = tempNode.downNode;
			}
				tempNode.downNode = new MultiVariableNode(1,availableVar[index],expo[index]);
				degree+=expo[index];
				
		}
		if(this.degree < degree)
			this.degree = degree;
		
		if(head==null){
			head = node;
			tail = node;
		}
		else{
			tail.nextNode = node;
			tail = node;
		}
		
		len++;
	}
	
	
	//return the degree of the polynomial
	int getDegree(){
		return degree;
	}
	
	
	//return the string representaion of single Node
	String displayNode(MultiVariableNode node){
		MultiVariableNode tempNode = node;
		MultiVariableNode tempDownNode = tempNode.downNode;
			String term ="";
			term +=""+tempNode.coeff+"("+tempNode.var+"^"+tempNode.exp+")";
			while(tempDownNode!=null){
				term += "("+tempDownNode.var+"^"+tempDownNode.exp+")";
				tempDownNode = tempDownNode.downNode;
			}
//			term = term.replaceAll("^1","");
			if(tempNode!=head){
				return " + "+term;
			}
			else{
				return term;
			}
			
		}
	
	
	//return the representation of polynomial
	String displayPoly(){
		MultiVariableNode tempNode = head;
		String resultPoly = "";
		if(head == null){
			return "First Add terms";
		}
		else{
			while(tempNode!=null){
				resultPoly += displayNode(tempNode);
				tempNode = tempNode.nextNode;
			}
		}
		return resultPoly;
	}
	
}

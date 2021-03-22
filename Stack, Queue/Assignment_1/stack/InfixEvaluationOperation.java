package stack;


public class InfixEvaluationOperation {
	
	public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
 
         // Stack for numbers: 'values'
        StackUsingArray  values = new StackUsingArray(100);
 
        // Stack for Operators: 'operators'
        StackUsingArray  operators = new StackUsingArray(100);

        for (int i = 0; i < tokens.length; i++)
        {
        	
            // if token is whitespace, skip it
            if (tokens[i] == ' ')
                continue;
 
            // If token is a number, push it to stack for numbers
            if (Character.isDigit(tokens[i]))
            {
                StringBuffer sbuf = new  StringBuffer();
                // if there may be more than one digit in number
                while (i < tokens.length && Character.isDigit(tokens[i]))
                       sbuf.append(tokens[i++]);
                
                values.push(Integer.parseInt(sbuf.toString()));               
                i--;  // to get the correct offset of tokens
            }
 
            // if token is an opening brace,push it to 'operators'
            else if (tokens[i] == '(')
                operators.push(tokens[i]);
 
            // if Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (operators.size() > 0 && (char)operators.peek() != '('){
                	int val2 = (int) values.pop();
					int val1 = (int) values.pop();
					char op = (char) operators.pop();

					int opval = operation(val1, val2, op);
					values.push(opval);
                }
                if (operators.size() > 0) {
					operators.pop();
				}
                
            }
 
            // if token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||  tokens[i] == '*' || tokens[i] == '/')
            {
                // While top of 'operators' has same or greater precedence to current
                // token, which is an operator.
                // then apply 'op' to top two numbers in values stack
                while (!operators.isEmpty() && (char) operators.peek() != '(' && hasPrecedence(tokens[i], (char) operators.peek())){
                	int val2 = (int) values.pop();
					int val1 = (int) values.pop();
					char op = (char) operators.pop();

					int opval = operation(val1, val2, op);
					values.push(opval);
                }
 
                // Push current token to 'operators'.
                operators.push(tokens[i]);
            }
            
        }
 
        // Entire expression has been parsed at this point, apply remaining
        // operators to remaining values
        while (!operators.isEmpty()){
        	char optor = (char) operators.pop();
			int v2 = (int) values.pop();
			int v1 = (int) values.pop();
	
			int opv = operation(v1, v2, optor);
			values.push(opv);
        }
 
        // Top of 'values' contains result, return it
        
        return (int) values.pop();
    }
 
    /*
     *  Returns true if 'op2' has higher or same precedence as 'op1',
     * otherwise returns false.
     */
    public static boolean hasPrecedence( char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
    // A utility method to apply an operator 'op' on operands 'a' 
    // and 'b'. Return the result.
    public static int operation(int a, int b, char op)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0){
            	System.out.println("Can't divide by zero");
            	break;
            }
            return a / b;
        
        }
        return 0;
    }
 
    // main method
    public static void main(String[] args)
    {
        System.out.println(InfixEvaluationOperation.evaluate("10 + 2 * 6"));
        
        System.out.println(InfixEvaluationOperation.evaluate("100 * 2 + 12"));
        
        System.out.println(InfixEvaluationOperation.evaluate("100 * ( 2 + 12 )"));
        
        System.out.println(InfixEvaluationOperation.evaluate("100 * ( 2 + 12 ) / 14"));
       
    }
}

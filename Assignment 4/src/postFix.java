//Erik Cupsa, ID Number: 261016180

/*
 * exports methods for dealing with parsing and conversion
 * @author erikc
 */
import java.util.StringTokenizer;

public class postFix {
	//creating arrays
	String[] operators = {"+", "-", "*", "/", "(", ")"}; //array of all operators
	Integer[] precedences = {2, 2, 3, 3, 0, 0}; //array of the precedences associated with the operators
	
	/*
	 * Take in a string entered by a user in infix notation and return a Queue 
	 * @param String arg The string to be parsed into the Queue
	 * @return Queue Qin Queue of parsed string
	 */
	public Queue parse(String arg) {
		arg = arg.replaceAll("\\s+", ""); //removing all spaces from the string 
		Queue Qin = new Queue(); //creating the queue to store the string in
		StringTokenizer st = new StringTokenizer(arg, "+-*/^()", true); //Separating the string into tokens
		while(st.hasMoreTokens()) {
			Qin.enqueue(st.nextToken()); //adding each individual token to the queue
		}
		return Qin; //returning the queue
	}
	
	/*
	 * In2Post
	 * 
	 * Takes a queue of the tokens in infix and returns a queue of postfix expressions
	 * @param Queue Qin Queue of tokens in infix notation
	 * @return Queue Qout Queue of tokens in postfix notation
	 */
	public Queue In2Post(Queue Qin) { 
		//initializing variables
		Stack stack = new Stack();
		Queue Qout = new Queue();
		String e;
		
		while((e=Qin.dequeue())!= null) { //while there are still tokens 
			if (isOperator(e)) { //checking if the token is an operator
				if (e.equals("(")) { //if it is an open bracket push to the stack
					stack.push(e);
				}
				
				else if (e.equals(")")) { //if it is a close bracket 
					String top = stack.pop(); //creating string variable 
					while(top.equals("(")== false) { //while there are still tokens within the brackets
						if (top.equals(")")) top = ""; //disgarding close bracket
						Qout.enqueue(top);
						top = stack.pop(); //popping from stack 
					}
					top = ""; //disgardging open bracket
				}
				else { //if an operator that is not a bracket
				String top = stack.pop(); //popping top 
				while(precedence(top)>=precedence(e)) { //while the predence of the pop is greater than the stack 
					Qout.enqueue(top); //enqueue the top to the stack
					top = stack.pop(); //pop token from stack
				}
				//push tokens to stack
				stack.push(top); 
				stack.push(e);
				}
			}
			
			else { //if a number is read
				Qout.enqueue(e); 
			}
		}
		String p; //initializing variable
		while((p=stack.pop())!= null) { //while there are still tokens on the stack
			Qout.enqueue(p); //enqueue stack token onto output
		}
		return Qout; //returning the new Queue in postfix notation
	}
	
	/*
	 * isOperator
	 * 
	 * checks if a token is an operator
	 * @param String s The token to be checked
	 * @return boolean Whether or not the string is a token
	 */
	public boolean isOperator(String s) {
		for(int i=0; i<operators.length; i++) { //sorting through all elements of the operators array
			if(operators[i].equals(s)) return true; //if the token matches an element in the array return true
		}
		return false; //else false
	}
	
	/*
	 * precedence
	 * 
	 * finding the precedence associated to an operator
	 * @param String s Operator to find precedence of 
	 * @return int The associated precedence
	 */
	public int precedence(String s) {
		int index =0; //declaring variables
		if(s!= null) { //if it is an operator 
		for(int i=0; i<operators.length; i++) { //finding index of operator in operators array
			if(operators[i].equals(s)) { 
				index = i; 
			}
		}
		return precedences[index]; //returning the index of operator in precedence array
		}
		return 0; //else return 0
	}
	
	/*
	 * PostEval
	 * Evaluates the postfix expression
	 * @param Queue postFixQueue Queue containing the postfix
	 * @return double Result of the postfix expression
	 */
	//code based off of Katrina's tutorials
	public double PostEval(Queue postFixQueue) {
		Stack postEvalStack = new Stack(); //stack to push and pop operands
		
		
		while(postFixQueue.head != null) { //until queue empty
			//declaring variables
			String e = postFixQueue.dequeue();
			Double result;
			//what to do with element 
			if(isOperator(e)) {
				//pop 2 elements (numbers)
				String elA = postEvalStack.pop(); //number 1
				String elB = postEvalStack.pop(); //number 2
				
				
				//parsing the string tokens into doubles to be evaluated
				Double A = Double.parseDouble(elA);
				Double B = Double.parseDouble(elB);
				
				if(e.equals("+")) { //if addition
					result = B+A;
				}
				else if(e.equals("-")) { //if subtraction
					result = B-A; 
				}
				else if(e.equals("*")) { //if multiplication
					result = B*A;
				}
				else if(e.equals("/")) { //if division
					result = B/A; 
				}
				else result = 0.0; //default 

				postEvalStack.push(Double.toString(result)); //pushing result to stack
			}
			else {
				//push element to stack
				postEvalStack.push(e);
			}
			//at this point there is only 1 element remaining on the stack
		}
		String r = postEvalStack.pop(); //popping final element which is the result
		return Double.parseDouble(r); //returning the result string token as a double
	}
}

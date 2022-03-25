//Erik Cupsa, ID Number: 261016180

/*
 * push and pop string from a stack
 * @author erikc
 */
public class Stack {
	//declaring instance variable
	listNode top; 
	
	//based off of notes provided by Prof. Ferrie from ECSE 202
	
	/*
	 * push 
	 * 
	 * pushing a string onto the stack 
	 * @param String arg String to be pushed
	 */
	public void push(String arg) {
		listNode node = new listNode(); //creating new node
		node.data = arg; //adding string to node
		node.next = top; 
		top = node; //adding node to the stack
	}
	
	/*
	 * pop
	 * 
	 * pops a string from the stack
	 */
	public String pop() { 
		if(top == null) return null; //if the stack is null return null
		String data = top.data; //else pop string value and store in data variable
		top = top.next; 
		return data; //return string 
	}
}

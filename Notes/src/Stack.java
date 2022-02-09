import acm.program.ConsoleProgram;

public class Stack extends ConsoleProgram{
	
	void push(int arg) { 
		listNode node = new listNode(); 
		node.data = arg; 
		node.next = top; 
		top = node; 
	}
	
	Integer pop() { 
		if(top == null) return null; 
		int data = top.data; 
		top = top.next; 
		return data; 
	}
	
	private class listNode {
		int data; 
		listNode next; 
	}
	
	listNode top = null;
	
	public void run() {
		//testing listNode class
//		listNode top = null; 
//		for (int i=1; i<=6; i++) {
//			listNode node = new listNode(); 
//			node.data = i; 
//			node.next = top; 
//			top = node;
//		}
//		while (top != null) {
//			println(top.data);
//			top = top.next;
//		}
		
		//testing Stack class
		
		Stack stack = new Stack();
		
		for (int i=1;i<=6;i++) stack.push(i);	// push 6 integers onto
		
		println("using the stack class");		// stack.
		
		while (true) {
			Integer j = stack.pop();			// pop until empty
			if (j==null) break;
			println(j);
		}		
	}
	
}

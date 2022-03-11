//Erik Cupsa, ID Number: 261016180

/*
 * This class is used by postFix to create Queues, and by In2P to convert a Queue to a String
 * @author erikc
 */
public class Queue {
	
	//declaring instance variables
	listNode head; //front pointer
	listNode tail; //rear pointer
	
	//enqueue and dequeue based off of notes provided by Prof. Ferrie from ECSE 202
	/*
	 * enqueue
	 * 
	 * creates a node and adds it to queue
	 * @param String data The data to be added to the queue
	 */
	public void enqueue(String data) {
		listNode node = new listNode(); //creating a new node at the rear
		node.data = data;  
		
		if (tail!= null) { //if queue not empty attach new node 
			tail.next = node; 
		}
		else head = node;  //else make the front point to the node
		
		tail = node; //rear points to new node regardless	
	}
	
	/*
	 * dequeue
	 * 
	 * unloading a queue and storing values in a string
	 * @return String out String that was stored in the queue
	 */
	public String dequeue() { 
		String out; //declaring variables
		
		if(head != null) { //if queue is not empty
			if(head == tail) tail = null; //if last node set to null
			out = head.data; //if not empty unload data from front
			head = head.next; 
			return out; //returning the String that was stored in the Queue
		}
		else return null; //if queue was empty return null
	}
	
	/*
	 * toString
	 * 
	 * converts a Queue to a String
	 * @return String result A string which is a concatenation of all the tokens in the queue 
	 */
	public String toString() { //sample code provided by Katrina at tutorials
		String result, data; //declaring variables
		result = ""; //initializing result
		while(head != null) { //while head is not empty
			data = this.dequeue(); //calling dequeue
			result = result + " " + data; //concatenating data from queue to string
		}
		this.dequeue();
		return result; //returning the string 
	}
}

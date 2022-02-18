//Erik Cupsa, ID Number: 261016180

import acm.program.*;

/**
 * Displays a user generated list using a bTree class
 * @author erikc
 *
 */
@SuppressWarnings("serial")
public class TreeSort extends ConsoleProgram{
	public void run() {
		//declaring variables
		bTree myTree = new bTree(this);
		String input; 
		
		//identifying program and printing instructions
		println("Text Sorting Program: (ECSE 202 - Assignment 2");
		println("Enter names to be sorted, line by line. A blank line terminates.");
		println("You can cut and paste text into this window:");
		
		// Loop for desired amount of user inputs
		while(true) {
			input = readLine(""); //interpreting the user input
			if(input.equals("")) break; //checking for desired exit of loop by user
			myTree.addNode(input); //adding the input (name) to the bTree as a node
		}
		
		//displaying the list in alphabetical order
		println("Text in sort order: \n");
		myTree.displayInOrder(); //calling the displayInOrder class from bTree.java
		
		//displaying the list in reverse alphabetical order
		println("\nText in reverse sort order: \n");
		myTree.displayInReverseOrder(); //calling the displayInReverseOrder class from bTree.java
		
		//Terminating the program
		println("\nProgram terminated");
	}
}

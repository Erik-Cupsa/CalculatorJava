//Erik Cupsa, ID Number: 261016180

import acm.program.*;

/**
 * Converts infix to postfix
 * @author erikc
 *
 */

@SuppressWarnings("serial")
public class In2P extends ConsoleProgram{
	public void run() {
		//declaring variables
		String infix, postfix; 
		postFix myPostFix = new postFix();
		Queue Qin = new Queue();
		Queue Qout = new Queue();
		
		//identifying program and printing instructions
		
		println("Infix to Postfix conversion, enter expression of blank line to exit.");

		//loop for desired amount of desired user inputs
		while(true) {
			infix = readLine("expr:"); //getting input
			if(infix.equals("")) break; //checking for desired exit of loop by user
			
			Qin = myPostFix.parse(infix); //parsing input to Queue
			Qout = myPostFix.In2Post(Qin); //Converting Queue from infix to postfix
			postfix = Qout.toString(); //Changing the output Queue to a string
			println(infix + "==>" + postfix); //printing the result
		}
		
		//program terminated
	}
}

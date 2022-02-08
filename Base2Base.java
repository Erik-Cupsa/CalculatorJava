//Erik Cupsa
//ID Number: 261016180

import acm.program.*; 

public class Base2Base extends ConsoleProgram{
	//The code contains the template provided by Prof. Ferrie from ECSE 202, Winter 2022 Assignment 1
	//Some template also provided by Katrina in tutorials
	public void run() {
		//declaring variables
		int inBase, outBase, decValue; 
		String input, output; 
		// Identifying program and printing instructions.
		println("Base conversion program for positive integers.");
		println("The program prompts for the following 3 inputs:");
		println("1. String corresponding to the input number");
		println("2. An integer corresponding to the base of the input [2,16].");
		println("3. An integer corresponding to the base of the output [2,16].");
		println("A blank or negative input or base value outside of [2,16] terminates the program.\n");
		
		// Read-interpret-convert-print loop.
		
		while (true) {
			input = readLine("input: ");
			if (input.equals("") || input.charAt(0)=='-') break; //checking for desired termination of program
			inBase = readInt("input base: ");
			if (inBase < 2 || inBase > 16) break; // Checking if input is within the bounds
			outBase = readInt("output base: ");
			if (outBase < 2 || outBase > 16) break; // Same but for outBase
			
			// Calling String2Int method to determine the decimal value of input string.
			decValue = String2Int(input, inBase);
			// If invalid input, skip to next round. Method returns -1 if input is invalid.
			if(decValue < 0) {
				println("Input inconsistent with base. Try again or exit program with blank or negative input.");
			}else {
				//Converting decimal value to desired output base representation
				output = Int2String(decValue, outBase);
				//printing the results
				println(input + " has decimal value " + decValue +".");
				println(input+ " expressed in Base " + outBase + " = " + output + ".\n");
			}
		}
		println("Program terminated");
	}
	//method converting string to an integer value in base 10
	private int String2Int (String input, int inBase) {
		//declaring variables
		int sum, power, cVal; 
		char c; 
		//giving a starting value to both sum and power
		sum = 0; 
		power = 1; 
		
		for(int i=input.length() - 1; i >= 0; i--) { //reading number from right to left
			
			c = input.charAt(i); //finding character of string at position i
			cVal = Char2Int(c, inBase); //calling Char2Int method to convert to an integer
			
			if(0<= cVal) { //valid input
				sum += cVal*power; //changing value of sum
				power *= inBase; //changing value of power
			} 
			else { //if cVal = -1, it is an invalid input as checked in Char2Int
				return -1; //returning -1, the invalid input
			}
		}
		return sum; //returning the total sum, i.e. the integer value in base 10, if no invalid input
	} 
	
	private int Char2Int (char current, int inBase) { //code based off of content provided by Katrina in the tutorials
		int x, a; //declaring variables
		a = current; //setting a to the ascii value of the character
		
		if (a>= 48 && a <= 57) { //if c is a digit (comparing to other ascii values)
			x = a - 48; //converting from ascii value to an integer by subtracting the value of '0'
		} 
		else if(97<= a && a <= 102) { // char code in [a,f]
			x = a - 97 + 10; //converting from ascii value to an integer by subtracting the value of 'a' and adding 10
		}
		else if(65<= a && a <= 70) { // char code in [A, F]
			x = a - 65 + 10; //converting from ascii value to an integer by subtracting the value of 'A' and adding 10
		}
		else { //if other illegal input
			x = -1; 
		}
		
		if (x >= inBase) { //if not in [0, inBase-1] not a valid input
			x = -1; 
		}
		return x; 
	}
	
	private String Int2String (int decValue, int outBase) { //converting int back to string
		//declaring variables
		String output; 
		int current; 
		char symbol; 
		output = ""; // initializing result string to be empty
		
		while (decValue > 0) { //loop until integer has been completely converted into string
			current = decValue % outBase; 
			decValue = decValue / outBase; 
			if (current < 10) {
				symbol = (char)(current+48); //converting to character [0,9]
			} else {
				symbol = (char)(current-10+97); //converting to character [a,f]
			}
			output = symbol + output; //concatenation of the new symbol and the old output string
		}
		return output; 
	}
}

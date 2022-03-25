import acm.program.ConsoleProgram;

@SuppressWarnings("serial")
public class JCalc extends ConsoleProgram{
	//Code provided by Prof. Ferrie in assignment 4 handout
	
	// Create program objects
	postFix pf = new postFix(); // Postfix converter and interpreter
	// Entry point
	public void run() {
		println("Infix to Postfix conversion, enter expression of blank line to exit.");
		while (true) {
			String input = readLine("expr: "); // Get expression
			
			if (input.equals("")) break; // Terminate on blank line
			
			Queue Qin = pf.parse (input); // Parse input string
			Queue pfResult = pf.In2Post(Qin); // Convert to postfix
			String postString = pfResult.toString();
			
			println(input+" => "+postString); // Display postfix result
			
			double eval = pf.PostEval(pfResult); // Evaluate the expression
			
			println(postString+" evaluates to "+eval); // And display
			}
		println("Program terminated.");
		}
	}

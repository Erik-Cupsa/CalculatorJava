import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import acm.gui.TableLayout;
import acm.program.Program;

/*
 * @author erikc
 * Graphics program to create a calculator
 */
@SuppressWarnings("serial")
public class JCalcGUI extends Program{ //code based off of code provided by Katrina in the tutorials
	
	//instance variables
	JTextField expression = new JTextField(""); //text field to enter the expression
	JTextField result = new JTextField(""); //text field to return the result of the expression
	JSlider sigfigs = new JSlider(1,10,1); //slider for amount of sigfigs, ranging from 1 to 10 and starting at 1
	postFix pf = new postFix(); //postfix instance
	
	
	//create an instance of JcalcGUI
	public static void main(String[] args) {
		new JCalcGUI().start(args); 
	}
	
	/*
	 * init
	 * Initializing the program
	 */
	public void init() { 
		this.resize(500,500); //setting the size of the window to 500x500
		createInterface(); //calling create interface function to create the graphics of the calculator
		addActionListeners(); //adding action listeners to interface
		
		sigfigs.setPaintTicks(true); //setting minor ticks on the slider
		sigfigs.setMinorTickSpacing(1); //setting the spacing of the ticks to 1 
		
		expression.addActionListener(this); //adding action listener to the expression text field
		expression.setActionCommand("expression"); // setting the action command to "expression"
	}
	
	/*
	 * actionPeformed
	 * if the user performs an action
	 * @param ActionEvent e The action performed
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand(); //getting the command
		
		//switch case with value
		switch(command) {
		case "Quit": //if quit
			//close program
			System.exit(ABORT);
			break;
		case "C": //if clear
			//setting both text fields to a blank string
			expression.setText("");
			result.setText("");
			break;
		case "=": //if equals
			if (expression.getText().contains("=")) break; //if equals has already been pressed do not continue
			computeResult(); //else compute the result by calling computeResult method
			addToExpression("="); //adding an equals sign to the expression
			break;
		case "expression": //if equal button pressed
			if (expression.getText().contains("=")) break; //if equals has already been pressed do not continue
			computeResult(); //else compute the result by calling computeResult method
			addToExpression("="); //adding an equals sign to the expression
			break; 
		case "x": //if multiplication
			addToExpression("*"); //adding an asterisk to represent the multiplication rather than an 'x'
			break;
		default:
			addToExpression(command); //default add the button pressed to the expression text field 
			break;
		}
	}
	
	/*
	 * computeResult
	 * computing the result of the expression and add the result to the result text field 
	 */
	public void computeResult() {
		String input = expression.getText(); //getting the expression as a string
		Queue Qin = pf.parse (input); // Parsing the expression as an input string
		Queue pfResult = pf.In2Post(Qin); // Converting expression to postfix
		String postString = pfResult.toString(); //converting the result to a string
		println(input+" => "+postString); // Displaying postfix result
		double eval = pf.PostEval(pfResult); // Evaluating the expression
		int numSF = sigfigs.getValue(); //number of significant figures from the slider
		String answer = trim (eval, numSF); //calling the trim function to set the answer to the desired sig figs
		result.setText(answer); //setting the answer to the result text field 
	}
	
	/* 
	 * GetNumberOfDigits
	 * 
	 * based off of a program written in C to find the number of digits before a decimal point of a double
	 * Unknown author(2014) "Get number of digits before decimal point" [Source code] 
	 * https://stackoverflow.com/questions/21546793/get-number-of-digits-before-decimal-point
	 * 
	 * @param double d Double to be evaluated
	 * @return int Number of digits prior to the decimal 
	 */
	public int GetNumberOfDigits(double d)
	{
	    double e = Math.abs(d);

	    return e < 1 ? 0 : (int)(Math.log10(e) + 1);
	}
	
	/*
	 * trim
	 * Trims the result to the desired amount of significant figures 
	 * @param double d Number to be trimmed
	 * @param int sigfigs Desired amount of significant figures 
	 * @return String The trimmed result as a string
	 */
	public String trim(double d, int sigfigs) {
		int dig = GetNumberOfDigits(d);//calling GetNumberOfDigits to find the number of digits prior to the decimal
		if(dig == sigfigs) { //if digits before decimal is equal to sigfigs
			int answer = (int) d; //rounding off decimal
			return Integer.toString(answer); //returning answer as a string
		}
		else if(dig > sigfigs) { //if more digits before decimal than sigfigs
			//dividing by 10^(dig-sigfigs)
			int power = dig - sigfigs; 
			power = (int)Math.pow(10, power);
			d = d/power; 
			d = Math.round(d); //rounding the answer
			d = d * power; //multiplying back by 10^(dig-sigfigs) to get answer rounded to desired digits
			int answer = (int) d; //converting to int
			return Integer.toString(answer); //returning answer as a string
		}
		else { //else
			int i = sigfigs - dig; //finding amount of decimal places in result 
			return String.format("%.0"+i+"f", d); //using String.format to round to said amount of decimal places
		}
	}
	
	/*
	 * addToExpression
	 * Adding a command to the expression text field
	 * @param String s String to be added to the text field
	 */
	public void addToExpression(String s) {
		String expr = expression.getText(); //getting the expression
		expr = expr + s; //adding the command to the expression
		expression.setText(expr); //setting new expression to the textfield
	}
	
	/*
	 * createInterface
	 * Adding all buttons, fields and a slider to layout
	 */
	public void createInterface() {
		setLayout(new TableLayout(10,4)); //setting the layout parameters
		
		//adding text fields
		add(expression, "gridwidth = 4");
		add(result, "gridwidth = 4");
		
		//adding all buttons
		add(new JButton("C"), "width = 75");
		add(new JButton(""), "width = 75");
		add(new JButton(""), "width = 75");
		add(new JButton("/"), "width = 75");
		
		add(new JButton("7"), "width = 75");
		add(new JButton("8"), "width = 75");
		add(new JButton("9"), "width = 75");
		add(new JButton("x"), "width = 75");
		
		add(new JButton("4"), "width = 75");
		add(new JButton("5"), "width = 75");
		add(new JButton("6"), "width = 75");
		add(new JButton("-"), "width = 75");
		
		add(new JButton("1"), "width = 75");
		add(new JButton("2"), "width = 75");
		add(new JButton("3"), "width = 75");
		add(new JButton("+"), "width = 75");
		
		add(new JButton("0"), "width = 75");
		add(new JButton("."), "width = 75");
		add(new JButton(""), "width = 75");
		add(new JButton("="), "width = 75");
		
		add(new JButton("("), "width = 75");
		add(new JButton(")"), "width = 75");
		add(new JButton(""), "width = 75");
		add(new JButton(""), "width = 75");
		
		add(new JButton(""), "width = 75");
		add(new JButton(""), "width = 75");
		add(new JButton(""), "width = 75");
		add(new JButton("Quit"), "width = 75");
		
		//adding slider
		add(new JLabel ("Sigfigs:     1"));
		add(sigfigs, "width = 75");
		add(new JLabel ("10"));
		
		//setting background colour to blue
		setBackground(Color.BLUE);
	}
}

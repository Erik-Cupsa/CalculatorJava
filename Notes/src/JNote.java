//A package containing 6 principal classes to assist Java programmers to simplify creation of programs
import java.awt.Color;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;
import acm.util.RandomGenerator; 

public class JNote extends ConsoleProgram{ 

	//replacing with 'DialogProgram' makes popup instead of console dialog
	//'GraphicsProgram' makes it possible to create simple pictures

	public void run() {
//		//adding integers
//		findSum();
		
//		//finding average of n integers
//		averageList(); 
		
		//printing triangle numbers
//		triangleNumberTable(); 
		
		//testing powers of two
//		testPowers2();
		
		//finding GCD
//		startGCD();
		
	}
	
	private void findSum() { // method for adding integers
		println("This program adds two numbers.");
		int n1 = readInt("Enter n1: ");
		int n2 = readInt("Enter n2: ");
		int total = n1 + n2; //<- an expression
		println("The total is " + total + ".");
	}
	
	private void averageList() { // method for finding average 
		int total, n, userInput;
		double average; 
		total = 0;
		n = 0; 
		println("This program finds the average of a list of numbers");
		println("Enter values, one per line, using " + SENTINEL);
		println("to signal the end of the list");
		while(true) { //can use for or while loops to add N integers
			userInput = readInt("?");
			if(userInput == SENTINEL) break; 
			total += userInput; 
			n++;
		}
		average = (double) total / n; 
		println("Your average is: " + average); 
	}
	private static final int SENTINEL= -1; 
	
	private void triangleNumberTable() {
		String output ="1";
		int sum = 1; 
		for(int i=1; i<=10; i++) {
			if(i==1) {
				println(output + " = " + sum);
			} else { 
				sum += i; 
				output = output + " + " + i;
				println(output + " = " + sum);
			}
		}
	}
	
	public void testPowers2() { // method for testing powers of two
		int n; 
		println("input a digit");
		n = readInt("?");
		boolean power = isPowerOfTwo(n);
		println(power);
	}
	private boolean isPowerOfTwo(int n) {
		if (n<1) return false; 
		while (n>1) {
			if (n%2 == 1) {
				return false;
			}
			n /=2; 
		}
		return true;
	}
	
	public void startGCD() { //gcd method
		int x, y; 
		println("input two digits");
		x = readInt("?");
		y = readInt("?"); 
		int factor = gcd(x, y);
		println(factor);
	}
	public int gcd(int x, int y) {
		int r = x % y; 
		while (r!=0) { 
			x = y; 
			y = r; 
			r = x % y; 
		}
		return y; 
	}
}


//public class JNote extends GraphicsProgram { //creating graphics
//
////	receiver.name(arguments); sends a message to an object 
//
//	public void run() {
////		graphicsLabel();
////		GRectPlusGOval();
//		generateRandom();
//	}
//	
//	public void graphicsLabel() { //creating a red text (label)
//		GLabel label = new GLabel("hello, world", 100, 75); //constructor
//		label.setFont("SansSerif-PLAIN-36"); //sets font, 'family-style-size'
//		label.setColor(Color.RED);
//		add(label);
//		
//		//Constructors: new GRect(x,y,width,height), new GOval(x,y,width,height), new GLine(xi,yi,xf,yf)
//		
//		//the following operations apply to all GObjects (Label, Rect, Oval, Line)
//		//object.setColor(color)
//		//object.setLocation(x,y) 
//		//object.move(dx,dy)
//		
//		//methods shared by the GRect and the GOval classes: 
//		//object.setFilled(fill) 
//		//object.setFillColor(color)}
//	}
//	
//	public void GRectPlusGOval() {
//		GRect rect = new GRect(100, 50, 125, 60);
//		rect.setFilled(true);
//		rect.setColor(Color.RED);
//		add(rect);
//		
//		GOval oval = new GOval(100,50,125,60); 
//		oval.setFilled(true);
//		oval.setColor(Color.GREEN);
//		add(oval);
//	}
//	
//	private RandomGenerator rgen = RandomGenerator.getInstance(); //random graphics generating
//	public void generateRandom() {
//		//1. sum of two die rolls
//		int roll1, roll2, total; 
//		roll1 = rgen.nextInt(1,6);
//		roll2 = rgen.nextInt(1,6);
//		total = roll1 + roll2; 
//		println(roll1 + " + " + roll2 + " = " + total);
//	
//		//2. flipping a weighted coin
//		String flip = rgen.nextBoolean(0.6) ? "Heads" : "Tails";
//		println(flip);
//	
//		//3. changing fill color of rect to some random color
//		GRect rect = new GRect(100, 50, 125, 60);
//		rect.setFilled(true);
//		rect.setFillColor(rgen.nextColor());
//		add(rect);
//	}
//}















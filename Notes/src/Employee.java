	/** 
	 * @author erikc
	 * The Employee class keeps track of the following pieces of
	 * data about an employee: the name, employee number, whether 
	 * the employee is active, and the annual salary. 
	 */
	
	public class Employee {
		
		/**
		 * Creates a new Employee object with the specified name and 
		 * employee number. 
		 * @param name The employee's name as a String
		 * @param id The employee number as an int
		 */
		public Employee(String name, int id) { //constructor sets the instance variables
			employeeName = name; 
			employeeNumber = id; 
			active = true; 
		}
		/**
		 * Gets the name of this employee. 
		 * @return The name of this employee
		 */
		public String getName() { //method retrieving value of instance variable, called getter
			return employeeName;
		}
		
		/**
		 * Gets the employee number of this employee
		 * @return The employee number of this employee
		 */
		public int getEmployeeNumber() { //same as above 
			return employeeNumber; 
		}
		
		/**
		 * Gets the employee salary for this employee
		 * @return The employee salary of this employee
		 */
		public double getEmployeeSalary() {
			return annualSalary;
		}
		
		/**
		 * Sets whether the employee is active. 
		 * @param flag The value true or false indicating active status
		 */
		public void setActive(boolean flag) { //method changes the value of an instance variable, called setter
			active = flag;
		}
		
		/**
		 * Returns whether the employee is active
		 * @return Whether the employee is active
		 */
		public boolean isActive() { //getter method, but boolean so begins with is
			return active; 
		}
		
		/** Sets the employee's salary. 
		 * @param Salary The new salary
		 */
		public void setSalary(double salary) {
			annualSalary = salary; 
		}
		
		/**
		 * Creates a string identifying this employee. 
		 * @return The string used to display this employee
		 */
		public String toString() { //tells java how to display a value of this class
			return employeeName + " (#" + employeeNumber + ") "; 
		}
		
		/* Private instance variables */ 
		private String employeeName; /* The employee's name */
		private int employeeNumber; /* The employee number */
		private boolean active; /* Whether the employee is active */
		private double annualSalary; /* The annual salary */
		//these declarations define the instance variables that maintain the internal state of the class
	}
	
	
	
	
	
	
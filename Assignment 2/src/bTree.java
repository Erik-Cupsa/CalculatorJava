import acm.program.*;

//Erik Cupsa, ID Number: 261016180 

/**
 * Implements a B-Tree class
 * @author erikc
 *
 */
public class bTree {
	//this code contains some of the template provided by Prof. Ferrie from ECSE 202

	/**
	 * Constructor 
	 * 
	 * Allows the use of acm methods
	 * @param link
	 */
	public bTree(ConsoleProgram link) { 
		this.link = link; 
	}
	
	//B-tree node data type, nested in bTree class
	public class bNode { 
		String data; //name to be sorted
		bNode left; 
		bNode right; 
	}
	
	/**
	 * makeNode 
	 * 
	 * creates a single instance of a bNode
	 * 
	 * @param String data Name to be stored in the bNode
	 * @return bNode node Node created
	 */
	bNode makeNode (String data) {
		bNode node = new bNode(); //creating new node
		node.data = data; 
		node.left = null; 
		node.right = null; 
		return node; 
	}
	
	/**
	 * addNode
	 * 
	 * adds a new String object to the bTree
	 * @param String data Name to be added to the bTree
	 */
	public void addNode (String data) {
		bNode current; 
		
		if (root == null) { //empty tree
			root = makeNode(data); //making data the root of the tree
		}
		
		else { //if not empty descend to leaf node
			current = root; 
			while (true) { 
				if (keyCompareToIgnoreCase(data, current.data)<0) { //if less than the current node, branches left
					if (current.left == null) { //leaf node
						current.left = makeNode(data); 
						break; 
					}
					else {  //otherwise keep traversing
						current = current.left;
					}
				}
				else { //if greater than the current node, branches right
					 if (current.right == null) { //leaf node
						 current.right = makeNode(data); 
						 break;
					 }
					 else { 
						 current = current.right; //keep traversing
					 }
				}
			}
		}
	}
	
	/**
	 * keyCompareToIgnoreCase 
	 * 
	 * Compares the last names lexicographically
	 * 
	 * @param String name1 The first name
	 * @param String name2 The second name, the one which the first name will be compared to 
	 * @return int lexval The value of the lexicographic comparison of the two strings
	 */
	public int keyCompareToIgnoreCase(String name1, String name2) { 
		//declaring variables
		int lexval;
		String lastName1, lastName2;
		
		//calling the findLastName method and storing the values in the String variables
		lastName1 = findLastName(name1); 
		lastName2 = findLastName(name2);
		
		
		lexval = lastName1.compareToIgnoreCase(lastName2); //lexicographically comparison of the two namess
		
		return lexval; //returning the comparison
	}
	
	
	/**
	 * findLastName
	 * 
	 * Finds the last name from the String
	 * 
	 * @param name Full name
	 * @return String lastName The last name 
	 */
	public String findLastName(String name) {
		//declaring variables
		int length, lastspace; 
		String lastName; 
		
		length = name.length(); //length of the input
		
		lastspace = name.lastIndexOf(" "); //finding the last space in the input string
		
		if(lastspace == -1){ //in case only one name, and String didn't contain a space
			lastspace = 0; //changing value to 0 to properly return the substring
		}
		else lastspace ++; //changing the value to return the substring without the space character
		
		//returning the substring from the last space to the end of the input
		lastName = name.substring(lastspace, length); 
		return lastName; 
	}
	
	/**
	 * displayInOrder()
	 * 
	 * Prints the names in alphabetical order
	 */
	public void displayInOrder() {
		if(root == null) { //if the tree is empty
			link.println("The tree is empty, please try again");
		}
		else traverseInOrder(root); //calling traverseInOrder method 
	}
	
	/**
	 * traverseInOrder()
	 * 
	 * Performs an in order traversal of the bTree recursively
	 * @param bNode root The root node
	 */
	public void traverseInOrder(bNode root) {
			if(root.left != null) { //if the left node is not empty keep traversing
				traverseInOrder(root.left);
			}
			link.println(root.data); //print the node
			if(root.right != null) { //if the right node is not empty keep traversing
				traverseInOrder(root.right);
			}
	}
	
	/**
	 * displayInReverseOrder()
	 * 
	 * Prints the names in reverse alphabetical order
	 */
	public void displayInReverseOrder() { 
		if(root == null) { //if the tree is empty
			link.println("The tree is empty, please try again");
		}
		else traverseInReverseOrder(root); //calling the traverseInReverseOrder method
	}
	
	/**
	 * traverseInReverseOrder()
	 * 
	 * Performs a traversal in the reverse order of the bTree recursively
	 * @param bNode root The root node
	 */
	public void traverseInReverseOrder(bNode root) {
		if(root.right != null) { //if the right node is not empty keep traversing
			traverseInReverseOrder(root.right);
		}
		link.println(root.data); //print the node
		if(root.left != null) { // if the left node is not empty keep traversing
			traverseInReverseOrder(root.left); 
		}
	}
	
	//instance variables
	bNode root = null; 
	ConsoleProgram link=null;
}

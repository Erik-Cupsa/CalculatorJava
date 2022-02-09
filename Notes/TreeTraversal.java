/**
 * Implenets a B-Tree class using a NON-RECURSIVE algorithm
 * @author ferrie
 *
 */
public class TreeTraversal {
	//Instance variables
	bNode root = null; 
	
	public void addNode(int data) {
		bNode current; 
		
		if (root == null) { //empty tree
			root = makeNode(data);
		}
		
		else { //if not empty descend to leaf node
			current = root; 
			while (true) { 
				if (data < current.data) { //branching left
					if (current.left == null) { //leaf node
						current.left = makeNode(data); 
						break; 
					}
					else {  //otherwise keep traversing
						current = current.left;
					}
				}
				else { //branching right
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
	 * makeNode 
	 * 
	 * Creates a single instance of a bNode
	 * 
	 * @param int data Data to be added
	 * @return bNode node Node created
	 */
	public class bNode{ 
		int data; 
		bNode left; 
		bNode right;
	}
	bNode makeNode (int data) { 
		bNode node = new bNode(); 
		node.data = data; 
		node.left = null; 
		node.right = null; 
		return node; 
	}
	
	/**
	 * inorder method - inorder traversal via call to recursive method
	 */
	public void inorder() { //hides recursiion from user
		traverse_inorder(root);
	}
	
	/** 
	 * traverse_inorder method - recursively traverses tree in order (LEFt-Root-RIGHT) and prints each node. 
	 */
	
	private void traverse_inorder(bNode root) { 
		if (root.left != null) traverse_inorder(root.left);
		System.out.println(root.data);
		if (root.right != null) traverse_inorder(root.right);
	}
	
	/**
	 * preorder method- preorder traversal via call to recursive method
	 */
	
	public void preorder() { 
		traverse_preorder(root);
	}
	
	/**
	 * traverse_preorder method - recursively traverses tree in preorder (Root-LEFT-RIGHT) and prints each ndoe. 
	 */
	public void traverse_preorder(bNode root) { 
		System.out.println(root.data); 
		if (root.left != null) traverse_preorder(root.left);
		if (root.right != null) traverse_preorder(root.right);
	}
	
	/**
	 * postorder method - postorder traversal via call to recursive method
	 */
	
	public void postorder() { 
		traverse_postorder(root); 
	}
	
	/**
	 * traverse_postorder method - recursively traverses tree in postorder (LEFT-RIGHT-Root) and prints each node. 
	 */
	
	public void traverse_postorder(bNode root) { 
		if (root.left != null) traverse_postorder(root.left); 
		if (root.right != null) traverse_postorder(root.right); 
		System.out.println(root.data); 
	}
}

















import java.lang.Math;


public class Intervals {
//	•Intervals(): Constructor with no parameters.
//	•void intervalInsert(int a, int b): Adds the interval with left endpoint a and right endpoint b to the collection of intervals. 
//	Each newly inserted interval must be assigned anID. The IDs should be consecutive; that is, 
//	the ID of the interval inserted on the ith call of this method should be i. 
//	For example ifintervalInsertis called successively to insert intervals [5,7],[4,9],[1,8], 
//	then the IDs of these intervals should be 1,2,3, respectively.
//	These IDs are permanent for the respective intervals. 
//	Keep track of the IDs, as multipleintervals that have the same endpoints on both sides can be added.
//	intervalInsertshould run inO(logn)time.
//	
//	•boolean intervalDelete(int intervalID): Deletes the interval whose ID (gener-ated byintervalInsert) isintervalID. 
//	Returns true if deletion was successful. This method should run in O(logn) time.
//	
//	The intervalDelete method is optional; that is, you are not required to implement it. 
//	However, your code must provide an intervalDelete method even if you choose not to implement interval deletion. 
//	If you do not implement deletion, the intervalDelete method should consist of just one line that returns false.
//	
//	•int findPOM(): Finds the endpoint that has maximum overlap and returns its value. Thismethod should run in constant time.
//	•RBTree getRBTree(): Returns the red-black tree used, which is an object of typeRBTree.
	
	private RBTree tree;
	private int ID = 1;
	
	
	/**
	 * The constructor for invervals. Creates RBTree.
	 */
	public Intervals() {
		tree = new RBTree();
	}
	
	/**
	 * Insert an interval starting at a and ending at b into the RBTree. If a is less than b, then the values are swapped.
	 * Creates 2 nodes with the current ID and an endpoint corresponding to a or b. p value is 1 if a, -1 if b
	 * After inserting, ID is incremented, and tree.size is incremented by 2.
	 * @param a
	 * @param b
	 */
	public void intervalInsert(int a, int b) {
		if(a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		Node newNodeA = new Node(ID, new Endpoint(a));
		newNodeA.setP(1);
		Node newNodeB = new Node(ID, new Endpoint(b));
		newNodeB.setP(-1);
		insertHelper(newNodeA);
		insertHelper(newNodeB);
		
		
		ID++;
		tree.incrementSize();
	}
	public boolean intervalDelete(int intervalID) {
		return false;
	}

	/**
	 * returns the endpoint value where the max value exists.
	 * @return
	 */
	public int findPOM() {
		return tree.getRoot().getEmax().getValue();
	}
	
	/**
	 * returns the RBTree used
	 * @return
	 */
	public RBTree getRBTree() {
		return tree;
	}
	
	/**
	 * updates Val, MaxVal, Emax, and Height recursively
	 * @param node
	 */
	private void updateFields(Node node) {
		getValHelper(node);
		updateMaxVal(node);
		calcEmax(node);
		updateHeight(node);
		
	}
	

	/**
	 * Updates the the MaxVal
	 * @param a Node
	 */
	private void updateMaxVal(Node node) {
		node.setMaxVal(Math.max(Math.max(node.leftChild.getMaxVal(), node.leftChild.getMaxVal() + node.getP()), 
				node.leftChild.getMaxVal() + node.getP() + node.rightChild.getMaxVal()));
		
		if(!node.parent.equals(tree.getNILNode()))
			updateMaxVal(node.parent);
	}
	
	/**
	 * Updates the height of the tree
	 * @param a Node
	 */
	private void updateHeight(Node node) {
		if(node.equals(tree.getNILNode())) {
			node.height = 0;
			return;
		}
		else
			node.height = Math.max(node.rightChild.height + 1, node.leftChild.height + 1);
		updateHeight(node.parent);
	}
	
	/**
	 * A helper method for getVal. Gets the val of left child and right child
	 * and sums with the current node
	 */
	private void getValHelper(Node current) {
	     if(current.equals(tree.getNILNode())) {
	    	 current.setVal(0);
	    	 return;
	     }
	     current.setVal(current.leftChild.getVal() + current.getP() + current.rightChild.getVal());
	     getValHelper(current.parent);
	}
	
	/**
	 * Calculates Emax  
	 * @param node 
	 */
	private void calcEmax(Node node){
		if(node.leftChild.equals(tree.getNILNode()) && node.rightChild.equals(tree.getNILNode())) {
			if(node.getP() == 1)
				node.setEmax(node.getEndpoint());
			else
				node.setEmax(tree.getNILNode().getEndpoint());
		}
		if(node.getP() == -1)
			node.setEmax(node.leftChild.getEmax());
		if(node.getP() == 1 && !node.rightChild.equals(tree.getNILNode()) && node.rightChild.getP() == -1)
			node.setEmax(node.getEndpoint());
		if(node.getP() == 1 && !node.rightChild.equals(tree.getNILNode()) && node.rightChild.getP() == 1)
			node.setEmax(node.rightChild.getEmax());
		
		if(!node.equals(tree.root))
			calcEmax(node.parent);
	}
	
	
	/**
	 * Helper method for insert. Does the insertion into the tree, and is used to save code in Insert
	 * @param node - node to be inserted
	 */
	private void insertHelper(Node node) {
		Node x = tree.getRoot();
		Node y = tree.getNILNode();
		
		while(x != tree.getNILNode()) {
			y = x;
			if(node.getKey() < x.getKey())
				x = x.getLeft();
			else
				x = x.getRight();
		}
		node.parent = y;
		if(y == tree.getNILNode()) {
			tree.root = node;
			node.leftChild = tree.getNILNode();
			node.rightChild = tree.getNILNode();
			node.parent = tree.getNILNode();
		}
		else if(node.getKey() < y.getKey())
			y.leftChild = node;
		else if(node.getKey() == y.getKey() && y.getP() != 1) {
			if(y.parent.leftChild.equals(y)) {
				node.parent = y.parent;
				node.leftChild = y.leftChild;
				node.rightChild = y;
				node.parent.leftChild = node;
				y.parent = node;
				node = y;
			}
			else {
				node.parent = y.parent;
				node.leftChild = y.leftChild;
				node.rightChild = y;
				node.parent.rightChild = node;
				y.parent = node;
				node = y;
			}
		}
		else
			y.rightChild = node;
		node.leftChild = tree.getNILNode();
		node.rightChild = tree.getNILNode();
		node.color = 1;
		insertFixup(node);
		updateFields(node);
	}
	
	
	/**
	 * checks the color of each node in tree, then 
	 * fixes the tree after insertion.
	 * @param node - the node to be fixed up
	 */
	private void insertFixup(Node node) {
		Node temp;
		while(node.parent.color == 1) {
			if(node.parent.equals(node.parent.parent.leftChild)) {
				temp = node.parent.parent.rightChild;
				if(temp.color == 1) {
					node.parent.color = 0;
					temp.color = 0;
					node.parent.parent.color = 1;
					node = node.parent.parent;
				}
				else {
					if(node.equals(node.parent.rightChild)) {
						node = node.parent;
						leftRotate(node);
					}
					node.parent.color = 0;
					node.parent.parent.color = 1;
					rightRotate(node.parent.parent);
				}
			}
			else {
				temp = node.parent.parent.leftChild;
				if(temp.color == 1) {
					node.parent.color = 0;
					temp.color = 0;
					node.parent.parent.color = 1;
					node = node.parent.parent;
				}
				else {
					if(node.equals(node.parent.leftChild)) {
						node = node.parent;
						rightRotate(node);
					}
					node.parent.color = 0;
					node.parent.parent.color = 1;
					leftRotate(node.parent.parent);
				}
			}		
		}
		tree.getRoot().color = 0;
	}
	
	/**
	 * Rotates a node to the left.
	 * @param node
	 */
	private void leftRotate(Node node) {
		Node temp = node.leftChild;
		node.rightChild = temp.leftChild;
		if(temp.leftChild != null)
			temp.leftChild.parent = node;
		temp.parent = node.parent;
		if(node.parent.equals(tree.getNILNode()))
			tree.root = temp;
		else if(node.equals(node.parent.leftChild))
			node.parent.leftChild = temp;
		else
			node.parent.rightChild = temp;
		temp.leftChild = node;
		node.parent = temp;
	}
	
	/**
	 * Rotates a node to the right.
	 * @param node
	 */
	private void rightRotate(Node node) {
		Node temp = node.rightChild;
		node.leftChild = temp.rightChild;
		if(temp.rightChild != null)
			temp.rightChild.parent = node;
		temp.parent = node.parent;
		if(node.parent.equals(tree.getNILNode()))
			tree.root = temp;
		else if(node.equals(node.parent.rightChild))
			node.parent.rightChild = temp;
		else
			node.parent.leftChild = temp;
		temp.rightChild = node;
		node.parent = temp;
	}
}

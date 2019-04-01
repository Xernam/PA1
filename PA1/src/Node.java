
public class Node {
//	Node getParent(): Returns the parent of this node.
//	�Node getLeft(): Returns the left child.
//	�Node getRight(): Returns the right child.
//	�int getKey(): Returns the endpoint value, which is an integer.
//	�int getP(): Returns the value of the function p based on this endpoint.
//	�int getVal(): Returns the val of the node as described in this assignment.
//	�int getMaxVal(): Returns the max val of the node as described in this assignment.
//	�Endpoint getEndpoint(): Returns theEndpointobject that this node represents.
//	�Endpoint getEmax(): Returns an Endpoint object that represents emax. 
//	Calling this method on the root node will give theEndpointobject whose getValue() provides a point of maximum overlap.
//	�int getColor(): Returns 0 if red. Returns 1 if black.
	Node parent;
	Node leftChild;
	Node rightChild;
	int color;
	private Endpoint key;
	private int p;
	private int val;
	private int maxval;
	private Endpoint emax;
	private int ID;
	int height;
	
	
	/**
	 * Constructor for the Node object
	 * @param int id and Endpoint temp
	 */
	public Node(int Id, Endpoint temp) {
		parent = this;
		leftChild = this;
		rightChild = this;
		color = 0;
		key = temp;
		p = 0;
		val = 0;
		maxval = 0;
		emax = null;
		ID = Id;
		height = 0;
	}
	
	/**
	 * Gets the parent
	 * @return parent Node
	 */
	public Node getParent() {
		return this.parent;
	}
	
	/**
	 * Gets left child
	 * @return left child Node
	 */
	public Node getLeft() {
		return this.leftChild;
	}
	
	/**
	 * Gets right child
	 * @return right child Node
	 */
	public Node getRight() {
		return this.rightChild;
	}
	
	/**
	 * Gets the key of the current node
	 * @return int key
	 */
	public int getKey() {
		return key.getValue();
	}
	
	/**
	 * Gets P of the current node
	 * @return int p
	 */
	public int getP() {
		return p;
	}
	
	/**
	 * Sets P
	 * @param pval int
	 */
	public void setP(int pval) {
		p = pval;
	}
	
	/**
	 * Sets the value of the node
	 * @param int value
	 */
	public void setVal(int value) {
		val = value;
	}
	
	/**
	 * Gets the value of the node
	 * @return int value
	 */
	public int getVal() {
		return val;
	}
	
	/**
	 * get the maxVal of the current node
	 * @return int max val
	 */

	public int getMaxVal() {
		return maxval;
	}
	
	/**
	 * Sets the maxVal of the current node
	 * @param int val
	 */
	public void setMaxVal(int val) {
		maxval = val;
	}
	
	/**
	 * gets the endpoint of the current node
	 * @return Endpoint 
	 */
	public Endpoint getEndpoint() {
		return key;
	}
	
	/**
	 * gets the endpoint that has the maximum overlap
	 * @return Endpoint 
	 */
	public Endpoint getEmax() {
		return emax;
	}
	
	/**
	 * Set the endpoint that has maximum overlap
	 * @param Endpoint object
	 */
	public void setEmax(Endpoint endpoint) {
		emax = endpoint;
	}
	
	/**
	 * Gets color of node
	 * @return int of color
	 */
	public int getColor() {
		return this.color;
	}
	
	/**
	 * gets the ID of the current node
	 * @return gives the int value
	 */
	public int getID() {
		return this.ID;
	}
	
	/**
	 * Checks to see if nodes equal this node. Compares ID and P. 
	 * @param Node to compare to
	 * @return boolean 
	 */
	public boolean equals(Node b) {
		if((this.getID() == b.getID()) && this.getP() == b.getP())
			return true;
		return false;
	}
}

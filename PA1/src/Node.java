import java.lang.Math;


public class Node {

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
	private int size;
	int height;
	
	/**
	 * Constructor for the Node object
	 * @param int id and Endpoint temp
	 */
	public Node(int Id, Endpoint temp) {
		parent = null;
		leftChild = null;
		rightChild = null;
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
	 * Gets key
	 * @return int key
	 */
	public int getKey() {
		return key.getValue();
	}
	
	/**
	 * Gets P
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
	 * Sets the value
	 * @param int value
	 */
	public void setVal(int value) {
		val = value;
	}
	
	/**
	 * Gets the value
	 * @return int value
	 */
	public int getVal() {
		return val;
	}
	
	/**
	 * get the maxVal
	 * @return int max val
	 */
	public int getMaxVal() {
		return maxval;
	}
	
	/**
	 * Sets the max val
	 * @param int val
	 */
	public void setMaxVal(int val) {
		maxval = val;
	}
	
	/**
	 * gets the endpoint
	 * @return Endpoint 
	 */
	public Endpoint getEndpoint() {
		return key;
	}
	
	/**
	 * gets the endpoint
	 * @return Endpoint 
	 */
	public Endpoint getEmax() {
		return emax;
	}
	
	/*
	 * Set max 
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
	 * Gets the size 
	 * @return int value of size
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * gets the ID
	 * @return gives the int value
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * Updates the max val
	 * @return int of P
	 */
	public int updateMaxVal() {
		if(this.ID==0) {
			this.setP(0);
		}
		else {
			this.setP(Math.max(Math.max(this.leftChild.updateMaxVal(), this.leftChild.updateMaxVal() + this.getP()), 
					this.leftChild.updateMaxVal() + this.getP() + this.rightChild.updateMaxVal()));
		}
		updateMaxValParent();
		return this.getP();
	}
	
	
	/**
	 * Recursively update max val of parent nodes 
	 * 
	 */
	public void updateMaxValParent() {
		//Base case
		if(this.getParent().getP() == 0) {
			return;
		}
		//Node is a leftChild
		else if(this.parent.rightChild.equals(this)) {
			this.getParent().setP
			(Math.max(
					Math.max(this.getMaxVal(), 
					this.getMaxVal() + this.getParent().getP()), 
					this.getMaxVal() + this.getParent().getP() + this.getParent().getRight().getMaxVal()));
		}
		//Node is RightChild
		else {
			this.getParent().setP
			(Math.max(
					Math.max(this.getParent().getLeft().getMaxVal(), 
							this.getParent().getLeft().getMaxVal() + this.getParent().getP()), 
							this.getParent().getLeft().getMaxVal() + this.getParent().getP() + this.getMaxVal()));
		}
		
		//Recursive call
		
		//Parent of node is a right child
		if(this.getParent().getParent().getRight().equals(this.getParent())) { //throws a nullpointer. Maybe move to intervals to have access to getNILNode.
			this.getParent().updateMaxValParent();
		}
		//Parent of node is a left child
		else {
			this.getParent().updateMaxValParent();
		}
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

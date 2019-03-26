import java.lang.Math;


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
	private int emax;
	private int ID;
	
	
	public Node(int ID, Endpoint temp) {
		parent = null;
		leftChild = null;
		rightChild = null;
		color = 0;
		temp = key;
		p = 0;
		val = 0;
		maxval = 0;
		emax = 0;
		ID = ID;
	}
	public Node getParent() {
		return this.parent;
	}
	public Node getLeft() {
		return this.leftChild;
	}
	public Node getRight() {
		return this.rightChild;
	}
	public int getKey() {
		return key.getValue();
	}
	public int getP() {
		return p;
	}
	
	public void setP(int pval) {
		p = pval;
	}
	
	//I think this is a valid solution to the problem. Definetly not the most 
	// effecient way to do it, but I think it's right. 
	public int getVal() {
		val = 0;
		val = getValHelper(val, this);
		
		return val;
	}
	
	private int getValHelper(int sum, Node current) {
		 if(this.getLeft() != null) {
			 sum = sum + getValHelper(sum, this.getLeft());
		 }
		 
		 if(this.getRight() != null) {
			 sum = sum + getValHelper(sum, this.getRight());
		 }
		 
		 return sum;
	}
	
	public int getMaxVal() {
		updateMaxVal();
		return maxval;
	}
	public Endpoint getEndpoint() {
		return key;
	}
	public Endpoint getEmax() {
		return null;
	}
	public int getColor() {
		return this.color;
	}

	
	public void updateMaxVal() {
		maxval = Math.max(this.getLeft().getMaxVal(), this.getLeft().getP() + this.getLeft().getVal());
		maxval = Math.max(maxval, this.getLeft().getVal() + this.getP() + this.getRight().getMaxVal());
	}
}

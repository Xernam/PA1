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
	private Endpoint emax;
	private int ID;
	private int size;
	int height;
	
	
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
	
	public void setVal(int value) {
		val = value;
	}
	
	public int getVal() {
		return val;
	}
	
	public int getMaxVal() {
		return maxval;
	}
	public Endpoint getEndpoint() {
		return key;
	}
	public Endpoint getEmax() {
		return emax;
	}
	public void setEmax(Endpoint endpoint) {
		emax = endpoint;
	}
	
	public int getColor() {
		return this.color;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getID() {
		return this.ID;
	}

	//move to insert, make it recursive
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
	
	
	//Given a node with an updated maxval, recursively updates the parent nodes' maxval
	public void updateMaxValParent() {
		//Base case
		if(this.getParent()==null) {

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
		if(this.getParent().getParent().getRight().equals(this.getParent())) {
			this.getParent().updateMaxValParent();
		}
		//Parent of node is a left child
		else {
			this.getParent().updateMaxValParent();
		}
	}
	
	public boolean equals(Node b) {
		if((this.getID() == b.getID()) && this.getKey() == b.getKey())
			return true;
		return false;
	}
}


public class Node {
//	Node getParent(): Returns the parent of this node.
//	•Node getLeft(): Returns the left child.
//	•Node getRight(): Returns the right child.
//	•int getKey(): Returns the endpoint value, which is an integer.
//	•int getP(): Returns the value of the function p based on this endpoint.
//	•int getVal(): Returns the val of the node as described in this assignment.
//	•int getMaxVal(): Returns the max val of the node as described in this assignment.
//	•Endpoint getEndpoint(): Returns theEndpointobject that this node represents.
//	•Endpoint getEmax(): Returns an Endpoint object that represents emax. 
//	Calling this method on the root node will give theEndpointobject whose getValue() provides a point of maximum overlap.
//	•int getColor(): Returns 0 if red. Returns 1 if black.
	Node parent;
	Node leftChild;
	Node rightChild;
	int color;
	private Endpoint key;
	private int p;
	
	public Node() {
		
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
		return 0;
	}
	public int getVal() {
		return 0;
	}
	public int getMaxVal() {
		return 0;
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
}

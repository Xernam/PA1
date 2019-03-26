
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
	private Node root;
	private Node NIL;
	private int ID;
	
	public Intervals() {
		root = tree.getRoot();
		NIL = tree.getNILNode();
	}
	public void intervalInsert(int a, int b) {
		if(root == null) {
			Node left = new Node(ID, new Endpoint(a));
			root = left;
			root.setP(1);
			Node right = new Node(ID, new Endpoint(b));
			right.color = 1;
			root.leftChild = right;
			root.parent = NIL;
			root.rightChild = NIL;
			right.leftChild = NIL;
			right.rightChild = NIL;
			right.parent = root;
			right.setP(-1);
		}
		//doing some commenting since I am going to go swimming.
		//If left is less than right, invalid format
		//new node, key is a or b, p value is -1 for a, +1 for b.
		//Endpoint has value of a or b
		ID++;
	}
	public boolean intervalDelete(int intervalID) {
		return false;
	}
	public int findPOM() {
		return 0;
	}
	public RBTree getRBTree() {
		return tree;
	}
	
	private void leftRotate(Node node) {
		Node temp = node.leftChild;
		node.rightChild = temp.leftChild;
		if(temp.leftChild == null)
			temp.leftChild.parent = node;
		temp.parent = node.parent;
		if(node.parent == null)
			root = temp;
		else if(node == node.parent.leftChild)
			node.parent.leftChild = temp;
		else
			node.parent.rightChild = temp;
		temp.leftChild = node;
		node.parent = temp;
	}
	
	private void rightRotate(Node node) {
		Node temp = node.rightChild;
		node.leftChild = temp.rightChild;
		if(temp.rightChild == null)
			temp.rightChild.parent = node;
		temp.parent = node.parent;
		if(node.parent == null)
			root = temp;
		else if(node == node.parent.rightChild)
			node.parent.rightChild = temp;
		else
			node.parent.rightChild = temp;
		temp.leftChild = node;
		node.parent = temp;
	}
}

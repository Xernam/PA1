
public class RBTree {
	
//	•RBTree(): Constructor with no parameters
//	•Node getRoot(): Returns the root node.
//	•Node getNILNode(): Returns the nilnode. 
//	Note.A red-black treeTmust contain exactly one instance of T.nil
	
//	•int getSize(): Returns the number of internal nodes in the tree.
//	•int getHeight(): Returns the height of the tree.
	
	public Node root;
	public Node NIL;
	private int size;
	private int height;
	
	/**
	 * Constructor for the RBTree
	 */
	public RBTree() {
		NIL = new Node(0, null);
		root = NIL;
	}
	
	/**
	 * get root of tree
	 * @return the Node 
	 */
	public Node getRoot() {
		return root;
	}
	
	/**
	 * get Nil Node
	 * @return the Nil node
	 */
	public Node getNILNode() {
		return NIL;
	}
	
	/**
	 * Gets the size of the tree (amount of nodes)
	 * gets int size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * get height of tree
	 * @return int height of RB Tree
	 */
	public int getHeight() {
		return root.height;
	}
	
	/**
	 * increments size of RB tree by 2
	 * 
	 */
	public void incrementSize() {
		size = size + 2;
	}
	
	/**
	 * decrement size of RB tree by 2
	 */
	public void decrementSize() {
		size = size - 2;
	}
	
	/**
	 * sets root if root is equal to NIL, otherwise does nothing
	 * @param node - node to assign root to
	 */
	public void setRoot(Node node) {
		if (root.equals(NIL)) {
			root = node;
		}
	}
	
}

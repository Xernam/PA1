
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
	
	public RBTree() {
		NIL = new Node(0, null);
		root = NIL;
	}
	public Node getRoot() {
		return root;
	}
	public Node getNILNode() {
		return NIL;
	}
	public int getSize() {
		return size;
	}
	public int getHeight() {
		return height;
	}
	
	public void incrementSize() {
		size = size + 2;
	}
	
	public void decrementSize() {
		size = size - 2;
	}
	
	/**
	 * sets root if root is equal to NIL, otherwise does nothing
	 * @param node - node to assign root to
	 */
	public void setRoot(Node node) {
		if (root.equals(NIL))
			root = node;
	}
	
}

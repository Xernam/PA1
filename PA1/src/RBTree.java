
public class RBTree {
	
//	�RBTree(): Constructor with no parameters
//	�Node getRoot(): Returns the root node.
//	�Node getNILNode(): Returns the nilnode. 
//	Note.A red-black treeTmust contain exactly one instance of T.nil
	
//	�int getSize(): Returns the number of internal nodes in the tree.
//	�int getHeight(): Returns the height of the tree.
	
	private Node root;
	private Node NIL;
	private int size;
	private int height;
	
	public RBTree() {
		NIL = new Node(0, new Endpoint(0));
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
	
	public void setRoot(Node node) {
		if (root.equals(NIL))
			root = node;
	}
	
}

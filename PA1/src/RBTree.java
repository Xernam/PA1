
public class RBTree {
	
//	•RBTree(): Constructor with no parameters
//	•Node getRoot(): Returns the root node.
//	•Node getNILNode(): Returns the nilnode. 
//	Note.A red-black treeTmust contain exactly one instance of T.nil
	
//	•int getSize(): Returns the number of internal nodes in the tree.
//	•int getHeight(): Returns the height of the tree.
	
	private Node root;
	private Node NIL;
	private int size;
	private int height;
	
	public RBTree() {
		NIL = null;
		root = NIL;
		root.parent = null;
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
	
}

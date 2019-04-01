import static org.junit.Assert.*;
import org.junit.*;
public class IntervalTests {

	//Testing
	//Height should be the height of the tree (not black height).
	//Testing value should be the sum of the values of right child, left child, and current node's p value
	//MaxVal should be the highest sum of p values in the tree
	//emax should be the node at the start of the "max value chain"
	//		this means that if a node has a MaxVal of 3 and p value is 1, then both left and right child have a value of 1.
	//		Since this is sorted like a binary search tree, the greatest of the keys lie in the right child.
	//		Therefore, emax is in the right child of the current node.
	
	//Let me know if I need to clarify any more of this. I'll be available until 3:30 and then after 10:30
	//	-Logan
	
	
	
	@Test
	public void testHeightNoEnd() {
		RBTree tree = new RBTree();
		assertEquals(tree.getHeight(), 0);
	}
	
	@Test
	public void testEmaxNoEnd() {
		RBTree tree = new RBTree();
		assertEquals(tree.root.getEmax(), null);
	}
	
	@Test
	public void testMaxNoEnd() {
		RBTree tree = new RBTree();
		assertEquals(tree.root.getMaxVal(), 0);
	}
	
	@Test
	public void testValNoEnd() {
		RBTree tree = new RBTree();
		assertEquals(tree.root.getVal(), 0);
	}
	
	@Test
	public void insertTest1() {
		Intervals interval = new Intervals();
		interval.intervalInsert(0, 4);
		assertEquals(interval.getRBTree().root.getEmax(), interval.getRBTree().root.getEndpoint());
	}
	
	@Test
	public void insertTest2() {
 		Intervals interval = new Intervals();
 		interval.intervalInsert(0, 4);
		interval.intervalInsert(1, 5);
		assertEquals(interval.getRBTree().root.getEmax(), interval.getRBTree().root.leftChild.getEndpoint());
		assertEquals(interval.getRBTree().root.parent, interval.getRBTree().NIL);
	}
	
}

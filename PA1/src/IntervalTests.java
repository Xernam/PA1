import static org.junit.Assert.*;
import org.junit.*;
public class IntervalTests {

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
		assertEquals(interval.getRBTree().root.getEmax(), interval.getRBTree().root);
	}
}

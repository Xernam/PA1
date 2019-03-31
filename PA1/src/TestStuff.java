import static org.junit.Assert.*;

import org.junit.Test;

public class TestStuff {
	
	Endpoint end0 = new Endpoint(0);
	Endpoint end3 = new Endpoint(3);
	Endpoint end4 = new Endpoint(4);
	Endpoint end6 = new Endpoint(6);
	
	Node a = new Node(1, end0);
	Node b = new Node(2, end3);
	Node c = new Node(3, end4);
	Node d = new Node(4, end6);
	
	Intervals interval = new Intervals();
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

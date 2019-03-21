
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
	
	public Intervals() {
		
	}
	public void intervalInsert(int a, int b) {
		//doing some commenting since I am going to go swimming.
		//If left is less than right, invalid format
		//new node, key is a or b, p value is -1 for a, +1 for b.
		//Endpoint has value of a or b
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
}

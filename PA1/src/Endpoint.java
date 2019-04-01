/**
 * 
 * @author Logan Williams, Durga Darba, Josiah Weeks
 *
 */

public class Endpoint {
//	•int getValue(): Returns the endpoint value.  
//	For example if the Endpoint object represents the left endpoint of the interval [1,3], this would return 1.
	
	private int value;
	
	/**
	 * @param int value The value at endpoint
	 */
	public Endpoint(int value) {
		this.value = value;
	}
	
	/**
	 * gets value of endpoint.
	 * @return int of the value
	 */
	public int getValue() {
		return value;
	}
}

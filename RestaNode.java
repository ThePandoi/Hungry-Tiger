/**
 * 4/14/2023
 * @author Andy Pan
 */ 
package hungry_tiger_;

/**
 * Class for the Restaurant Node
 */
public class RestaNode {
	// rest id 
	private int rest_id;
	// the restaurant itself
	private Restaurant place;
	// next node
	public RestaNode next;
	/**
	 * constructor
	 * @param rest_id
	 * @param place
	 */
	public RestaNode(int rest_id, Restaurant place) {
		this.rest_id = rest_id;
		this.place = place;
		this.next = null;
	}
	/**
	 * constructor
	 * @param rest_id
	 * @param place
	 * @param next
	 */
    public RestaNode(int rest_id, Restaurant place, RestaNode next) {
    	this.rest_id = rest_id;
    	this.place = place;
    	this.next = next;
    }
    /**
	 * id gettter
	 * @return rest_id
	 */
    public int getid() {
    	return rest_id;
    }
    /**
	 * rest getter
	 * @return place
	 */
    public Restaurant getplace() {
    	return place;
    }
	/** 
	 * id setter
	 * @param id
	 */
	public void setid(int id) {
		this.rest_id = id;
	}
	/** 
	 * rest setter
	 * @param place the restaurant 
	 */
	public void setplace(Restaurant place) {
		this.place = place;
	}
}
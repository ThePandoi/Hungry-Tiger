/**
 * 4/14/2023
 * @author Andy Pan, Klayr DeFelice
 */ 
package hungry_tiger_;

/**
 * Class for the Restaurant Node
 */
public class MenuItemNode {
	// rest id 
	private int id;
	// the restaurant itself
	private Menu_Item item;
	// next node
	public MenuItemNode next;
	/**
	 * constructor
	 * @param rest_id
	 * @param place
	 */
	public MenuItemNode(int rest_id, Menu_Item item) {
		this.id = rest_id;
		this.item = item;
		this.next = null;
	}
	/**
	 * constructor
	 * @param rest_id
	 * @param place
	 * @param next
	 */
    public MenuItemNode(int rest_id, Menu_Item item, MenuItemNode next) {
    	this.id = rest_id;
    	this.item = item;
    	this.next = next;
    }
    /**
	 * id gettter
	 * @return rest_id
	 */
    public int getid() {
    	return id;
    }
    /**
	 * rest getter
	 * @return place
	 */
    public Menu_Item getitem() {
    	return item;
    }
	/** 
	 * id setter
	 * @param id
	 */
	public void setid(int id) {
		this.id = id;
	}
	/** 
	 * rest setter
	 * @param place the restaurant 
	 */
	public void setItem(Menu_Item item) {
		this.item = item;
	}
}
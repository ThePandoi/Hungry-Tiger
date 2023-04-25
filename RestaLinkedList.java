/**
 * 4/14/2023
 * @author Andy Pan
 */
package hungry_tiger_;
/**
 * class for the Restaurant Linked List
 */
public class RestaLinkedList {
	// head of the Linked List
	private RestaNode head;
	/**
	 * constructor 
	 */
	public RestaLinkedList() {
		head = null;
	}
	/**
	 * constructor
	 * @param head
	 */
	public RestaLinkedList(RestaNode head) {
		this.head = head;
	}
	/**
	 * getter for head
	 * @return head
	 */
	public RestaNode gethead() {
		return head;
	}
	/**
	 * setter for head
	 * @param node
	 */
	public void sethead(RestaNode node) {
		this.head = node;
	}
	/**
	 * method that adds a node to the end of the list
	 * @param node
	 */
	public void addNode(RestaNode node) {
		if (head == null) {
			sethead(node);
		}
		else {
			RestaNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}
	/**
	 * deletes a node based on the given node's id
	 * @param node
	 */
	public void deleteNode(RestaNode node) {
		int id = node.getid();
		if (head.getid() == id) {
			head = head.next;
		}
		else {
			RestaNode current = head;
			while (current.next != null) {
				if (current.next.getid() == id) {
					current.next = current.next.next;
				}
				else {
					current = current.next;
				}
			}

		}
	}
	/**
	 * returns the size of the linked list
	 * @return int that represents the size of the linked list
	 */
	public int size() {
		int num = 0;
		RestaNode current = head;
		while (current != null) {
			num++;
			current = current.next;
		}
		return num;
	}
	/**
	 * searches for a node based on index
	 * @param index
	 * @return node at index spot
	 * 
	 * previous version ran into a null value error. this one is a little cleaner. 
	 */
	public RestaNode searchbyindex(int index) {
		//int spot = 0;
		RestaNode current = head;
		if (size() < index) {
			return null;
		}
		while (current != null && index!=current.getid()) {
			current = current.next;
		}
		return current;
	}
	/**
	 * searches for a node by id
	 * @param id
	 * @return node with identical id
	 */
	public RestaNode searchbyid(int id) {
		RestaNode current = head;
		while (current != null) {
			if (current.getid() == id) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	/**
	 * switches the places of two nodes
	 * @param node1
	 * @param node2
	 * @return 1 on success; 0 on failure 
	 */ 
	public int exchange(RestaNode node1, RestaNode node2) {
		if (node1 == node2 || node1.getid() == node2.getid()) {
			return 0;
		}
		//int subid = node1.getid();
		Restaurant subitem = node1.getplace();
		// updating node1
		//node1.setid(node2.getid());
		node1.setplace(node2.getplace());
		// updating node2
		//node2.setid(subid);
		node2.setplace(subitem);
		return 1;
	}
}
/**
 * 4/14/2023
 * @author Andy Pan, Klayr DeFelice, Ali Kadhim, Nate Baugher
 */
package hungry_tiger_;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * class for the MenuItem Linked List
 */
public class MenuItemLinkedList {
	// head of the Linked List
	private MenuItemNode head;
	/**
	 * constructor 
	 */
	public MenuItemLinkedList() {
		head = null;
	}
	/**
	 * constructor
	 * @param head
	 */
	public MenuItemLinkedList(MenuItemNode head) {
		this.head = head;
	}
	/**
	 * getter for head
	 * @return head
	 */
	public MenuItemNode gethead() {
		return head;
	}
	/**
	 * setter for head
	 * @param node
	 */
	public void sethead(MenuItemNode node) {
		this.head = node;
	}
	/**
	 * method that adds a node to the end of the list
	 * @param node
	 */
	public void addNode(MenuItemNode node) {
		if (head == null) {
			sethead(node);
		}
		else {
			MenuItemNode current = head;
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
	public void deleteNode(MenuItemNode node) {
		int id = node.getid();
		if (head.getid() == id) {
			head = head.next;
		}
		else {
			MenuItemNode current = head;
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
		MenuItemNode current = head;
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
	 * previous version ran into a null value error when returning indexes greater than 0, I think it
	 * had to do with adding to the index rather than the spot.
	 * this version is more straightforward.
	 */
	public MenuItemNode searchbyindex(int index) {
		//int spot = 0;
		MenuItemNode current = head;
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
	public MenuItemNode searchbyid(int id) {
		MenuItemNode current = head;
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
	public int exchange(MenuItemNode node1, MenuItemNode node2) {
		if (node1 == node2 || node1.getid() == node2.getid()) {
			return 0;
		}
		//int subid = node1.getid();
		Menu_Item subitem = node1.getitem();
		// updating node1
		//node1.setid(node2.getid());
		node1.setItem(node2.getitem());
		// updating node2
		//node2.setid(subid);
		node2.setItem(subitem);
		return 1;
	}



	public void sortByPrice(MenuItemNode head) {
		MenuItemNode headCopy = head;
		MenuItemNode index = null;

		//MenuItemNode temp = head;

		if (head == null) {
			return;
		}
		else {
			while (headCopy != null) {

				index = headCopy.next;

				while (index != null) {

					if (headCopy.getitem().get_price() > index.getitem().get_price()) {//just using exchange here fixes the problem
						exchange(headCopy,index);
					}

					index = index.next;
				}
				headCopy = headCopy.next;
			}
		}
		
	}

	public void sortByReviewScore(MenuItemNode head) {
		MenuItemNode headCopy = head;
		MenuItemNode index = null;

		//double temp;

		if (head == null) {
			return;
		}
		else {
			while (headCopy != null) {

				index = headCopy.next;

				while (index != null) {

					if (headCopy.getitem().get_rev() > index.getitem().get_rev()) {//just using exchange here fixes the problem
						exchange(headCopy,index);
					}

					index = index.next;
				}
				headCopy = headCopy.next;
			}
		}

	}
	
	/**
	*Sorts our item list based on search tag relevance
	*@param head the head of the menu item list
	*@param searchTags an array list of user inputted search tags
	*/
	public void sortByRelevance(MenuItemNode head, ArrayList<String> searchTags){
		MenuItemNode curNode = head;
		MenuItemNode prevNode = null;
		MenuItemNode tempSortNode;
		//HashMap<String, String> cs = new HashMap<>();
		HashMap<String, Boolean> userTags = new HashMap<>();
		for (int i = 0; i < searchTags.size(); i++){ //hash map yay! :D
			userTags.put(searchTags.get(i).toLowerCase(), true);
		}
		ArrayList<String> curNodeTags;
		int curRelevance = 0;
		while (curNode != null){ //loop through menu list
			curNodeTags = curNode.getitem().get_tags();
			for (int i = 0; i < curNodeTags.size(); i++){ //loop through tags of current node
				Boolean trueOrFalse = userTags.get((curNodeTags.get(i).toLowerCase()));
				if (trueOrFalse != null){ //current tag was found in hash map (common hash map w)
					curRelevance++;
				}
				
			}
			curNode.getitem().set_relevance(curRelevance);
			if (curRelevance > head.getitem().get_relevance()){ //set current item as new head;
				prevNode.next = curNode.next;
				curNode.next = gethead();
				sethead(curNode);
				curNode = prevNode.next;
			}
			else if (prevNode != null && (curRelevance > prevNode.getitem().get_relevance())){ //current node is more relevant than previous node item so sort it
				tempSortNode = head;
				while (curRelevance < tempSortNode.next.getitem().get_relevance()){ //loop until we find a node that is less relevant than the node we are sorting
					tempSortNode = tempSortNode.next;
				}
				//remove current node from its position
				prevNode.next = curNode.next;
				//insert current node into its correct position
				curNode.next = tempSortNode.next;
				//update temporary sort node to point to current node
				tempSortNode.next = curNode;
				//update current node to be the next unsorted item in our list
				curNode = prevNode.next;	
			}
			else{ //current Node is where it needs to be so progress through list normally
				prevNode = curNode;
				curNode = curNode.next;
			}
			curRelevance = 0;
		}
	}
	
}
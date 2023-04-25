/**
 * Static sort class as an option
 * @author  Klayr DeFelice, Ali Kadhim, Nate Baugher
 *
 */

package hungry_tiger_;
import java.util.ArrayList;
import java.util.HashMap;

public class Sort {
	//sorts restaurants by price
	public static RestaLinkedList sortByPrice(RestaLinkedList list) {
		
		RestaNode headCopy = list.gethead();
		RestaNode index = null;

		//MenuItemNode temp = head;

		if (list.gethead() == null) {
			return list;
		}
		else {
			while (headCopy != null) {

				index = headCopy.next;

				while (index != null) {

					if (headCopy.getplace().get_price_avrg() > index.getplace().get_price_avrg()) {//just using exchange here fixes the problem
						list.exchange(headCopy,index);
					}

					index = index.next;
				}
				headCopy = headCopy.next;
			}
		}
		return list;
		
	}
	//sorts menu items by price
	public static MenuItemLinkedList sortByPrice(MenuItemLinkedList list) {
		
		MenuItemNode headCopy = list.gethead();
		MenuItemNode index = null;

		//MenuItemNode temp = head;

		if (list.gethead() == null) {
			return list;
		}
		else {
			while (headCopy != null) {

				index = headCopy.next;

				while (index != null) {

					if (headCopy.getitem().get_price() > index.getitem().get_price()) {//just using exchange here fixes the problem
						list.exchange(headCopy,index);
					}

					index = index.next;
				}
				headCopy = headCopy.next;
			}
		}
		return list;
		
	}
	//sorts by the rev score of the rest's service 
	public static RestaLinkedList sortByReviewScoreServ(RestaLinkedList list) {
		RestaNode headCopy = list.gethead();
		RestaNode index = null;

		//double temp;

		if (list.gethead() == null) {
			return list;
		}
		else {
			while (headCopy != null) {

				index = headCopy.next;

				while (index != null) {

					if (headCopy.getplace().get_rest_service_rev_avrg() > index.getplace().get_rest_service_rev_avrg()) {//just using exchange here fixes the problem
						list.exchange(headCopy,index);
					}

					index = index.next;
				}
				headCopy = headCopy.next;
			}
		}
		return list;
	}
	//sorts by the average rev score of all menu items in restaurant
	public static RestaLinkedList sortByReviewScoreMIA(RestaLinkedList list) {
		RestaNode headCopy = list.gethead();
		RestaNode index = null;

		//double temp;

		if (list.gethead() == null) {
			return list;
		}
		else {
			while (headCopy != null) {

				index = headCopy.next;

				while (index != null) {

					if (headCopy.getplace().get_menu_item_rev_avrg() > index.getplace().get_menu_item_rev_avrg()) {//just using exchange here fixes the problem
						list.exchange(headCopy,index);
					}

					index = index.next;
				}
				headCopy = headCopy.next;
			}
		}
		return list;
	}
	//sorts menu items by review score 
	public static MenuItemLinkedList sortByReviewScore(MenuItemLinkedList list) {
		MenuItemNode headCopy = list.gethead();
		MenuItemNode index = null;

		//double temp;

		if (list.gethead() == null) {
			return list;
		}
		else {
			while (headCopy != null) {

				index = headCopy.next;

				while (index != null) {

					if (headCopy.getitem().get_rev() > index.getitem().get_rev()) {//just using exchange here fixes the problem
						list.exchange(headCopy,index);
					}

					index = index.next;
				}
				headCopy = headCopy.next;
			}
		}
		return list;
	}
	//sorts restaurants by relevance to arraylist of searchtags
	public static RestaLinkedList sortByRelevance(RestaLinkedList list, ArrayList<String> searchTags){		
		RestaNode curNode = list.gethead();
		//MenuItemNode prevNode = null;
		//MenuItemNode tempSortNode;
		HashMap<String, Boolean> userTags = new HashMap<>();
		for (int i = 0; i < searchTags.size(); i++){ //hash map yay! :D
			userTags.put(searchTags.get(i).toLowerCase(), true);
		}
		ArrayList<String> curNodeTags;

		int curRelevance = 0;
		while (curNode != null){ //loop through menu list
			curNodeTags = curNode.getplace().get_tags();
			for (int i = 0; i < curNodeTags.size(); i++){ //loop through tags of current node

				Boolean trueOrFalse = userTags.get((curNodeTags.get(i).toLowerCase()));
				if (trueOrFalse != null){ //current tag was found in hash map (common hash map w)
					curRelevance++;
				}
				
			}
			curNode.getplace().set_relevance(curRelevance);
			//prevNode = curNode;
			curNode = curNode.next;
			curRelevance = 0;
		}
		curNode = list.gethead();
		//prevNode = null;
		RestaNode headCopy = list.gethead();
		RestaNode index = null;

		//double temp;

		if (list.gethead() == null) {
			//System.out.println("oh no");
			return list;
		}
		else {
			while (headCopy != null) {

				index = headCopy.next;

				while (index != null) {

					if (headCopy.getplace().get_relevance() < index.getplace().get_relevance()) {
						list.exchange(headCopy,index); //theres a problem with restalinkedlist exchange?
					}

					index = index.next;
				}
				headCopy = headCopy.next;
			}
		}
		return list;
	}
	//sorts menu items by relevance to an arraylist of searchtags
	public static MenuItemLinkedList sortByRelevance(MenuItemLinkedList list, ArrayList<String> searchTags){		
		MenuItemNode curNode = list.gethead();
		//MenuItemNode prevNode = null;
		//MenuItemNode tempSortNode;
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
			//prevNode = curNode;
			curNode = curNode.next;
			curRelevance = 0;
		}
		curNode = list.gethead();
		//prevNode = null;
		MenuItemNode headCopy = list.gethead();
		MenuItemNode index = null;

		//double temp;

		if (list.gethead() == null) {
			return list;
		}
		else {
			while (headCopy != null) {

				index = headCopy.next;

				while (index != null) {

					if (headCopy.getitem().get_relevance() < index.getitem().get_relevance()) {
						list.exchange(headCopy,index);
					}

					index = index.next;
				}
				headCopy = headCopy.next;
			}
		}
		return list;
	}
}

/**
 * 2:45pm 4/24/2023
 * 
 * @author Klayr DeFelice
 */

package hungry_tiger_;
import java.util.ArrayList;
import java.util.Collections;

public class Search{
	//check if an ArrayList of strings contains any element of another ArrayList
	public static boolean contains(ArrayList<String> taglist1, ArrayList<String> taglist2) {
		if(taglist1.size()<1 || taglist2.size()<1) {
			return false;
		}
		if(!Collections.disjoint(taglist1, taglist2)) {
			return true;
		}
		return false;
	}
	//search a menuitemlinkedlist by tag, return a list of matching items
	public static MenuItemLinkedList search_by_tag(MenuItemLinkedList list, ArrayList<String> taglist) {
		if(taglist.size()<1) {
			return list;
		}
		MenuItemLinkedList newlist = new MenuItemLinkedList();
		MenuItemNode headcopy=list.gethead();
		int i=0;
		while(headcopy!=null) {
			if(contains(taglist,headcopy.getitem().get_tags())) {
				newlist.addNode(new MenuItemNode(i,headcopy.getitem()));
			}
			i++;
			headcopy=headcopy.next;
		}
		return newlist;
	}
	//search a restalinkedlist by tag, return a list of matching items
	public static RestaLinkedList search_by_tag(RestaLinkedList list, ArrayList<String> taglist) {
		if(taglist.size()<1) {
			return list;
		}
		RestaLinkedList newlist = new RestaLinkedList();
		RestaNode headcopy=list.gethead();
		int i=0;
		while(headcopy!=null) {
			if(contains(taglist,headcopy.getplace().get_tags())) {
				newlist.addNode(new RestaNode(i,headcopy.getplace()));
			}
			i++;
			headcopy=headcopy.next;
		}
		return newlist;
	}
	//search by tag and auto sort by relevance
	public static MenuItemLinkedList search_by_tagAS(MenuItemLinkedList list, ArrayList<String> taglist) {
		if(taglist.size()<1) {
			return list;
		}
		MenuItemLinkedList newlist = new MenuItemLinkedList();
		MenuItemNode headcopy=list.gethead();
		int i=0;
		while(headcopy!=null) {
			if(contains(taglist,headcopy.getitem().get_tags())) {
				newlist.addNode(new MenuItemNode(i,headcopy.getitem()));
			}
			i++;
			headcopy=headcopy.next;
		}
		newlist=Sort.sortByRelevance(newlist, taglist);
		return newlist;
	}
	//search a restalinkedlist by tag, return a list of matching items autosorted by relevance
	public static RestaLinkedList search_by_tagAS(RestaLinkedList list, ArrayList<String> taglist) {
		if(taglist.size()<1) {
			return list;
		}
		RestaLinkedList newlist = new RestaLinkedList();
		RestaNode headcopy=list.gethead();
		int i=0;
		while(headcopy!=null) {
			if(contains(taglist,headcopy.getplace().get_tags())) {
				newlist.addNode(new RestaNode(i,headcopy.getplace()));
			}
			i++;
			headcopy=headcopy.next;
		}
		newlist=Sort.sortByRelevance(newlist, taglist);
		return newlist;
	}
}

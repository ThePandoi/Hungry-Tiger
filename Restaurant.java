/*
 * 4/14/2023
 * 1:35 AM
 * 
 * Klayr DeFelice
 * 
 * 
 */


package hungry_tiger_;
import java.util.ArrayList;

public class Restaurant {
	//local obj variables
	private String name;
	private double price_avrg;
	private double menu_item_rev_avrg;
	private double rest_service_rev_avrg;
	private ArrayList<Review> rev_list;
	private ArrayList<String> tags;
	private ArrayList<Menu_Item> menu_items;
	private int relevance = 0;
	
	//instantiate restauant obj
	//first is the most common use, need to make rest b4 you can create each menuItem.
	public Restaurant(String name, double price_avrg, double menu_item_rev_avrg, double rest_service_rev_avrg, ArrayList<String> tags, ArrayList<Review> rev_list) {
		this.name=name;
		this.price_avrg=price_avrg;
		this.menu_item_rev_avrg=menu_item_rev_avrg;
		this.rest_service_rev_avrg=rest_service_rev_avrg;
		this.tags=tags;
		this.menu_items= new ArrayList<Menu_Item>();
		this.rev_list=rev_list;
	}
	public ArrayList<Review> get_rev_list(){
		return rev_list;
	}
	/*
	 * antiquated, do not use.
	public Restaurant(String name, double price_avrg, double menu_item_rev_avrg, double rest_service_rev_avrg, ArrayList<String> tags, ArrayList<Menu_Item> menu_items) {
		this.name=name;
		this.price_avrg=price_avrg;
		this.menu_item_rev_avrg=menu_item_rev_avrg;
		this.rest_service_rev_avrg=rest_service_rev_avrg;
		this.tags=tags;
		this.menu_items=menu_items;
	}*/
	//sets the relevance of a rest
	public void set_relevance(int relevance){
		this.relevance = relevance;
	}
	
	//gets the relevance of a rest
	public int get_relevance(){
		return relevance;
	}
	//returns the name of the rest
	public String get_name() {
		return this.name;
	}
	//manually set the name of the rest
	public void set_name(String name) {
		this.name=name;
	}
	//get the avrg price of menu items
	public double get_price_avrg() {
		return price_avrg;
	}
	//set avrg price of menu items (this is calculated from mi in the txt database,
	//highly unlikely you'll need to use this
	public void set_price_avrg(double price_avrg) {
		this.price_avrg=price_avrg;
	}
	//returns average rev score of menu items
	public double get_menu_item_rev_avrg() {
		return menu_item_rev_avrg;
	}
	//sets score (not likely to use, same reasoning as before)
	public void set_menu_item_rev_avrg(double menu_item_rev_avrg) {
		this.menu_item_rev_avrg=menu_item_rev_avrg;
	}
	//returns service rating of rest
	public double get_rest_service_rev_avrg() {
		return rest_service_rev_avrg;
	}
	//sets service rating
	public void set_rest_service_rev_avrg(double rest_service_rev_avrg) {
		this.rest_service_rev_avrg=rest_service_rev_avrg;
	}
	//returns String ArrayList of tags
	public ArrayList<String> get_tags(){
		return this.tags;
	}
	//sets String ArrayList of tags
	public void set_tags(ArrayList<String> tags) {
		this.tags=tags;
	}
	//manually add tags to the tags arraylist. again, probably not needed, but it's here anyway.
	public void add_tag(String tag) {
		this.tags.add(tag);
	}
	public ArrayList<Menu_Item> get_menu_items(){
		return this.menu_items;
	}
	//sets String ArrayList of tags
	public void set_menu_items(ArrayList<Menu_Item> menu_items) {
		this.menu_items=menu_items;
	}
	//manually add tags to the tags arraylist. again, probably not needed, but it's here anyway.
	public void add_menu_item(Menu_Item menu_item) {
		this.menu_items.add(menu_item);
	}
	/*Needed/W.I.P. Functionality
	 * --Integrate review obj in an obj array
	 * (store reviews associated with rest in one array, 
	 * revs for menu items will be stored with the menu items, but 
	 * direct fetch function from restaurant is in order.)
	 * 
	 * --get values for a menu item directly through rest functions
	 * (including individual tag names)
	 * 
	 * 
	 * 
	 *
	 */
	
	
	//testing in main function, basic examples for how methods work.
	
	/*
	public static void main(String[] args) {
		
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("Burger");
		tags.add("Fast");
		tags.add("Food");
		tags.add("Denney's");
		tags.add("Dinner");
		Restaurant r1 = new Restaurant("Denny's",4.50,3.2,1.3,tags);
		ArrayList<Menu_Item> menu_items = new ArrayList<Menu_Item>();
		
		ArrayList<String> itemtags1 = new ArrayList<String>();
		itemtags1.add("Burger");
		itemtags1.add("Cheese");
		itemtags1.add("Beef");
		itemtags1.add("Entree");
		Menu_Item i1 = new Menu_Item("Cheese Burger",7.45,4.0,itemtags1,r1);
		
		menu_items.add(i1);
		
		ArrayList<String> itemtags2 = new ArrayList<String>();
		itemtags2.add("Fries");
		itemtags2.add("Thick");
		itemtags2.add("Potato");
		itemtags2.add("Side");
		Menu_Item i2 = new Menu_Item("Fries",2.5,4.0,itemtags2,r1);
		menu_items.add(i2);
		
		ArrayList<String> itemtags3 = new ArrayList<String>();
		itemtags3.add("Baked");
		itemtags3.add("Creamy");
		itemtags3.add("Potato");
		itemtags3.add("Side");
		Menu_Item i3 = new Menu_Item("Baked Potato",2.5,4.0,itemtags3,r1);
		menu_items.add(i3);
		
		
		r1.add_menu_item(i1);
		r1.add_menu_item(i2);
		r1.add_menu_item(i3);
		r1.set_price_avrg((i1.get_price()+i2.get_price()+i3.get_price())/3);
		//r1.add_tag("Dinner");
		for(int i=0;i<r1.get_menu_items().size();i++) {
			System.out.println(r1.get_menu_items().get(i).get_name());
			for(int j=0;j<r1.get_menu_items().get(i).get_tags().size();j++) {
				System.out.println("-| "+r1.get_menu_items().get(i).get_tags().get(j));
			}
		}
		MenuItemNode head = new MenuItemNode(0,i1);
		MenuItemNode n = new MenuItemNode(1, i2);
		MenuItemNode n2 = new MenuItemNode(2,i3);
		MenuItemLinkedList ML1 = new MenuItemLinkedList(head);
		ML1.addNode(n);
		ML1.addNode(n2);
		//prints menu items with their price
		
		
		System.out.println(ML1.size());
		System.out.println(ML1.searchbyindex(1));
		for(int i=0;i<ML1.size();i++) {
			System.out.println(ML1.searchbyindex(i).getitem().get_price()+" | "+ML1.searchbyindex(i).getitem().get_name());
		}
		System.out.println("Sorted by price directly: ");
		ML1.sortByPrice(head);
		for(int i=0;i<ML1.size();i++) {
			System.out.println(ML1.searchbyindex(i).getitem().get_price()+" | "+ML1.searchbyindex(i).getitem().get_name());
		}
		System.out.println("Unsorted: ");
		ML1.exchange(head,n2);
		for(int i=0;i<ML1.size();i++) {
			System.out.println(ML1.searchbyindex(i).getitem().get_price()+" | "+ML1.searchbyindex(i).getitem().get_name());
		}
		System.out.println("Sorted by price static: ");
		ML1 = Sort.sortByPrice(ML1);
		for(int i=0;i<ML1.size();i++) {
			System.out.println(ML1.searchbyindex(i).getitem().get_price()+" | "+ML1.searchbyindex(i).getitem().get_name());
		}
		System.out.println("Unsorted: ");
		ML1.exchange(head,n2);
		for(int i=0;i<ML1.size();i++) {
			System.out.println(ML1.searchbyindex(i).getitem().get_price()+" | "+ML1.searchbyindex(i).getitem().get_name());
		}
		System.out.println();
		
		ArrayList<String> Searchtags = new ArrayList<String>();
		Searchtags.add("Baked");
		Searchtags.add("Potato");
		
		System.out.println("Sorted by relevance to search tags: ");
		Sort.sortByRelevance(ML1, Searchtags);
		for(int i=0;i<ML1.size();i++) {
			System.out.println(ML1.searchbyindex(i).getitem().get_relevance()+" | "+ML1.searchbyindex(i).getitem().get_name());
		}
		
		ArrayList<String> tags2 = new ArrayList<String>();
		tags2.add("Burger");
		tags2.add("Fast");
		tags2.add("Food");
		tags2.add("McDonalds");
		tags2.add("Big");
		tags2.add("Mac");
		tags2.add("Dinner");
		Restaurant r2 = new Restaurant("Mc Donalds",4.50,3.2,1.3,tags2);
		RestaNode rhead = new RestaNode(0,r1);
		RestaNode rn1 = new RestaNode(1,r2);
		RestaLinkedList RL1 = new RestaLinkedList(rhead);
		RL1.addNode(rn1);
		System.out.println("Unsorted: ");
		for(int i=0;i<RL1.size();i++) {
			System.out.println(RL1.searchbyindex(i).getplace().get_relevance()+" | "+RL1.searchbyindex(i).getplace().get_name());
		}
		
		ArrayList<String> searchtags2 = new ArrayList<String>();
		searchtags2.add("McDonalds");
		searchtags2.add("Burger");
		System.out.println("Place sorted by relevance: ");
		Sort.sortByRelevance(RL1, searchtags2);
		for(int i=0;i<RL1.size();i++) {
			System.out.println(RL1.searchbyindex(i).getplace().get_relevance()+" | "+RL1.searchbyindex(i).getplace().get_name());
		}
		
		//System.out.println("s");
		MenuItemLinkedList searchedML1 = Search.search_by_tag(ML1, Searchtags);
		System.out.println("Search: ");
		for(int i=0;i<searchedML1.size();i++) {
			System.out.println(searchedML1.searchbyindex(i).getitem().get_relevance()+" | "+searchedML1.searchbyindex(i).getitem().get_name());
		}
		
		
		Restaurant r2 = r1;
		Restaurant r3 = new Restaurant("Denny's",4.50,3.2,1.3,tags,menu_items);
		if (r2==r1) {
			System.out.println("ok refrence compare works");
		}
		if (r3==r1) {
			System.out.println("ok value compare works");
		}
	}*/
}

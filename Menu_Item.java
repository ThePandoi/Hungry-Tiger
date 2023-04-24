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

public class Menu_Item {
	//local obj variables
	private Restaurant place;
	private String name;
	private double price;
	private double rev;
	private ArrayList<String> tags;
	private int relevance = 0;
	private ArrayList<Review> rev_list;
	//instantiate Menu Item obj
		public Menu_Item(String name, double price, double rev, ArrayList<String> tags, Restaurant place, ArrayList<Review> rev_list) {
			this.name=name;
			this.price=price;
			this.rev=rev;
			this.tags=tags;
			this.place=place;
			this.rev_list=rev_list;
		}
		public Menu_Item(String name, double price, double rev, ArrayList<String> tags) {
			this.name=name;
			this.price=price;
			this.rev=rev;
			this.tags=tags;
			this.place=null;
			this.rev_list=null;
		}
		public ArrayList<Review> get_rev_list(){
			return rev_list;
		}
		public Restaurant get_place() {
			return this.place;
		}
		public String get_name() {
			return this.name;
		}
		//manually set the name
		public void set_name(String name) {
			this.name=name;
		}
		//get the price of menu item
		public double get_price() {
			return price;
		}
		
		public void set_price(double price) {
			this.price=price;
		}
		//returns rev score of menu items
		public double get_rev() {
			return this.rev;
		}
		//sets score (not likely to use, same reasoning as before)
		public void set_rev(double rev) {
			this.rev=rev;
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
		
		//sets the relevance of an item
		public void set_relevance(int relevance){
			this.relevance = relevance;
		}
		
		//gets the relevance of an item
		public int get_relevance(){
			return relevance;
		}
}

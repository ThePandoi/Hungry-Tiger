package hungry_tiger_;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void printRLL(RestaLinkedList list) {
		for(int i=0;i<list.size();i++) {
			String name=list.searchbyindex(i).getplace().get_name();
			double price_avrg=list.searchbyindex(i).getplace().get_price_avrg();
			double menu_item_rev_avrg=list.searchbyindex(i).getplace().get_menu_item_rev_avrg();
			double rest_service_rev_avrg=list.searchbyindex(i).getplace().get_rest_service_rev_avrg();
			ArrayList<Review> rev_list=list.searchbyindex(i).getplace().get_rev_list();
			//ArrayList<String> tags;
			//ArrayList<Menu_Item> menu_items;
			System.out.print("-----------------\n"+
							  i+" : \n"+
						      name+" | $"+price_avrg+"\n"+
						      "Food Score: "+menu_item_rev_avrg+"\n"+
						      "Service Score: "+rest_service_rev_avrg+"\n"+
						      "-----------------\n");
		}
	}
	public static void printMILL(MenuItemLinkedList list) {
		for(int i=0;i<list.size();i++) {
			String name=list.searchbyindex(i).getitem().get_name();
			double price=list.searchbyindex(i).getitem().get_price();
			double menu_item_rev=list.searchbyindex(i).getitem().get_rev();
			ArrayList<Review> rev_list=list.searchbyindex(i).getitem().get_rev_list();
			//ArrayList<String> tags;
			//ArrayList<Menu_Item> menu_items;
			System.out.print("-----------------\n"+
							  i+" : \n"+
						      name+" | $"+price+"\n"+
						      "Food Score: "+menu_item_rev+"\n"+
						      "-----------------\n");
		}
	}
	public static void main(String args[]) {
		RestaLinkedList RESTA_DATABASE=Load.load_restaurants();
		printRLL(RESTA_DATABASE);
		MenuItemLinkedList MENU_ITEM_DATABASE=Load.load_Menu_Items(RESTA_DATABASE);
		printMILL(MENU_ITEM_DATABASE);
		Scanner input = new Scanner(System.in);
		String choice = "";
		while (choice!="Quit"&&choice!="Q"&&choice!="q"&&choice!="quit"&&choice!="Exit"&&choice!="exit") {
			System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++\n"+
							 "Welcome to Hungry Tiger!\n"+
					         "----------------------------------------------------\n"+
							 "\n"+
					         "What would you like to do?\n"+
					         "----------------------------------------------------\n"+
					         "| 1 : Search Restaurants                           |\n"+
					         "| 2 : Search Menu Items                            |\n"+
					         "| 3 : Browse Restaurants                           |\n"+
					         "| 4 : Browse Menu Items                            |\n"+
					         "| 5 : Exit Program                                 |\n"+
					         "----------------------------------------------------\n");
			choice=input.nextLine();
			switch(choice) {
				case "1":
				case "Search Restaurants":
					
				case "2":
				
			}
		}
	}
}

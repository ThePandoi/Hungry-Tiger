package hungry_tiger_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void printRLL(RestaLinkedList list) {
		for(int i=0;i<list.size();i++) {
			String name=list.searchbyindex(i).getplace().get_name();
			double price_avrg=list.searchbyindex(i).getplace().get_price_avrg();
			double menu_item_rev_avrg=list.searchbyindex(i).getplace().get_menu_item_rev_avrg();
			double rest_service_rev_avrg=list.searchbyindex(i).getplace().get_rest_service_rev_avrg();
			//ArrayList<Review> rev_list=list.searchbyindex(i).getplace().get_rev_list();
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
			//ArrayList<Review> rev_list=list.searchbyindex(i).getitem().get_rev_list();
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
					         "| 5 : Exit                                         |\n"+
					         "----------------------------------------------------\n");
			choice=input.nextLine();
			switch(choice) {
				case "1":
				case "Search Restaurants":
					System.out.println("Input Restaurant Search: ");
					ArrayList<String> searchtags = new ArrayList<String>();
					
					choice=input.nextLine();
					searchtags.add(choice);
					searchtags.addAll(Arrays.asList(choice.split(" "))); //in case the search term is Big Mac, tags 
					RestaLinkedList result = Search.search_by_tagAS(RESTA_DATABASE, searchtags);
					if (result.size()<1) {
						System.out.println("Sorry, none found :^( ");
					}
					boolean insearchresults = true;
					while(insearchresults){
						printRLL(result);
						System.out.print(
						         "What would you like to do?\n"+
						         "----------------------------------------------------\n"+
						         "| 1 : Sort By Relevance                            |\n"+
						         "| 2 : Sort By Price                                |\n"+
						         "| 3 : Sort By Food Review Score                    |\n"+
						         "| 4 : Sort By Service Review Score                 |\n"+
						         "| 5 : return to main menu                          |\n"+
						         "----------------------------------------------------\n");
						choice=input.nextLine();
						switch(choice) {
							case "1" :
								result=Sort.sortByRelevance(result, searchtags);
								break;
							case "2" :
								result=Sort.sortByPrice(result);
								break;
							case "3" :
								result=Sort.sortByReviewScoreMIA(result);
								break;
							case "4" :
								result=Sort.sortByReviewScoreServ(result);
								break;
							case "5" :
								insearchresults=false;
						}
					}
					break;
				case "2":
				case "Search Menu Items":
					System.out.println("What are you hungry for? : ");
					ArrayList<String> searchtags2 = new ArrayList<String>();
					
					choice=input.nextLine();
					searchtags2.add(choice);
					searchtags2.addAll(Arrays.asList(choice.split(" "))); //in case the search term is Big Mac, tags 
					MenuItemLinkedList result2 = Search.search_by_tagAS(MENU_ITEM_DATABASE, searchtags2);
					if (result2.size()<1) {
						System.out.println("Sorry, none found :^( ");
					}
					boolean insearchresults2 = true;
					while(insearchresults2){
						printMILL(result2);
						System.out.print(
						         "What would you like to do?\n"+
						         "----------------------------------------------------\n"+
						         "| 1 : Sort By Relevance                            |\n"+
						         "| 2 : Sort By Price                                |\n"+
						         "| 3 : Sort By Food Review Score                    |\n"+
						         "| 4 : return to main menu                          |\n"+
						         "----------------------------------------------------\n");
						choice=input.nextLine();
						switch(choice) {
							case "1" :
								result2=Sort.sortByRelevance(result2, searchtags2);
								break;
							case "2" :
								result2=Sort.sortByPrice(result2);
								break;
							case "3" :
								result2=Sort.sortByReviewScore(result2);
								break;
							case "4" :
								insearchresults2=false;
						}
					}
					break;
				case "3":
				case "Browse Restaurants":
					boolean insearchresults3 = true;
					while(insearchresults3){
						printRLL(RESTA_DATABASE);
						System.out.print(
						         "What would you like to do?\n"+
						         "----------------------------------------------------\n"+
						         "| 1 : Sort By Price                                |\n"+
						         "| 2 : Sort By Food Review Score                    |\n"+
						         "| 3 : Sort By Service Review Score                 |\n"+
						         "| 4 : return to main menu                          |\n"+
						         "----------------------------------------------------\n");
						choice=input.nextLine();
						switch(choice) {
							case "1" :
								result=Sort.sortByPrice(RESTA_DATABASE);
								break;
							case "2" :
								result=Sort.sortByReviewScoreMIA(RESTA_DATABASE);
								break;
							case "3" :
								result=Sort.sortByReviewScoreServ(RESTA_DATABASE);
								break;
							case "4" :
								insearchresults3=false;
						}
					}
					break;
				case "4":
				case "Browse Menu Items":
					boolean insearchresults4 = true;
					while(insearchresults4){
						printMILL(MENU_ITEM_DATABASE);
						System.out.print(
						         "What would you like to do?\n"+
						         "----------------------------------------------------\n"+
						         "| 1 : Sort By Price                                |\n"+
						         "| 2 : Sort By Food Review Score                    |\n"+
						         "| 3 : return to main menu                          |\n"+
						         "----------------------------------------------------\n");
						choice=input.nextLine();
						switch(choice) {
							case "1" :
								result2=Sort.sortByPrice(MENU_ITEM_DATABASE);
								break;
							case "2" :
								result2=Sort.sortByReviewScore(MENU_ITEM_DATABASE);
								break;
							case "3" :
								insearchresults4=false;
						}
					}
					break;
				case "5":
				case "Exit": 
					choice="Quit";
			}
			if (choice!="Quit"&&choice!="Q"&&choice!="q"&&choice!="quit"&&choice!="Exit"&&choice!="exit") {
				choice=" ";
			}
		}
		input.close();
	}
}

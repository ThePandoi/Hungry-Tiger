package hungry_tiger_;
import java.io.*;  
import java.util.Scanner;
import java.util.ArrayList;
public class Load {
	public static RestaLinkedList load_restaurants() {
		RestaLinkedList list = new RestaLinkedList();
		try {
			File fin = new File("Database.txt");
			Scanner myReader = new Scanner(fin);
			int id=0; //id for each RestaNode
			String data = myReader.nextLine(); //skip first line
			while (myReader.hasNext()) {//start parsing doc
		        String tmpname = myReader.nextLine(); //save name of rest
		        double tmp_srv_rev = Double.parseDouble(myReader.nextLine()); //store srvc rev avrg
		        ArrayList<String> tmp_rest_tags = new ArrayList<String>(); //create new array list for rest tags
		        data = myReader.next();//skip line
		        data = myReader.nextLine();//load first tag and enter loop
		        do {
		        	//System.out.println(data);
		        	tmp_rest_tags.add(data);
		        	data = myReader.nextLine();
		        }while(!data.equals("#"));//load tags until # is reached
		        ArrayList<Review> tmp_rest_revs = new ArrayList<Review>();//new Array List of reviews
		        data = myReader.nextLine();//skip line
		        data = myReader.nextLine();//load first review 
		        do {
		        	String tmp_rev = data; //store rev string
		        	data = myReader.nextLine(); //load score
		        	double tmp_rev_scr = Double.parseDouble(data);//store score
		        	data = myReader.nextLine();//load next review string
		        	tmp_rest_revs.add(new Review(tmp_rev, tmp_rev_scr)); //add a new review object to the list
		        }while(!data.equals("#")); //repeat until reaches #
		        Restaurant resttmp = new Restaurant(tmpname,0, 0, tmp_srv_rev,tmp_rest_tags,tmp_rest_revs);
		        ArrayList<Menu_Item> items = new ArrayList<Menu_Item>();//new Array List of reviews
		        data = myReader.nextLine();//skip line
		        data = myReader.nextLine();//load first MenuItem name
		        do {
		        	String itemname = data; //store name string
		        	data = myReader.nextLine(); //load price
		        	double price = Double.parseDouble(data);//store price
		        	data = myReader.nextLine();//load avrg rev score
		        	double item_rev_scr =Double.parseDouble(data);
		        	data = myReader.nextLine();//skip line
		        	ArrayList<String> item_tags = new ArrayList<String>(); //create new array list for item tags
		        	data = myReader.nextLine();//load first tag
		        	do {
			        	item_tags.add(data);
			        	data = myReader.nextLine();
			        }while(!data.equals("@"));//load tags until @ is reached
		        	ArrayList<Review> item_revs = new ArrayList<Review>();//new Array List of reviews
		        	data = myReader.nextLine();//skip line
			        data = myReader.nextLine();//load first review
			        do {
			        	String tmp_rev = data; //store rev string
			        	data = myReader.nextLine(); //load score
			        	double tmp_rev_scr = Double.parseDouble(data);//store score
			        	data = myReader.nextLine();//load next review string
			        	item_revs.add(new Review(tmp_rev, tmp_rev_scr)); //add a new review object to the list
			        }while(!data.equals("@")); //repeat until reaches #
			        data = myReader.nextLine();//load next menu item name
			        //construct menu item
			        Menu_Item item = new Menu_Item(itemname, price, item_rev_scr, item_tags, resttmp, item_revs);
			        items.add(item);
			        
		        }while(!data.equals("#")); //repeat until reaches #
		        resttmp.set_menu_items(items);
		        RestaNode rn = new RestaNode(id,resttmp);
		        list.addNode(rn);
		        id++;
		        //data = myReader.nextLine(); //skip first line
		        
		    }
		} catch (FileNotFoundException e) {
			System.out.println("ERROR LOADING FILE");
			e.printStackTrace();
		}
		
		return list;
	}
	public static MenuItemLinkedList load_Menu_Items(RestaLinkedList rl) {
		MenuItemLinkedList list = new MenuItemLinkedList();
		if(rl.size()==0) {
			return list;
		}
		int n=0;
		for(int i=0;i<rl.size();i++) {
			for(int j=0;j<rl.searchbyindex(i).getplace().get_menu_items().size();j++) {
				MenuItemNode itemN=new MenuItemNode(n,rl.searchbyindex(i).getplace().get_menu_items().get(j));
				list.addNode(itemN);
				n++;
			}
		}
		return list;
	}
}

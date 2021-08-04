import java.util.ArrayList;
<<<<<<< HEAD

import com.sun.tools.corba.se.idl.toJavaPortable.Helper;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		itemList.add(new Item("Macbook", "Used Macbook, in good condition", 1500.0, "12/9/2021 - 15/10/2021", 15));
		
		int option = 0;
		
		while (option != 5) {
			
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				//view all items
				C206_CaseStudy.viewAllItem(itemList);
			}
			else if (option == 2) {
				//add an item
				Item item = inputItem();
				C206_CaseStudy.addItem(itemList, item);
			}
			else if (option == 3) {
				//delete an item
				C206_CaseStudy.viewAllItem(itemList);
				String name = Helper.readString("Enter item name to delete > ");
				boolean deleteResult = C206_CaseStudy.deleteItem(itemList, name);
				if (deleteResult==true) {
					System.out.println("Item successfully deleted.");
				}
				else {
					System.out.println("Item does not exist.");
				}
			}
		}
		
	}
	
	public static String retrieveAllItem(ArrayList<Item> itemList) {
		String output = "";
		
		for (int i = 0; i< itemList.size(); i++) {
			int itemNum = i+1;
			output += String.format("%-10d %-20s %-35s $%-15.2f %-25s $%-15d\n", 
					itemNum,
					itemList.get(i).getName(),
					itemList.get(i).getDescription(), 
					itemList.get(i).getMinimumBid(),
					itemList.get(i).getDate(),
					itemList.get(i).getIncrement());
		}
		
		return output;
	}
	
	public static void viewAllItem(ArrayList<Item> itemList) {
		String output = String.format("%-10s %-20s %-35s %-15s %-25s %-15s\n", 
				"ITEM NO.",
				"NAME", 
				"DESCRIPTION",
				"MINIMUM BID", 
				"AUCTION DATE",
				"BID INCREMENT");
		 output += retrieveAllItem(itemList);	
		System.out.println(output);
	}
	
	public static Item inputItem() {
		String name = Helper.readString("Enter name > ");
		String description = Helper.readString("Enter description > ");
		double minimumBid = Helper.readDouble("Enter minimum bid price > ");
		String date = Helper.readString("Enter auction date (DD/MM/YYYY - DD/MM/YYYY)) > ");
		int increment = Helper.readInt("Enter bid increment > ");
		
		Item item = new Item(name, description, minimumBid, date, increment);
		return item;
	}


	public static Deal inputDeal() {
		String tag = Helper.readString("Enter asset tag > ");
		String description = Helper.readString("Enter description > ");
		int zoom = Helper.readInt("Enter optical zoom > ");

		Deal item = new Deal(tag, description, zoom);
		return item;
		
	}
	public static void addDeal(ArrayList<Deal> dealList, Deal item) {
		
		dealList.add(item);
		System.out.println("Deal added");
	}
	
	public void RetrieveAllDeals() {
		

	public static void addItem(ArrayList<Item> itemList, Item item) {
		itemList.add(item);
		System.out.println("Item added successfully!");
	}
	
	public static boolean deleteItem(ArrayList<Item> itemList, String name) {
		boolean isDelete = false;
		for (int i = 0; i<itemList.size(); i++) {
			if (itemList.get(i).getName().equalsIgnoreCase(name)) {
				isDelete = true;
				itemList.remove(i);
				break;
			}
		}
		return isDelete;
	}
}

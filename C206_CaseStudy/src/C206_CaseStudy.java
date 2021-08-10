import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 6;
	public static void main(String[] args) {
//----------------------------------User, Jovi --------------------------------
		ArrayList<userAccount> uAList = new ArrayList<userAccount>();
		
		uAList.add(new userAccount("Sandra", "Seller", "12345678", "SandraaaT@gmail.com"));
		uAList.add(new userAccount("Jay", "Seller", "98765432", "JayP456@gmail.com"));
//-----------------------------------------------------------------------------
//---------------------Category, Cassandra ------------------------------------
		ArrayList<Category> categoryList = new ArrayList<Category>();
		 
		categoryList.add(new Category("Jewellery"));
		categoryList.add(new Category("Books"));
//------------------------------------------------------------------------------
//-------------------------------Item, Ariqah-----------------------------------
        ArrayList<Item> itemList = new ArrayList<Item>();
		
		itemList.add(new Item("Macbook", "Used Macbook, in good condition", 1500.0, "12/9/2021", "15/10/2021", 15));
//------------------------------------------------------------------------------
//-------------------------------Bid, Halimah-----------------------------------
        ArrayList<Bid> bidList = new ArrayList<Bid>();
		
		bidList.add(new Bid(1, "Acer Laptop", "seller@gmail.com", "buyer@gmail.com", "2021-12-31",70));
		bidList.add(new Bid(2, "Lenovo Laptop", "seller2@gmail.com", "buyer2@gmail.com", "2021-12-31", 65));
//------------------------------------------------------------------------------
//-------------------------------Deal, Xin Yi-----------------------------------
		ArrayList<Deal> dealList = new ArrayList<Deal>();
		
		dealList.add(new Deal(1,"Apple Macbook", 123, "buyer@gmail.com", "seller@gmail.com", "10/08/2021"));
	    dealList.add(new Deal(2,"Apple Iphone", 123, "buyer@gmail.com", "seller@gmail.com", "10/08/2021"));
//------------------------------------------------------------------------------
		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				int uAOption = -1;
				while (uAOption != 4) {
					C206_CaseStudy.uAMenu();
					uAOption = Helper.readInt("Enter an option > ");
					if (uAOption == 1) {
						// View all items
						C206_CaseStudy.viewAllUserAccount(uAList);  					
					} else if (uAOption == 2) {
						// Add a new item
						C206_CaseStudy.setHeader("ADD User Account");			
						userAccount uA = inputUserAccount();
						boolean isValid = C206_CaseStudy.checkAddUserAccount(uA);
						if (isValid == true) {
							C206_CaseStudy.addUserAccount(uAList, uA);
						} else {
							System.out.println("Please enter all required details3");
						}

					}else if (uAOption == 3) {
						C206_CaseStudy.setHeader("Delete Account");	
						C206_CaseStudy.retrieveAllUserAccount(uAList);
						C206_CaseStudy.deleteUserAccount(uAList);
								
					}else if (uAOption != 4){
						System.out.println("Invalid option");
					}
				}
					System.out.println("You have exited the User Account Menu");
			
					
			} else if (option == 2) {
				int choice = -1;
				while (choice != 4) {
					C206_CaseStudy.categoryMenu();
					choice = Helper.readInt("Please enter an option > ");
					
					if (choice == 1) {
						C206_CaseStudy.setHeader("View Category");
						C206_CaseStudy.viewAllCategory(categoryList);
						
					} else if (choice == 2) {
						C206_CaseStudy.setHeader("Add Category");
						Category name = inputCategory();
						boolean isValid = C206_CaseStudy.isValid(name);
						if (isValid == true) {
							C206_CaseStudy.addCategory(categoryList, name);
						}else {
							System.out.println("Please enter a valid name!");
						}
						
						
					} else if (choice == 3) {
						C206_CaseStudy.setHeader("Delete Category");
						C206_CaseStudy.viewAllCategory(categoryList);
						C206_CaseStudy.deleteCategory(categoryList);
						
					} else if (choice != 4){
						System.out.println("Invalid Option");
					}
				}
				
				System.out.println("You have exited the Category Menu");

			} else if (option == 3) {
				int itemOption = -1;
				while (itemOption != 4) {
					C206_CaseStudy.itemMenu();
					itemOption = Helper.readInt("Enter an option > ");
					if (itemOption == 1) {
						//view all items
						C206_CaseStudy.viewAllItem(itemList);
					}
					else if (itemOption == 2) {
						//add an item
						Item item = inputItem();
						boolean isValid = C206_CaseStudy.checkInputItem(item);
						if (isValid == true) {
							C206_CaseStudy.addItem(itemList, item);
						}
						else {
							System.out.println("Invalid item details entered.");
						}
					}
					else if (itemOption == 3) {
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
					} else if (itemOption != 4) {
						System.out.println("Invalid option");	
					}
				}
				
				System.out.println("You have exited the Item Menu");			
				
			} else if (option == 4) {
				int bidOption = -1;
				while (bidOption != 4) {
					C206_CaseStudy.bidMenu();
					bidOption = Helper.readInt("Enter an option > ");
					
					if (bidOption == 1) {
						//show all bid transactions
						C206_CaseStudy.retrieveAllBids(bidList);
			
					} else if (bidOption == 2) {
						//add bid transaction
						Bid b1 = inputBid();
						C206_CaseStudy.addBid(bidList, b1);
						
					} else if (bidOption == 3) {
						//Delete bid transaction
						C206_CaseStudy.retrieveAllBids(bidList);
						int id = Helper.readInt("Enter bid ID > ");				
						boolean deleteResult = C206_CaseStudy.deleteBid(bidList, id);
						
						if(deleteResult == true) {
							System.out.println("Bid transaction successfully deleted");
						} else {
							System.out.println("Bid transaction does not exist");
						}
						
					} else if (bidOption != 4){
						System.out.println("Invalid option");
						
					}
					
				}
				
				System.out.println("You have exited the Bid Menu");
				
			} else if (option == 5) {
				int dealOpt = -1;
				while (dealOpt != 4) {
					C206_CaseStudy.dealMenu();
					dealOpt = Helper.readInt("Please enter an option > ");
					
					if (dealOpt == 1) {
						C206_CaseStudy.viewAllDeals(dealList);
												
					} else if (dealOpt == 2) {
						Deal deal = inputDeal();
						C206_CaseStudy.addDeal(dealList, deal);
						
					} else if (dealOpt == 3) {
						int deleteID = deleteID();
						Boolean isDeleted = deleteDeal(dealList, deleteID);
						
						if (isDeleted == true) {
							System.out.println("Deal ID:" + deleteID + " is Deleted Successfully");
						} else {
							System.out.println("Deal ID:" + deleteID + " Does Not Exist");
						}
						
					} else if (dealOpt != 4){
						System.out.println("Invalid Option");
					}
				}
				
				System.out.println("You have exited the Deal Menu");	
				
			}else if (option == 6) {
				System.out.println("Goodbye!");
				
			} else {
				System.out.println("Invalid option");
			}

		}
	}
//--------------Commonly use method, Cassandra----------------------
	public static void menu() {
		C206_CaseStudy.setHeader("AUCTION APP");
		System.out.println("1. User account");
		System.out.println("2. Category");
		System.out.println("3. Item");
		System.out.println("4. Bid");
		System.out.println("5. Deal");
		System.out.println("6. Quit");
		Helper.line(80, "-");

	}
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
//------------------------------------------------------------------------------
//----------------------------------User, Jovi ---------------------------------
	public static void uAMenu() {
		C206_CaseStudy.setHeader("USER ACCOUNT MENU");
		System.out.println("1. View all User Account");
		System.out.println("2. Add User Account");
		System.out.println("3. Delete User Account");
		System.out.println("4. Quit");
	}
	//================================= Option 1 View items (CRUD- Read) =================================
	public static String retrieveAllUserAccount (ArrayList<userAccount> uAList) {
		String output = "";

		for (int i = 0; i < uAList.size(); i++) {

			output += String.format("%-10s %-10s %-10s %-20s\n", uAList.get(i).getName(),
					//C206_CaseStudy.showAvailability(camcorderList.get(i).getIsAvailable()),
					uAList.get(i).getRole(),uAList.get(i).getPassword(),uAList.get(i).getEmail());
		}
		return output;
	}
	public static void viewAllUserAccount(ArrayList<userAccount> uAList) {
		C206_CaseStudy.setHeader("User Account List");
		String output = String.format("%-10s %-10s %-10s %-20s\n", "Name",
				"Role","Password", "Email");
		 output += retrieveAllUserAccount(uAList);	
		System.out.println(output);
	}


	//================================= Option 2 Add an item (CRUD - Create) =================================
	public static userAccount inputUserAccount() {
		String name = Helper.readString("Enter Name > ");
		String password = Helper.readString("Enter Password > ");
		String role = Helper.readString("Enter your Role > ");
		String email = Helper.readString("Enter your Email > ");

		userAccount uA = new userAccount(name, role, password,email);
		return uA;
		
	}
	
	//check Add User Account
	public static boolean checkAddUserAccount(userAccount uA) {
		boolean isValid = false;
		if (uA.getName().length() != 0 && uA.getPassword().length() != 0 && uA.getRole().length() != 0 && uA.getEmail().length() != 0 ) {
		isValid = true;
		
		}
		
		return isValid;
	}
	
	public static void addUserAccount(ArrayList<userAccount> uAList, userAccount uA) {
		
		uAList.add(uA);
		System.out.println("User Account added");
	}
	
	//================================= Option 3 Delete an item (CRUD - Delete) =================================
	public static boolean doDeleteUserAccount(ArrayList<userAccount> uAList, String name) {
		
		boolean isDeleted = false;

		for (int i = 0; i <uAList.size(); i++) {
			if (name.equalsIgnoreCase(uAList.get(i).getName()) && uAList.get(i).getIsAvailable() == true) {
				
				uAList.get(i).setAvailable(false);
				uAList.remove(i);
				
				isDeleted = true;
				
				
			}
		}
		return isDeleted;
	}
	 public static void deleteUserAccount(ArrayList<userAccount> uAList) {
		C206_CaseStudy.viewAllUserAccount(uAList);
		String name = Helper.readString("Enter name > ");
		Boolean isDeleted = doDeleteUserAccount(uAList,name);
		if (isDeleted == false) {
			System.out.println("Invalid User Account");
		} else {
			System.out.println("User Account " + name + " is deleted ");
		}
	}

//------------------------------------------------------------------------------
//-----------------------------Category, Cassandra------------------------------
	 public static void categoryMenu() {
			C206_CaseStudy.setHeader("CATEGORY MENU");
			System.out.println("1. View All Categories");
			System.out.println("2. Add Category");
			System.out.println("3. Delete Category");
			System.out.println("4. Quit");
		}
	//================================= Option 1 View category (CRUD- Read) =================================
	public static String retrieveAllCategory(ArrayList<Category> categoryList) {
		String output = "";

		for (int i = 0; i < categoryList.size(); i++) {
			output += String.format("%-10s\n",categoryList.get(i).getName());
		}
		return output;
	}
	public static void viewAllCategory(ArrayList<Category> categoryList) {
		C206_CaseStudy.setHeader("CATEGORY LIST");
		//String output = String.format("%-10s \n", "NAME");
		String output = retrieveAllCategory(categoryList);	
		System.out.println(output);
	}
	
	//================================= Option 2 Add category (CRUD- Read) =================================
	public static Category inputCategory() {
		String name = Helper.readString("Enter name > ");

		Category C= new Category(name);
		return C;
		
	}
	public static boolean isValid(Category C) {
		boolean isValid = false;
		if (C.getName().length()!=0) {
		isValid = true;	
		}
		
		return isValid;
	}
	public static void addCategory(ArrayList<Category> categoryList, Category C) {
		
		categoryList.add(C);
		System.out.println("Category added");
		
	}
	
	//================================= Option 3 Delete category (CRUD- Read) =================================
	public static boolean doDeleteCategory(ArrayList<Category> categoryList, String name) {
		
		boolean isDeleted = false;
		

		for (int i = 0; i < categoryList.size(); i++) {
			String CName = categoryList.get(i).getName();
			if (name.equalsIgnoreCase(CName)&& categoryList.get(i).isAvailable() == true) {
				
				categoryList.get(i).setAvailable(false);
				categoryList.remove(i);
				isDeleted = true;
				
			}
		}
		return isDeleted;
	}
	public static void deleteCategory(ArrayList<Category> categoryList) {
		C206_CaseStudy.viewAllCategory(categoryList);
		String name = Helper.readString("Enter name > ");
		Boolean isDeleted =doDeleteCategory(categoryList, name);
		if (isDeleted == false) {
			System.out.println("Invalid category name");
		} else {
			System.out.println("Category " + name + " is deleted successfully"); 
		}
	}
//------------------------------------------------------------------------------	
//-------------------------------Item, Ariqah-----------------------------------
	public static void itemMenu() {
		C206_CaseStudy.setHeader("ITEM MENU");
		System.out.println("1. View all Item");
		System.out.println("2. Add Item");
		System.out.println("3. Delete Item");
		System.out.println("4. Quit");
	}
	
	public static String retrieveAllItem(ArrayList<Item> itemList) {
		String output = "";
		
		for (int i = 0; i< itemList.size(); i++) {
			int itemNum = i+1;
			output += String.format("%-10d %-20s %-35s $%-15.2f %-20s %-20s $%-15d\n", 
					itemNum,
					itemList.get(i).getName(),
					itemList.get(i).getDescription(), 
					itemList.get(i).getMinimumBid(),
					itemList.get(i).getStartDate(),
					itemList.get(i).getEndDate(),
					itemList.get(i).getIncrement());
		}
		
		return output;
	}
	
	public static void viewAllItem(ArrayList<Item> itemList) {
		String output = String.format("%-10s %-20s %-35s %-15s %-20s %-20s %-15s\n", 
				"ITEM NO.",
				"NAME", 
				"DESCRIPTION",
				"MINIMUM BID", 
				"AUCTION START DATE",
				"AUCTION END DATE",
				"BID INCREMENT");
		 output += retrieveAllItem(itemList);	
		System.out.println(output);
	}
	
	public static Item inputItem() {
		
		String name = Helper.readString("Enter name > ");
		String description = Helper.readString("Enter description > ");
		double minimumBid = Helper.readDouble("Enter minimum bid price (min. $5) > $");
		String startDate = Helper.readString("Enter auction start date (DD/MM/YYYY) > ");
		String endDate = Helper.readString("Enter auction end date (DD/MM/YYYY) > ");
		int increment = Helper.readInt("Enter bid increment (min. $1) > $");
		
		Item item = new Item(name, description, minimumBid, startDate, endDate, increment);
		return item;
	}
	
	public static boolean checkInputItem(Item item) {
		boolean isValid = false;
		if (item.getName().length()!=0 && item.getDescription().length()!=0 && item.getMinimumBid()>=5 && item.getStartDate().length()!=0 && item.getEndDate().length()!=0 && item.getIncrement()!=0) {
			isValid = true;
		}
		
		
		return isValid;
	}

	public static void addItem(ArrayList<Item> itemList, Item item) {
		itemList.add(item);
		C206_CaseStudy.setHeader("Item added successfully!");
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

//------------------------------------------------------------------------------
//-------------------------------Bid, Halimah-----------------------------------
	public static void bidMenu() {
		C206_CaseStudy.setHeader("BID MENU");
		System.out.println("1. View all Bid");
		System.out.println("2. Add Bid");
		System.out.println("3. Delete Bid");
		System.out.println("4. Quit");
	}
	
	public static Bid inputBid() {
		int id = Helper.readInt("Enter bid ID > ");
		String name = Helper.readString("Enter bid item name > ");
		String sellerEmail = Helper.readString("Enter seller Email > ");
		String buyerEmail = Helper.readString("Enter buyer Email > ");
		String endDate = Helper.readString("Enter end date > ");
		int price = Helper.readInt("Enter price > $");
		
		Bid b1 = new Bid (id,name,sellerEmail,buyerEmail,endDate,price);
		return b1;
	}
	
	public static void addBid(ArrayList<Bid> bidList, Bid b1) {
		bidList.add(b1);
		System.out.println("Bid transactions added successfully!");
	}
	
	public static String retrieveAllBids(ArrayList<Bid> bidList) {
		String output = "";
		
		for (int i = 0; i < bidList.size(); i++) {
			output += String.format("%-10d %-20s %-20s %-20s %-20s %-10d\n", bidList.get(i).getId(), bidList.get(i).getName(), 
					bidList.get(i).getSellerEmail(), bidList.get(i).getBuyerEmail(), bidList.get(i).getEndDate(), bidList.get(i).getPrice());
		}
		return output;
	}
	
	public static void viewAllBids(ArrayList<Bid> bidList) {
		C206_CaseStudy.setHeader("BidList");
		String output = String.format("%-10s %-20s %-20s %-20s %-20s %-10s\n", 
				"Bid ID", "Name", "Seller Email", "Buyer Email", "End Date", "Price");
		
		output += retrieveAllBids(bidList);
		System.out.println(output);
	}
	
	public static boolean deleteBid(ArrayList<Bid> bidList, int id) {
		
		boolean isDelete = false;
		
		for (int i = 0; i < bidList.size(); i++) {
			if (id == (bidList.get(i).getId())) {
				
				isDelete = true;
				bidList.remove(i);
			}
		} return isDelete;
	}
//------------------------------------------------------------------------------
//-------------------------------Deal, Xin Yi-----------------------------------
	//===== DEAL MENU =====
		public static void dealMenu() {
			C206_CaseStudy.setHeader("DEAL MENU");
			System.out.println("1. View All Deals");
			System.out.println("2. Add Deal");		
			System.out.println("3. Delete Deal");
			System.out.println("4. Quit");
		}
		
		//===== ADD DEAL=====
		public static Deal inputDeal() {
			int dealID = Helper.readInt("Enter deal ID > ");
			String item = Helper.readString("Enter item > ");
			
			
			//Checks item name for null
			while (item.length()==0) { 
				System.out.println("**Do Not Leave The Item Field Empty** \n");
				item = Helper.readString("Enter item > ");
			} 	
			
			double price = Helper.readDouble("Enter transaction price > ");
			String buyerEmail = Helper.readString("Enter buyer email (example@email.com) > ");
			
			
			//Checks buyer email for null
			while (buyerEmail.length()==0 || !buyerEmail.contains("@") || !buyerEmail.contains(".com")) {
				if (buyerEmail.length()==0) {
					System.out.println("**Do Not Leave The Buyer Email Field Empty** \n");
					
				} else if (!buyerEmail.contains("@") || !buyerEmail.contains(".com")) {
					System.out.println("**Invalid email address**");
					
				}
				
				buyerEmail = Helper.readString("Enter buyer email (example@email.com) > ");
			} 
			
			String sellerEmail = Helper.readString("Enter seller email (example@email.com) > ");
			
			
			//Checks seller email for null
			while (sellerEmail.length()==0 || !sellerEmail.contains("@") || !sellerEmail.contains(".com")) {
				if (sellerEmail.length()==0) {
					System.out.println("**Do Not Leave The Seller Email Field Empty** \n");
					
				} else if (!sellerEmail.contains("@") || !sellerEmail.contains(".com")) {
					System.out.println("**Invalid email address**");
					
				}			

				sellerEmail = Helper.readString("Enter seller email (example@email.com) > ");
			} 
			
			String date = Helper.readString("Enter closing date (DD-MM-YYYY) > ");
			
			
			//Checks closing date for null
			while (date.length()!=10) {
				System.out.println("**Do Not Leave The Date Field Empty** \n");
				date = Helper.readString("Enter closing date (DD-MM-YYYY) > ");
			} 
			
			
			Deal deal = new Deal(dealID, item, price, buyerEmail, sellerEmail, date);
			return deal;
		}
		
		
		public static void addDeal(ArrayList<Deal> dealList, Deal deal) {
			
			dealList.add(deal);
			System.out.println("Deal added");
		}
		
		
		//=====VIEW ALL DEALS=====
		public static String retrieveAllDeals(ArrayList<Deal> dealList) {
			String output = "";

			for (int i = 0; i < dealList.size(); i++) {

				output += String.format("%-5d %-25s %-10.2f %-25s %-25s %-35s\n", dealList.get(i).getDealID(),
						dealList.get(i).getItem(), dealList.get(i).getPrice(), 
						dealList.get(i).getBuyerEmail(), dealList.get(i).getSellerEmail(), 
						dealList.get(i).getCloseDate());
			}
			return output;
		}
		
		public static void viewAllDeals(ArrayList<Deal> dealList) {
			
			C206_CaseStudy.setHeader("DEALS LIST");
			String output = String.format("%-5s %-25s %-10s %-25s %-25s %-10s\n", "ID", "ITEM", "PRICE",
					"BUYER EMAIL", "SELLER EMAIL", "CLOSE DATE");
			 output += retrieveAllDeals(dealList);
			System.out.println(output);
		}

		
		//=====DELETE DEAL=====
		private static int deleteID() {
			int dealID = Helper.readInt("Enter deal ID > ");
			return dealID;
		}
		
		public static boolean deleteDeal(ArrayList<Deal> dealList, int dealID) {
			Boolean isDeleted = false;
			
			for (int i = 0; i < dealList.size(); i++) {
				if (dealList.get(i).getDealID() == dealID) {
					dealList.remove(i);
					
					isDeleted = true;
					
					break;
				}
			}
			return isDeleted;
			
		}

	  
//------------------------------------------------------------------------------
}


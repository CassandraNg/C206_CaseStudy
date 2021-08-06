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
//------------------------------------------------------------------------------
//-------------------------------Deal, Xin Yi-----------------------------------
//------------------------------------------------------------------------------
		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				System.out.println("1. View all User Account");
				System.out.println("2. Add User Account");
				System.out.println("3. Delete User Account");
				System.out.println("4. Quit");
				option = Helper.readInt("Enter an option > ");
				if (option == 1) {
					// View all items
					C206_CaseStudy.viewAllUserAccount(uAList);  					
				} else if (option == 2) {
					// Add a new item
					C206_CaseStudy.setHeader("ADD User Account");			
					userAccount uA = inputUserAccount();
					boolean isValid = C206_CaseStudy.checkAddUserAccount(uA);
					if (isValid == true) {
						C206_CaseStudy.addUserAccount(uAList, uA);
					} else {
						System.out.println("Please enter all required details3");
					}

				}else if (option == 3) {
					C206_CaseStudy.setHeader("Delete Account");	
					C206_CaseStudy.retrieveAllUserAccount(uAList);
					C206_CaseStudy.deleteUserAccount(uAList);
							
				}else if (option == 4){
					System.out.println("Bye!");
				} else {
					System.out.println("Invalid option");
				}
					
			} else if (option == 2) {
				System.out.println("1. View all Category");
				System.out.println("2. Add category");
				System.out.println("3. Delete category");
				System.out.println("4. Quit");
				int choice = Helper.readInt("Enter an option > ");
				if (choice == 1) {
					C206_CaseStudy.setHeader("View Category");
					C206_CaseStudy.viewAllCategory(categoryList);
				}else if (choice == 2) {
					C206_CaseStudy.setHeader("Add Category");
					Category name = inputCategory();
					C206_CaseStudy.addCategory(categoryList, name);
				}else if (choice == 3) {
					C206_CaseStudy.setHeader("Delete Category");
					C206_CaseStudy.viewAllCategory(categoryList);
					C206_CaseStudy.deleteCategory(categoryList);
				}else if (choice == 4){
					System.out.println("Quit");
				}else {
					System.out.println("Invalid option");
				}

			} else if (option == 3) {
				System.out.println("1. View all Item");
				System.out.println("2. Add Item");
				System.out.println("3. Delete Item");
				System.out.println("4. Quit");
				option = Helper.readInt("Enter an option > ");
				if (option == 1) {
					//view all items
					C206_CaseStudy.viewAllItem(itemList);
				}
				else if (option == 2) {
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
				} else if (option == 4) {
					System.out.println("Bye!");
					
				} else {
					System.out.println("Invalid option");
				}						
			} else if (option == 4) {
				System.out.println("1. View all Bid");
				System.out.println("2. Add Bid");
				System.out.println("3. Delete Bid");
				System.out.println("4. Quit");
				
				

			} else if (option == 5) {
				
				
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
	//================================= Option 1 View category (CRUD- Read) =================================
	public static String retrieveAllCategory(ArrayList<Category> categoryList) {
		String output = "";

		for (int i = 0; i < categoryList.size(); i++) {
			output += String.format("%-10s\n", categoryList.get(i).getName());
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
			System.out.println("Category " + name + " is deleted"); 
		}
	}
//------------------------------------------------------------------------------	
//-------------------------------Item, Ariqah-----------------------------------
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
//------------------------------------------------------------------------------
//-------------------------------Deal, Xin Yi-----------------------------------
//------------------------------------------------------------------------------
}


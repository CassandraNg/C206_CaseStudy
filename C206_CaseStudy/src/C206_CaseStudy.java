import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Category> categoryList = new ArrayList<Category>();
		
		categoryList.add(new Category("Jewellery"));
		categoryList.add(new Category("Books"));
		
		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				
				

			} else if (option == 2) {
				
				

			} else if (option == 3) {
				
				

			} else if (option == 4) {
				
				

			} else if (option == 5) {
				
				
			}else if (option == 6) {
				System.out.println("Goodbye!");
				
			} else {
				System.out.println("Invalid option");
			}

		}		
		

	}
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
	public static String retrieveAllCategory(ArrayList<Category> categoryList) {
		String output = "";

		for (int i = 0; i < categoryList.size(); i++) {

	
			output += String.format("%-10s\n", categoryList.get(i).getName());
		}
		return output;
	}
	public static void viewAllCategory(ArrayList<Category> categoryList) {
		C206_CaseStudy.setHeader("CATEGORY LIST");
		String output = String.format("%-10s \n", "NAME");
		 output += retrieveAllCategory(categoryList);	
		System.out.println(output);
	}
	
	
	public static Category inputCategory() {
		String name = Helper.readString("Enter name > ");

		Category C= new Category(name);
		return C;
		
	}
	public static void addCategory(ArrayList<Category> categoryList, Category C) {
		
		categoryList.add(C);
		System.out.println("Category added");
	}
	
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


}

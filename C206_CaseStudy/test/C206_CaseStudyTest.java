import static org.junit.Assert.*;
import java.util.ArrayList;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
//-----------User, Jovi------------------
	private userAccount uA1;
	private userAccount uA2;
	private userAccount uA3;
	
	private ArrayList<userAccount> uAList;
//----------------------------------------
//-----------Category, Cassandra----------
	private Category C1;
	private Category C2;
	
	private ArrayList<Category> categoryList;
//----------------------------------------
//---------------Item, Ariqah-------------
	private Item item1;
	private Item item2;
	private Item item3;
	
	private ArrayList<Item> itemList;
//----------------------------------------
//---------------Bid, Halimah-------------
	private Bid b1;
	private Bid b2;
	
	private ArrayList<Bid> bidList;
//----------------------------------------
//---------------Deal, Xin Yi-------------
//----------------------------------------	
	public C206_CaseStudyTest() {
		 
		super();
	}

@Before
	public void setUp() throws Exception {
//-----------User, Jovi-------------------
	uAList = new ArrayList<userAccount>();
	
	uA1 = new userAccount("Sandra", "Seller", "12345678", "SandraaaT@gmail.com");
	uA2 = new userAccount("Jay", "Seller", "98765432", "JayP456@gmail.com");
	uA3 = new userAccount("Jovi", "", "23456789", "");
//----------------------------------------
//-----------Category, Cassandra----------
	C1 = new Category("Jewellery");
	C2 = new Category("Books");
	
	categoryList= new ArrayList<Category>();
//------------------------------------------
//---------------Item, Ariqah---------------
	item1 = new Item("Apple Macbook", "Used Macbook, in good condition", 1500.0, "12/9/2021", "15/10/2021",2);
	item2 = new Item("Apple Iphone XS Max", "Unused Iphone XS Max", 2700.0, "21/01/2021", "15/02/2021",2);
	item3 = new Item("Apple Iphone XR", "", 5, "", "", 1);
	
	itemList = new ArrayList<Item>();	
//------------------------------------------
//---------------Bid, Halimah---------------
	bidList = new ArrayList<Bid>();
	
	b1 = new Bid(1, "Acer Laptop", "seller@gmail.com", "buyer@gmail.com", "2021-12-31", 70);
	b2 = new Bid(2, "Lenovo Laptop", "seller2@gmail.com", "buyer2@gmail.com", "2021-12-31", 65);
//------------------------------------------
//---------------Deal, Xin Yi---------------
//------------------------------------------
	}
//---------------------------User, Jovi--------------------------------------------------
@Test
public void testAdduserAccount() {
	// Item list is not null, so that can add a new item
	assertNotNull("Test if there is valid User Account arraylist to add to", uAList);
	
	//Given an empty list, after adding 1 item, the size of the list is 1
	C206_CaseStudy.addUserAccount(uAList, uA1);		
	assertEquals("Test if that User Account arraylist size is 1?", 1, uAList.size());
	
	//The item just added is as same as the first item of the list
	assertSame("Test that Camcorder is added same as 1st item of the list?", uA1, uAList.get(0));
	
	//Add another item. test The size of the list is 2?
	C206_CaseStudy.addUserAccount(uAList, uA2);
	assertEquals("Test that User Account arraylist size is 2?", 2, uAList.size());
} 

@Test
public void testRetrieveAllUserAccount() {
	// Test if Item list is not null but empty, so that can add a new item
	assertNotNull(uAList);
	//test if the list of userAccount retrieved from the SourceCentre is empty
			//String allUserAccount= C206_CaseStudy.retrieveAllUserAccount(uAList);
			//String testOutput = "";
			//assertEquals("Check that ViewAllUserAccountlist", testOutput, allUserAccount);
			
	//Given an empty list, after adding 2 items, test if the size of the list is 2
	C206_CaseStudy.addUserAccount(uAList, uA1);
	C206_CaseStudy.addUserAccount(uAList, uA2);
	assertEquals("Test if that UserAccount arraylist size is 2?", 2, uAList.size());
	
	//test if the expected output string same as the list of userAccount retrieved from the SourceCentre
	String allUserAccount= C206_CaseStudy.retrieveAllUserAccount(uAList);
	String testOutput = String.format("%-10s %-10s %-10s %-20s\n","Sandra", "Seller", "12345678", "SandraaaT@gmail.com");
	 testOutput += String.format("%-10s %-10s %-10s %-20s\n","Jay", "Seller", "98765432", "JayP456@gmail.com");

	assertEquals("Check that ViewAllUserAccountlist", testOutput, allUserAccount);
	
}

@Test
public void testCheckUserAccount() {
	//check user account 1 & 2; if all required details are entered
	assertTrue(C206_CaseStudy.checkAddUserAccount(uA1));
	assertTrue(C206_CaseStudy.checkAddUserAccount(uA2));
	
   //check new user account is invalid, miss out requirement
	assertFalse(C206_CaseStudy.checkAddUserAccount(uA3));
}


@Test
public void testDeleteUserAccount() {
	
	
	C206_CaseStudy.addUserAccount(uAList, uA1); //add user Account
	assertEquals(1,uAList.size());
	C206_CaseStudy.doDeleteUserAccount(uAList, "Sandra");
	
}

//---------------------------------------------------------------------------------------
//------------------------Category, Cassandra---------------------------------------------
@Test
	public void testAddCategory() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Category arraylist to add to", categoryList);
		assertEquals("Test if that categoryTest arraylist is 0?", 0, categoryList.size());
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addCategory(categoryList, C1);		
		assertEquals("Test if that Category arraylist size is 1?", 1, categoryList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Category is added same as 1st item of the list?", C1, categoryList.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addCategory(categoryList, C2);
		assertEquals("Test that Category arraylist size is 2?", 2, categoryList.size());
		assertSame("Test that Category is added same as 1st item of the list?", C2, categoryList.get(1));
	}
	@Test
	public void testRetrieveAllCategory() {
		//fail("Not yet implemented");
		// write your code here
		// Test if Item list is not null but empty, so that can add a new item
				assertNotNull("Test if there is valid Category arraylist to add to", categoryList);
				
				//test if the list of Category retrieved from the StudyCase is empty
						String allCategory= C206_CaseStudy.retrieveAllCategory(categoryList);
						String testOutput = "";
						assertEquals("Check that ViewAllCategoryList", testOutput, allCategory);
						
				//Given an empty list, after adding 2 items, test if the size of the list is 2
				C206_CaseStudy.addCategory(categoryList, C1);
				C206_CaseStudy.addCategory(categoryList, C2);
				assertEquals("Test if that Category arraylist size is 2?", 2, categoryList.size());
				
				//test if the expected output string same as the list of Category retrieved from the StudyCase
				allCategory= C206_CaseStudy.retrieveAllCategory(categoryList);

				testOutput = String.format("%-10s\n","Jewellery");
				testOutput += String.format("%-10s\n","Books");
			
				assertEquals("Check that ViewAllCategoryList", testOutput, allCategory);
	}
	@Test
	public void testDoDeleteCategory() {
		//fail("Not yet implemented");
		// write your code here
		
		C206_CaseStudy.addCategory(categoryList,C1);
		assertTrue(categoryList.get(0).isAvailable());
		C206_CaseStudy.doDeleteCategory(categoryList, "Jewellery");
		
		System.out.println("aft delete " + categoryList.get(0).isAvailable());
		
		assertFalse(categoryList.get(0).isAvailable());
	}
//------------------------------------------------------------------------------------
//----------------------------------Item, Ariqah--------------------------------------
	@Test
	public void testAddItem() {
		
		// item list exists, is not null, so that can add a new item
		assertNotNull("Test if there is valid Item arraylist to add to", itemList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addItem(itemList, item1); 
		assertEquals("Test if that Item arraylist size is 1", 1, itemList.size());
				
		//The item just added is as same as the first item of the list
		assertSame("Test that Item is added same as 1st item of the list", item1, itemList.get(0));
			
		//Add another item; test list size is 2
		C206_CaseStudy.addItem(itemList, item2); //java method
		assertEquals("Test if that Item arraylist size is 2", 2, itemList.size());
		
		//The second item added is the same as the second item of the list
		assertSame("Test that 2nd Item added is same as 2nd item of the list", item2, itemList.get(1));
		
	}
	
	@Test
	public void testRetrieveAllItem() {
		
		//test if list not null 
		assertNotNull(itemList);
		
		//test that list empty since haven't add items
		String allItem = C206_CaseStudy.retrieveAllItem(itemList);
		String output = "";
		assertEquals("Check that item list is empty",output, allItem);
				
		//since empty, add 2 items, and check list size is 2
		C206_CaseStudy.addItem(itemList, item1);
		C206_CaseStudy.addItem(itemList, item2);
		assertEquals("Test if that Item arraylist size is 2", 2, itemList.size());
		
		//test if the expected output string same as the list of items retrieved 
		allItem = C206_CaseStudy.retrieveAllItem(itemList);

		output = String.format("%-10d %-20s %-35s $%-15.2f %-20s %-20s $%-15d\n",1,"Apple Macbook", "Used Macbook, in good condition", 1500.0, "12/9/2021", "15/10/2021",2);
		output += String.format("%-10d %-20s %-35s $%-15.2f %-20s %-20s $%-15d\n",2,"Apple Iphone XS Max", "Unused Iphone XS Max", 2700.0, "21/01/2021" , "15/02/2021",2);
					
		assertEquals(output, allItem);
				
				
	}
	
	@Test
	public void testDeleteItem() {
		// item list exists, is not null, so that can add a new item
		assertNotNull("Test if there is valid Item arraylist to add to", itemList);
				
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addItem(itemList, item1); 
		assertEquals("Test if that Item arraylist size is 1", 1, itemList.size());
					
		//add another item, list size 2
		C206_CaseStudy.addItem(itemList, item2);			
		assertEquals("Test if that Item arraylist size is 2", 2, itemList.size());
		
		//delete first item of list
		C206_CaseStudy.deleteItem(itemList, item1.getName());
		
		//check list size back to 1 after delete an item
		assertEquals("Test if that Item arraylist size is 1", 1, itemList.size());
		
		//check that initially second item now changed to first
		assertSame("Test that the initial 2nd item changed to 1st item of the list", item2, itemList.get(0));

	
	}
	
	@Test
	public void testCheckInputItem() { //method returns boolean
		
		//check item 1 and 2 valid; all their required details were entered
		assertTrue(C206_CaseStudy.checkInputItem(item1));
		assertTrue(C206_CaseStudy.checkInputItem(item2));
		
		//Check item 3 is invalid; missed out required fields
		assertFalse(C206_CaseStudy.checkInputItem(item3));
		
	}

//------------------------------------------------------------------------------------
//----------------------------------Bid, Halimah--------------------------------------
	@Test
	public void testAddBid() {
		assertNotNull(bidList);  //list not null
		
		C206_CaseStudy.addBid(bidList,b1); //add b1 to list
		assertEquals(1,bidList.size()); //check list size = 1 after adding b1
		
		assertSame(b1, bidList.get(0)); //check b1 = 1st bid in list
		
		C206_CaseStudy.addBid(bidList,b2); //add b2 to list
		assertEquals(2,bidList.size());  //check list size = 2 after adding b2
		
		assertSame(b2, bidList.get(1));   //check b2 = 2nd bid in list
	}
	
	@Test
	public void testShowBid() {
		assertNotNull(bidList); //list not null
		
		String allBid = C206_CaseStudy.retrieveAllBids(bidList);
		String testOutput = "";
		assertEquals(testOutput,allBid);  //check bidList retrieved from C206_CaseStudy is empty
		
		C206_CaseStudy.addBid(bidList,b1);  
		C206_CaseStudy.addBid(bidList,b2);
		assertEquals(2,bidList.size());  //check bidList size = 2, after adding 2 b1 & b2
		
		allBid = C206_CaseStudy.retrieveAllBids(bidList);  
		testOutput = String.format("%-10d %-20s %-20s %-20s %-20s %-10d\n", 1, "Acer Laptop", "seller@gmail.com", "buyer@gmail.com", "2021-12-31", 70);
		testOutput += String.format("%-10d %-20s %-20s %-20s %-20s %-10d\n", 2, "Lenovo Laptop", "seller2@gmail.com", "buyer2@gmail.com", "2021-12-31", 65);
		assertEquals(testOutput,allBid);  //check expected output = bidList retrieved from C206_CaseStudy
	}
	
	@Test
	public void testDeleteBid() {
		assertNotNull(bidList);  //check bidList not null
		
		C206_CaseStudy.addBid(bidList,b1);  //add b1 to bidList
		assertEquals(1,bidList.size());  //check bidList size = 1, after adding b1
		
		C206_CaseStudy.deleteBid(bidList,b1.getId());  //delete b1 from bidList
		assertEquals(0,bidList.size());  //check list size = 0, after deleting b1
	}
//------------------------------------------------------------------------------------
//----------------------------------Deal, Xin Yi--------------------------------------
//------------------------------------------------------------------------------------
	@After
	public void tearDown() throws Exception {
//------User , Jovi--------
		uA1 = null;
		uA2 = null;
		uAList = null;
//-------------------------
//---Category, Cassandra---
		C1 = null;
		C2 = null;
		categoryList = null;
//-------------------------
//---Category, Cassandra---
		item1 = null;
		item2 = null;
		item3 = null;
		itemList = null;
//-------------------------
//------Bid, Halimah-------
		b1 = null;
		b2 = null;
		bidList = null;
//------------------------
	}
	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}


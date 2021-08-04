import static org.junit.Assert.*;
import java.util.ArrayList;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Category C1;
	private Category C2;
	private ArrayList<Category> categoryList;
	
	public C206_CaseStudyTest() {
		 
		super();
	}

	private Item item1;
	private Item item2;
	
	private ArrayList<Item> itemList;
	
	@Before
	public void setUp() throws Exception {
//<<<<<<< HEAD
		C1 = new Category("Jewellery");
		C2 = new Category("Books");
//=======
		//prepare Test Data
		item1 = new Item("Apple Macbook", "Used Macbook, in good condition", 1500.0, "12/9/21 - 15/10/21",2);
		item2 = new Item("Apple Iphone XS Max", "Unused Iphone XS Max", 2700.0, "21/01/21 - 15/02/21",2);
		itemList = new ArrayList<Item>();
		
	//}
//>>>>>>> branch 'master' of https://github.com/CassandraNg/C206_CaseStudy

		categoryList= new ArrayList<Category>();
		
	}
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
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddDeal() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void testRetrieveAllDeals() {
		
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

	public void testAddItem() {
		
		// item list exists, is not null, so that can add a new item
		assertNotNull("Test if there is valid Item arraylist to add to", itemList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addItem(itemList, item1); //java method
		assertEquals("Test if that Item arraylist size is 1", 1, itemList.size());
				
		//The item just added is as same as the first item of the list
		assertSame("Test that Item is added same as 1st item of the list", item1, itemList.get(0));
			
		//Add another item; test list size is 2
		C206_CaseStudy.addItem(itemList, item2); //java method
		assertEquals("Test if that Item arraylist size is 2", 2, itemList.size());
		
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
		
		output = String.format("%-10d %-20s %-35s $%-15.2f %-25s $%-15d\n",1,"Apple Macbook", "Used Macbook, in good condition", 1500.0, "12/9/21 - 15/10/21",2);
		output += String.format("%-10d %-20s %-35s $%-15.2f %-25s $%-15d\n",2,"Apple Iphone XS Max", "Unused Iphone XS Max", 2700.0, "21/01/21 - 15/02/21",2);
					
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
}

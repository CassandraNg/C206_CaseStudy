import static org.junit.Assert.*;

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

	@Before
	public void setUp() throws Exception {
		C1 = new Category("Jewellery");
		C2 = new Category("Books");

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
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}

package com.dev.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dev.shoppingbackend.dao.CategoryDAO;
import com.dev.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.dev.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory(){
		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is the description for Mobile.");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added category inside the table",true,categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory(){
		category = categoryDAO.get(3);
		assertEquals("Successfully fetched category from the table! ","Laptop",category.getName());
	}*/
	
	/*@Test 
	public void testUpdateCategory(){
		category = categoryDAO.get(3);
		category.setName("Dell Laptop");
		assertEquals("Successfully updated a single category in the table! ",true,categoryDAO.update(category));
	}*/
	
	// Deleted means Active flag as false not delete any record from database
	/*@Test 
	public void testDeleteCategory(){
		category = categoryDAO.get(3);
		assertEquals("Successfully deleted a single category from the table! ",true,categoryDAO.delete(category));
	}*/
	
	// List of Categiries
	/*@Test 
	public void testListCategory(){
		assertEquals("Successfully fetched the List of  category from the table! ",3, categoryDAO.list().size());
	}*/
	
	// All CRUD Operation goes here
	@Test
	public void testCRUDRepository(){
		
		// Add Operation.
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is the description for Laptop!!");
		category.setImageURL("CAT_1.png");
		assertEquals("Successfully added category inside the table",true,categoryDAO.add(category));
		
		/*category = new Category();
		category.setName("Television");
		category.setDescription("This is the description for Television!!");
		category.setImageURL("CAT_2.png");
		assertEquals("Successfully added category inside the table",true,categoryDAO.add(category));
		
		// fetching and updating the category
		category = categoryDAO.get(2);
		category.setName("Dell Laptop");
		assertEquals("Successfully updated a single category in the table! ",true,categoryDAO.update(category));
		
		// delete the category
		assertEquals("Successfully deleted a single category from the table! ",true,categoryDAO.delete(category));
		
		// fetching the list
		assertEquals("Successfully fetched the List of  category from the table! ",1, categoryDAO.list().size());*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

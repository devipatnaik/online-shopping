package com.dev.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dev.shoppingbackend.dao.UserDAO;
import com.dev.shoppingbackend.dto.Address;
import com.dev.shoppingbackend.dto.Cart;
import com.dev.shoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private static User user = null;
	private static Address address = null;
	private static Cart cart = null;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.dev.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void testAdd(){
		
		user = new User();
		user.setFirstName("Sujata");
		user.setLastName("Patnaik");
		user.setEmail("sujatapatnaik@gmail.com");
		user.setContactNumber("9937379074");
		user.setRole("USER");
		user.setPassword("sujata");
		
		// add the user
		assertEquals("Failed to Add User!", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("#861,4th Floor,4th Main Cross");
		address.setAddressLineTwo("Chodeswari Layout,Tulasi Theater Road,");
		address.setCity("Banglore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("560037");
		address.setBilling(true);
		
		// link the user with the address using user id
		address.setUserId(user.getId());
		
		// add the Address
		assertEquals("Failed to Add Address!", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")){
			
			// create a cart for this user
			cart = new Cart();
			//cart.setUserId(user.getId());  // Linking Cart with UserId
			cart.setUser(user);
			
			// add the Cart
			assertEquals("Failed to Add Cart!", true, userDAO.addCart(cart));
			
			// add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("#861,4th Floor,4th Main Cross");
			address.setAddressLineTwo("Chodeswari Layout,Tulasi Theater Road,");
			address.setCity("Banglore");
			address.setState("Karnataka");
			address.setCountry("India");
			address.setPostalCode("560037");
			// set shipping to true here
			address.setShipping(true);
			
			// link it with the user
			address.setUserId(user.getId());
			
			// add the Shipping Address
			assertEquals("Failed to Add Shipping Address!", true, userDAO.addAddress(address));
		}
	}

}

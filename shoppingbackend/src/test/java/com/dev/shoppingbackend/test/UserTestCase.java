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
	
	/*@Test
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
			
			 create a cart for this user
			 * Linking Cart with UserId 
			
			cart = new Cart();
			//cart.setUserId(user.getId()); 
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
	}*/
	
	/*@Test
	public void testAdd(){
		
		user = new User();
		user.setFirstName("Sonam");
		user.setLastName("Kapoor");
		user.setEmail("sonam.kapoor@gmail.com");
		user.setContactNumber("9884545212");
		user.setRole("USER");
		user.setPassword("sonam");
		
		if(user.getRole().equals("USER")){
			
			// create a cart for this User
			cart = new Cart();
			cart.setUser(user);
			
			// attach Cart with User
			user.setCart(cart);
		}
		
		// add the user
		assertEquals("Failed to Add User!", true, userDAO.addUser(user));
	}*/
	
	/*@Test
	public void testUpdateCart(){
		// fetch User by its email
		user = userDAO.getByEmail("sonam.kapoor@gmail.com");
		
		// get the Cart of the User
		cart = user.getCart();
		
		cart.setGrandTotal(4999);
		cart.setCartLines(2);
		
		assertEquals("Failed to Update the Cart!", true, userDAO.updateCart(cart));
	}*/
	
	/*@Test
	public void testAddAddress(){
		
		// we need to Add an User
		user = new User();
		user.setFirstName("Sujata");
		user.setLastName("Patnaik");
		user.setEmail("sujatapatnaik@gmail.com");
		user.setContactNumber("9937379074");
		user.setRole("USER");
		user.setPassword("sujata");
		
		// add the user
		assertEquals("Failed to Add User!", true, userDAO.addUser(user));
		
		// we are going to add the Address
		address = new Address();
		address.setAddressLineOne("#861,4th Floor,4th Main Cross");
		address.setAddressLineTwo("Chodeswari Layout,Tulasi Theater Road,");
		address.setCity("Banglore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("560037");
		address.setBilling(true);
		
		// attached the user to the address
		address.setUser(user);
		
		assertEquals("Failed to Add the Address!", true, userDAO.addAddress(address));
		
		// we are also going to add the shipping Address
		address = new Address();
		address.setAddressLineOne("#861,4th Floor,4th Main Cross");
		address.setAddressLineTwo("Chodeswari Layout,Tulasi Theater Road,");
		address.setCity("Banglore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("560037");
		// set shipping to true here
		address.setShipping(true);
		
		// attached the User to the Address
		address.setUser(user);
		
		// add the Shipping Address
		assertEquals("Failed to Add Shipping Address!", true, userDAO.addAddress(address));
	}*/
	
	/* Adding Address to the User for UniDirectional */
	/*@Test
	public void testAddAddress(){
		
		user = userDAO.getByEmail("sujatapatnaik@gmail.com");

		
		// we are also going to add the shipping Address
		address = new Address();
		address.setAddressLineOne("Jagannatha Colony");
		address.setAddressLineTwo("Budharaja, Main Road");
		address.setCity("Sambalpur");
		address.setState("Odisha");
		address.setCountry("India");
		address.setPostalCode("768004");
		// set shipping to true here
		address.setShipping(true);
				
		// attached the User to the Address
		address.setUserId(user.getId());
		// address.setUser(user);
				
		// add the Shipping Address
		assertEquals("Failed to Add Shipping Address!", true, userDAO.addAddress(address));
	}*/
	
	/* Fetch the List of Address */
	@Test
	public void testGetAddress(){
		
		user = userDAO.getByEmail("sujatapatnaik@gmail.com");
		
		/*
		 * Added By : Devi Patnaik, Date : 13/10/2018 time: 08:54 PM
		 * 
		 * This below Print Statement belongs to the User only,
		 * In UserDAO class, if the blow Abstract Methods are enable(i.e Uncommented).
		 * 
		 * 	Address getBillingAddress(User user);
		 *  List<Address> listShippingAddress(User user);
		 *  
		 *  Then the below statement will work and Test Case will run successfully!!!!
		 * 
		   assertEquals("Failed to fetch the List of Address and size does not match!", 2, userDAO.listShippingAddress(user).size());
		   assertEquals("Failed to fetch the List of Billing Address and size does not match!", "Banglore", userDAO.getBillingAddress(user).getCity());
		   
		 */
		
		/* This below Print Statement belongs to the userId only to increase the performance of application */
		
		assertEquals("Failed to fetch the List of Address and size does not match!", 2, userDAO.listShippingAddress(14).size());
		
		assertEquals("Failed to fetch the List of Billing Address and size does not match!", "Banglore", userDAO.getBillingAddress(14).getCity());
		
	}

}

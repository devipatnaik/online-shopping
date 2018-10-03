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
		
		cart.setGrandTotal(5555);
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
	
	/*@Test
	public void testAddAddress(){
		
		user = userDAO.getByEmail("sonam.kapoor@gmail.com");	
		
		// we are also going to add the shipping Address
		address = new Address();
		address.setAddressLineOne("SEZ Campus");
		address.setAddressLineTwo("ELCOT main Road");
		address.setCity("Chennai");
		address.setState("Tamilnadu");
		address.setCountry("India");
		address.setPostalCode("600119");
		// set shipping to true here
		address.setShipping(true);
				
		// attached the User to the Address
		address.setUser(user);
				
		// add the Shipping Address
		assertEquals("Failed to Add Shipping Address!", true, userDAO.addAddress(address));
	}*/
	
	// JUnit Test Not Run successfully
	@Test
	public void testGetAddress(){
		user = userDAO.getByEmail("sonam.kapoor@gmail.com");
		
		assertEquals("Failed to fetch the List of Address and size does not match!", 1, userDAO.listShippingAddress(user).size());
		
		assertEquals("Failed to fetch the List of Billing Address and size does not match!", "Banglore", userDAO.getBillingAddress(user).getCity());
		
	}

}

package com.dev.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dev.shoppingbackend.dao.CartLineDAO;
import com.dev.shoppingbackend.dao.ProductDAO;
import com.dev.shoppingbackend.dao.UserDAO;
import com.dev.shoppingbackend.dto.Cart;
import com.dev.shoppingbackend.dto.CartLine;
import com.dev.shoppingbackend.dto.Product;
import com.dev.shoppingbackend.dto.User;

public class CartLineTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	private Product product = null;
	private Cart cart = null;
	private User user = null;
	private CartLine cartLine = null;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.dev.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
		System.out.println("upto here fine===========");
		cartLineDAO =  (CartLineDAO)context.getBean("cartLineDAO");
		
	}
	
	@Test
	public void testAddNewCartLine(){
		
		// 1. get the User
		user = userDAO.getByEmail("kamal.patnaik@gmail.com");
		
		// 2. fetch the Cart
		cart = user.getCart();
		
		// 3. get the Product
		product = productDAO.get(1);
		
		// 4. create a new cartline
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		
		cartLine.setAvailable(true);
		
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertEquals("Failed to Add the CArt Line", true, cartLineDAO.add(cartLine));
		
		
		// update the Cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		assertEquals("Failed to Update the CArt Line", true, cartLineDAO.updateCart(cart));
		
		
		
	}

}

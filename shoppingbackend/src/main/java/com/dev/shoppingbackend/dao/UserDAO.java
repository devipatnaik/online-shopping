package com.dev.shoppingbackend.dao;

import java.util.List;

import com.dev.shoppingbackend.dto.Address;
import com.dev.shoppingbackend.dto.Cart;
import com.dev.shoppingbackend.dto.User;

public interface UserDAO {
	
	// Add an User
	boolean addUser(User user);
	User getByEmail(String email);
	
	// Add an Address
	boolean addAddress(Address address);
	
	// Alternative bcoz many tables records are printing in console which i don't like.
	// Address getBillingAddress(int userId);
	// List<Address> listShippingAddress(int userid);
	
	
	//Address getBillingAddress(User user);
	//List<Address> listShippingAddress(User user);
	
	// add the cart
	//boolean addCart(Cart cart);
	
	// Update the Cart
	boolean updateCart(Cart cart);

}

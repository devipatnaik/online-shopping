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
	
	// Alternative, because many tables records are printing in console which i don't like.
	// Address getBillingAddress(User user);
	// List<Address> listShippingAddress(User user);
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
	
	
	// add the cart
	// boolean addCart(Cart cart);
	
	// Update the cart
	boolean updateCart(Cart cart);
	
}

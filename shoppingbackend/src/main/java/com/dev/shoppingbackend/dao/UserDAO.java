package com.dev.shoppingbackend.dao;

import java.util.List;

import com.dev.shoppingbackend.dto.Address;
import com.dev.shoppingbackend.dto.User;

public interface UserDAO {
	
	// Add an User (or) User Related Operation
	boolean addUser(User user);
	User getByEmail(String email);
	
	User get(int id);
	
	
	// Add an Address
	// Adding and Updating a new Address
	boolean addAddress(Address address);
	Address getAddress(int addressId);
	boolean updateAddress(Address address);
	
	// Alternative, because many tables records are printing in console which i don't like and performance will be fast.
	Address getBillingAddress(int userId);
	List<Address> listShippingAddress(int userId);
	
	//Address getBillingAddress(User user);
	//List<Address> listShippingAddress(User user);
	
	// add the cart
	// boolean addCart(Cart cart);
	
	/*Moved this abstract method to CartLineDAO.java */
	// Update the cart
	//boolean updateCart(Cart cart);
	
}

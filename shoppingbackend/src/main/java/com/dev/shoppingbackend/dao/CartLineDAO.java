package com.dev.shoppingbackend.dao;

import java.util.List;

import com.dev.shoppingbackend.dto.Cart;
import com.dev.shoppingbackend.dto.CartLine;

public interface CartLineDAO {
	
	// common methods
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	// other business methods related to the Cart Lines
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	// Update the Cart
	boolean updateCart(Cart cart);
}

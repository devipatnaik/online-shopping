package com.dev.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dev.shoppingbackend.dao.CartLineDAO;
import com.dev.shoppingbackend.dto.Cart;
import com.dev.shoppingbackend.dto.CartLine;

public class CartLineDAOImpl implements CartLineDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CartLine get(int id) {
		return sessionFactory.getCurrentSession().get(CartLine.class, id);
	}

	@Override
	public boolean add(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().update(cartLine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().delete(cartLine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CartLine> list(int cartId) {
		String query = "from CartLine where cartId = :cartId";
		return sessionFactory.getCurrentSession()
				.createQuery(query, CartLine.class)
					.setParameter("cartId", cartId)
						.getResultList();
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		String query = "from CartLine WHERE cartId = :cartId AND available = :available";
		return sessionFactory.getCurrentSession()
				.createQuery(query, CartLine.class)
					.setParameter("cartId", cartId)
					.setParameter("available", true)
						.getResultList();
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String query = "from CartLine WHERE cartId = :cartId AND product.id = :productId";
		
		try{
		return sessionFactory.getCurrentSession()
				.createQuery(query, CartLine.class)
					.setParameter("cartId", cartId)
					.setParameter("productId", productId)
						.getSingleResult();
		}catch(Exception e){
			return null;
		}
	}
	
	/* this method is related to the Cart */
	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	

}
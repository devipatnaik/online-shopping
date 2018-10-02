package com.dev.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.shoppingbackend.dao.UserDAO;
import com.dev.shoppingbackend.dto.Address;
import com.dev.shoppingbackend.dto.Cart;
import com.dev.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean addCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/*
	 * As soon as i add a user and the role of the User is USER the Cart should Generate Automatically
	 * This is the Functionality of addCart() function.*/
	
	/*@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}*/

	/*@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		
		try {
			return sessionFactory.getCurrentSession()
						.createQuery(selectQuery, User.class)
							.setParameter("email", email)
								.getSingleResult();
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}
	}*/

	/*@Override
	public Address getBillingAddress(User user) {
		
		String selectQuery = "FROM Address WHERE user = :user AND billing = :billing";
		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
						.setParameter("user", user)
						.setParameter("billing", true)
							.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/

	/*@Override
	public List<Address> listShippingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND shipping = :shipping";
		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
						.setParameter("user", user)
						.setParameter("shipping", true)
							.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/

}

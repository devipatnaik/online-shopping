package com.dev.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.shoppingbackend.dao.ProductDAO;
import com.dev.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Single Product
	 * */
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * LIST
	 * */
	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product", Product.class)
						.getResultList();
		
	}
	/*
	 * INSERT Operation
	 * */
	@Override
	public boolean add(Product product) {
		try {
			sessionFactory
				.getCurrentSession()
					.persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * UPDATE Operation
	 * */
	@Override
	public boolean update(Product product) {
		try {
			sessionFactory
				.getCurrentSession()
					.update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * DELETE Operation
	 * */
	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			// call the update method
			return this.update(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProduct = "FROM Product WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProduct, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductByCategory, Product.class)
						.setParameter("active", true)
							.setParameter("categoryId", categoryId)
								.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
								.setMaxResults(count)
									.getResultList();
	}

}

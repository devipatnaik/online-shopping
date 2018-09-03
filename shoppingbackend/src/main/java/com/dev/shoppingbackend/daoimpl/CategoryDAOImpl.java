package com.dev.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.shoppingbackend.dao.CategoryDAO;
import com.dev.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * private static List<Category> categories = new ArrayList<>(); static {
	 * Category category = new Category(); // Adding first category.
	 * category.setId(1); category.setName("Televison");
	 * category.setDescription("This is the description for Television.");
	 * category.setImageURL("CAT_1.png"); categories.add(category); // Adding
	 * second category category = new Category(); category.setId(2);
	 * category.setName("Mobile");
	 * category.setDescription("This is the description for Mobile.");
	 * category.setImageURL("CAT_2.png"); categories.add(category); category =
	 * new Category(); category.setId(3); category.setName("Laptop");
	 * category.setDescription("This is the description for Laptop.");
	 * category.setImageURL("CAT_3.png"); categories.add(category); }
	 */

	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public Category get(int id) {

		// enhanced for loop
		/*
		 * for(Category category : categories){ if(category.getId() == id)
		 * return category; }
		 */
		return sessionFactory.getCurrentSession().get(Category.class,
				Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {
			// add the category to the database table.
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Updating single category
	@Override
	public boolean update(Category category) {
		try {
			// update the category to the database table.
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			// delete the category from the database table.
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

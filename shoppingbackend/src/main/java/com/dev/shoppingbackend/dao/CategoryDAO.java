package com.dev.shoppingbackend.dao;

import java.util.List;

import com.dev.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	public List<Category> list();
	
	Category get(int id);
	
	

}

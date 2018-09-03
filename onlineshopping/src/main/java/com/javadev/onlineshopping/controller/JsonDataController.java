package com.javadev.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.shoppingbackend.dao.ProductDAO;
import com.dev.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value = "/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = "/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping(value = "/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable("id") int id){
		
		return productDAO.listActiveProductsByCategory(id);
	}
	
}

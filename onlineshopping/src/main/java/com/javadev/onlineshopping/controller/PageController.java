package com.javadev.onlineshopping.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dev.shoppingbackend.dao.CategoryDAO;
import com.dev.shoppingbackend.dao.ProductDAO;
import com.dev.shoppingbackend.dto.Category;
import com.dev.shoppingbackend.dto.Product;
import com.javadev.onlineshopping.exception.ProductNotFoundException;


@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("title","Home");
		
		logger.info("Inside PageController index method. - INFO");
		logger.debug("Inside PageController index method. - DEBUG");
		
		// passing the list of categories
		model.addObject("categories", categoryDAO.list());
		
		model.addObject("userClickHome", true);
		return model;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("title","About Us");
		model.addObject("userClickAbout", true);
		return model;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("title","Contact Us");
		model.addObject("userClickContact", true);
		return model;
	}
	
	/*
	 * Methods to load All Products and based on category
	 * */
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("title","All Products");
		
		// passing the list of categories
		model.addObject("categories", categoryDAO.list());
		
		model.addObject("userClickAllProducts", true);
		return model;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id") int id) {
		
		ModelAndView model = new ModelAndView("page");
		
		
		// CategoryDAO to Fetch Single Category
		Category category = null;
		category = categoryDAO.get(id);
		
		model.addObject("title",category.getName());
		
		// passing the list of categories
		model.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		model.addObject("category", category);
		
		model.addObject("userClickCategoryProducts", true);
		return model;
	}
	
	/*
	 * Viewing a single Product
	 * */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		
		ModelAndView model = new ModelAndView("page");
		Product product = productDAO.get(id);
		
		// condition if product is not available.
		if(product == null) throw new ProductNotFoundException();
		
		// Update the View Count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		model.addObject("title", product.getName());
		model.addObject("product", product);
		model.addObject("userClickShowProduct", true);
		
		return model;
		
	}
	
	/* having similar mapping to our flow id */
	@RequestMapping(value = "/register")
	public ModelAndView register() {
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("title","About Us");
		return model;
	}
	
	/* Request Mapping for Spring Security Login */
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name="error", required = false) String error, 
							  @RequestParam(name="logout", required = false) String logout) {
		
		ModelAndView model = new ModelAndView("login");
		
		if(error != null){
			model.addObject("message", "Invalid Username and Bad Password!");
		}
		
		if(logout != null){
			model.addObject("logout", "User has Successfully Logged Out!");
		}
		
		model.addObject("title","Login");
		return model;
		
	}
	
	/* Access Denied Page*/
	
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		
		ModelAndView model = new ModelAndView("error");
		model.addObject("title","403 - Access Denied");
		model.addObject("errorTitle","Hey! You Caught.");
		model.addObject("errorDescription","You are not Authorized to view this Page!");
		return model;
		
	}
	
	/* Logout Request Mapping */
	@RequestMapping(value = "/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		// first we are fetch the Authentication object
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication != null){
			
			new SecurityContextLogoutHandler().logout(request, response, authentication);
			
		}
		
		return "redirect:/login?logout";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* For Testing Purpose.
	 * 
	 * @RequestMapping(value = "/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false) String greeting){
		
		if(greeting == null){
			greeting = "Hello";
		}
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("greeting",greeting);
		return model;
	}*/
	
	/*@RequestMapping(value = "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greeting){
		
		if(greeting == null){
			greeting = "Hello";
		}
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("greeting",greeting);
		return model;
	}*/

}

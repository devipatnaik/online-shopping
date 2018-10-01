package com.javadev.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dev.shoppingbackend.dao.CategoryDAO;
import com.dev.shoppingbackend.dao.ProductDAO;
import com.dev.shoppingbackend.dto.Category;
import com.dev.shoppingbackend.dto.Product;
import com.javadev.onlineshopping.util.FileUploadUtility;
import com.javadev.onlineshopping.validator.ProductValidator;

@Controller
@RequestMapping(value="/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false)String operation){
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("userClickManageProducts", true);
		model.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		// set few of the fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		model.addObject("product", nProduct);
		
		if(operation != null){
			if(operation.equals("product")){
				model.addObject("message", "Product Submitted Successfully!");
			}else if(operation.equals("category")){
				model.addObject("message", "Category Submitted Successfully!");
			}
		}
		
		return model;
	}
	
	@RequestMapping(value = "/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable("id") int id){
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("userClickManageProducts", true);
		model.addObject("title", "Manage Products");
		
		// fetch the Product from the DataBase
		Product nProduct = productDAO.get(id);
		// set the Product fetched from DataBase
		model.addObject("product", nProduct);
		
		return model;
	}
	
	// handling product submission
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handlerProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, HttpServletRequest request){
		logger.info(mProduct.toString());
		
		// handle image validation for New Product
		if(mProduct.getId() == 0){
			new ProductValidator().validate(mProduct, results);
		}else{
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		// check! if there are any errors.
		if(results.hasErrors()){
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed Pleases provide input!");
			return "page";
		}
		
		// create a new product record
		if(mProduct.getId() == 0){
			// Create a new product record if id is 0
			productDAO.add(mProduct);
		}else{
			// Update the Product record if id is not 0
			productDAO.update(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	// This Controller is for Activate and Deactivate the Product
	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id){
		// Is going to fetch product from the DataBase.
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		// Product is activating and deactivating based on the value of Active field.
		product.setActive(!product.isActive());
		// updating the product
		productDAO.update(product);
		
		return (isActive) ? 
				"You have Successfully deactivated the Product with id: " + product.getId() : 
				"You have Successfully activated the Product with id: " + product.getId();
	}
	
	// To handle Category Submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category){
					
		// add the new category
		categoryDAO.add(category);
					
		return "redirect:/manage/products?operation=category";
	}
	
	// returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	}
	
	// To link it with Category Form
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}

}

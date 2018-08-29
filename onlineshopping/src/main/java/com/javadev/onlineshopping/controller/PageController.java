package com.javadev.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PageController {
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("title","Home");
		model.addObject("userClickHome", true);
		return model;
	}
	
	/*@RequestMapping(value = "/about")
	public ModelAndView about() {
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("title","About Us");
		model.addObject("userClickHome", true);
		return model;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("title","Contact Us");
		model.addObject("userClickHome", true);
		return model;
	}*/
	
	/*@RequestMapping(value = "/test")
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

package com.javadev.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		
		ModelAndView model = new ModelAndView("error");
		
		model.addObject("errorTitle", "The page is not constructed!");
		
		model.addObject("errorDescription", "The page...you are looking for is not available now!");
		
		model.addObject("title", "404 Error page");
		
		return model;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException(){
		
		ModelAndView model = new ModelAndView("error");
		
		model.addObject("errorTitle", "Product not available!");
		
		model.addObject("errorDescription", "The product...you are looking for is not available right now!");
		
		model.addObject("title", "Product Unavailable!");
		
		return model;
	}
	
	// General Exception
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e){
		
		ModelAndView model = new ModelAndView("error");
		
		model.addObject("errorTitle", "Contact your Administrator!");
		
		/* This is only for Debugging purpose not for production enviornmrnt
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		e.printStackTrace(pw);	*/
		
		model.addObject("errorDescription", e.toString());
		
		model.addObject("title", "Error");
		
		return model;
	}

}

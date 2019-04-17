package com.san.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerForNoHandlerFoundException() {
		
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("errorTitle", "Page Not Found");
		mav.addObject("errorDescription", "The Page You Looking is Not Available Now!!!");
		mav.addObject("title", "404 Error Page");
		return mav;
	}
	
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerForProductNotFoundException() {
		
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("errorTitle", "Product Not Found");
		mav.addObject("errorDescription", "The Product You Looking is Not Available Now!!!");
		mav.addObject("title", "Product Not Found");
		return mav;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerForGeneralisedException(Exception ex) {
		
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("errorTitle", "Contact Administrator");
		mav.addObject("errorDescription", ex.toString());
		mav.addObject("title", "Error");
		return mav;
	}

}

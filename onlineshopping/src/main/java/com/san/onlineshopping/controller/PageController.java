package com.san.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.san.onlineshopping.exception.ProductNotFoundException;
import com.san.shoppingbackend.dao.CategoryDAO;
import com.san.shoppingbackend.dao.ProductDAO;
import com.san.shoppingbackend.dto.Category;
import com.san.shoppingbackend.dto.Product;



@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= {"/", "/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Home");
		mav.addObject("categories", categoryDAO.list());
		mav.addObject("userClickHome", true);
		
		logger.debug("Page controller-debug");
		logger.info("pagecontroller info");

		return mav;
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView about() {
		
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "About");
		mav.addObject("userClickAbout", true);		
		return mav;
	}
	
	@RequestMapping(value= "/contact")
	public ModelAndView contact() {
		
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Contact");
		mav.addObject("userClickContact", true);		
		return mav;
	}
	
	@RequestMapping(value= "/products")
	public ModelAndView services() {
		
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Products");
		mav.addObject("userClickProducts", true);
		return mav;
	}
	
	
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Products");
		mav.addObject("categories", categoryDAO.list());
		mav.addObject("userClickShowAllProducts", true);
		return mav;
	}
	
	
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		
		ModelAndView mav = new ModelAndView("page");
		Category category = null;
		category = categoryDAO.get(id);
		mav.addObject("title", category.getName());
		mav.addObject("category", category);
		mav.addObject("categories", categoryDAO.list());
		mav.addObject("userClickCategoryProducts", true);
		return mav;
	}
	
	
	
	@RequestMapping(value= "/show/{id}/product")
	public ModelAndView showSingleProductbyId(@PathVariable("id") int id) throws ProductNotFoundException{
		
		ModelAndView mav = new ModelAndView("page");
		
		Product product = null;
		
		product = productDAO.get(id);
		if(product == null) throw new ProductNotFoundException();
		//set views
		product.setViews(product.getViews() + 1);
		//update
		productDAO.update(product);
		
		//add object
		
		mav.addObject("title", product.getName());
		mav.addObject("product", product);
		mav.addObject("userClickShowProduct" , true);
		
		return mav;
		
	}


}
























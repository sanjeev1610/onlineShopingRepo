package com.san.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.san.shoppingbackend.dao.ProductDAO;
import com.san.shoppingbackend.dto.Product;


public class ProductTest {
	
	
	
private static AnnotationConfigApplicationContext context;
	
	private static  ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.san.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");	
		
		
	}
	
	@Test
	public void crudTest() {
		
//		
//		product = new Product();
//		product.setId(1);
//		product.setCode("PRDABC123DEFX");
//		product.setName("iphone 5s");
//		product.setBrand("apple");
//		product.setDescription("This is one of the best available iphone in the market");
//		product.setUnitPrice(21000.00);
//		product.setQuantity(5);
//		product.setActive(true);
//		product.setCategoryId(3);
//		product.setSupplierId(2);
//		product.setPurchases(0);
//		product.setViews(0);
//		
//		assertEquals("updated success", true, productDAO.update(product));
//		assertEquals("delete success", true, productDAO.delete(product));
		
//		product = productDAO.get(1);
//		assertEquals("get success", "iphone 5s", product.getName());
//		
		
		
		assertEquals("get active products by cat id", 2, productDAO.listActiveProductsByCategory(3).size());
		
		
		
		
		
		
		

		
		
		
		
	}
	

}


















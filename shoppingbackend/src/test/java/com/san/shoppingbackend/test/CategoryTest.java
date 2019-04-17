package com.san.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.san.shoppingbackend.dao.CategoryDAO;
import com.san.shoppingbackend.dto.Category;



public class CategoryTest {

	private static AnnotationConfigApplicationContext context;
	
	private static  CategoryDAO categoryDao;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.san.shoppingbackend");
		context.refresh();
		categoryDao = (CategoryDAO)context.getBean("categoryDAO");	
		
		
	}
	
	
//	@Test
//	public void testAddCategory() {
//		
//		category = new Category();
//		category.setName("Television");
//		category.setDescription("This is Telivision category");
//		category.setImageURL("CAT_1.png");
//		
//		assertEquals("Successfully added a category inside table", true, categoryDao.add(category));
//		
//		
//				
//	}
	
	
	@Test
	public void creudTest() {
//		
//		//add category
//		category = new Category();
//		category.setName("Mobile");
//		category.setDescription("This is Mobile Category");
//		category.setImageURL("CAT_2.png");
//		
//		assertEquals("Successfully added a category inside table", true,categoryDao.add(category));
//		
//		//add category
//		category = new Category();
//		category.setName("Laptop");
//		category.setDescription("This is Laptop Category");
//		category.setImageURL("CAT_3.png");
//		
//		assertEquals("Successfully added a category inside table", true,categoryDao.add(category));
		
		
		//get category
		category = categoryDao.get(1);
		assertEquals("Successfully get select category", "Television", category.getName());
		
		
		//update category
		category = new Category();
		category.setId(33);
		category.setName("Mobile");
		category.setDescription("This is updated  Mobile Category");
		category.setImageURL("CAT_2.png");
		assertEquals("Successfully update category", true, categoryDao.update(category));

		
		assertEquals("Successfully delete category", true, categoryDao.delete(category));

	}
	
	
	
	
	

}




























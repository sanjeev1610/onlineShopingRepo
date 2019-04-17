package com.san.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.san.shoppingbackend.dao.CategoryDAO;
import com.san.shoppingbackend.dto.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionfactory;
	

	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionfactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		
		
		return query.getResultList();
	}
	
	@Override
	public Category get(int id) {
		
		
		return sessionfactory.getCurrentSession().get(Category.class, Integer.valueOf(id));

	}


	@Override
	public boolean add(Category category) {
		
		try {
			
			//add category to database
			sessionfactory.getCurrentSession().persist(category);
			
			return true;
			
		}catch(Exception e) {
			
			return false;
		}
		 
	}


	@Override
	public boolean update(Category category) {
		
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;

		}
	}


	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;

		}	
	}
	
	
	
	
	
	

}

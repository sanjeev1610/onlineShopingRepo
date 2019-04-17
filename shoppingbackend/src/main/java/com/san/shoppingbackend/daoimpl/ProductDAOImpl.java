package com.san.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.san.shoppingbackend.dao.ProductDAO;
import com.san.shoppingbackend.dto.Product;


@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public Product get(int productId) {
		
		try {
			return sessionfactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * LIST
	 */
	
	@Override
	public List<Product> list() {
		
		
		return sessionfactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}
	
	/*
	 * ADD/Insert
	 */

	@Override
	public boolean add(Product product) {
		
		try {
			sessionfactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	/*
	 * UPDATE
	 */
	@Override
	public boolean update(Product product) {
		try {
			sessionfactory.getCurrentSession().update(product);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/*
	 * DELETE
	 */

	@Override
	public boolean delete(Product product) {
		
		try {
			product.setActive(false);
			sessionfactory.getCurrentSession().update(product);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	@Override
	public List<Product> listActiveProducts() {
		
		String selectActiveProducts = "FROM Product WHERE active = :active";
		
		return sessionfactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
	String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		
		return sessionfactory.getCurrentSession().createQuery(selectActiveProductsByCategory, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId).getResultList();
		}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionfactory.getCurrentSession().createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
		
	}
	
	
	
	
}

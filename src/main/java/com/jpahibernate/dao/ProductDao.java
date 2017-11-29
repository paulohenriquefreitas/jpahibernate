package com.jpahibernate.dao;

import java.util.List;

import com.jpahibernate.model.Product;



public interface ProductDao {
	//TODO Implement here methods specific to Product context
	
	List<Product> getAllWithoutRelationships();

	Product getProductWithoutRelationship(Integer id);

}

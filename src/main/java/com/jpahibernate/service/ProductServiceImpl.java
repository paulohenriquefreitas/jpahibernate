package com.jpahibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jpahibernate.dao.ProductDaoImpl;
import com.jpahibernate.model.Product;

/**
 * Created by paulo on 18/11/17.
 */
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDaoImpl productDaoImpl;

	@Override
    public List<Product> getAll(boolean full) {
		if(full)  return productDaoImpl.findAll();
		return productDaoImpl.getAllWithoutRelationships();
    }

    @Override
    public boolean save(Product product) {
    	if(productDaoImpl.findOne(product.getProduct_id()) != null){
    		return false;
    	}else {
    		productDaoImpl.create(product);
    		return true;
    	}    	
    }

    @Override
    public Product getById(Integer id, boolean full) {
    	if(full) return productDaoImpl.findOne(id);
       
        return productDaoImpl.getProductWithoutRelationship(id);
    }

    @Override
    public void update(Product product) {
    	productDaoImpl.update(product);
    }

    @Override
    public void deleteById(Integer id) {
    	Product product = productDaoImpl.findOne(id);
    	productDaoImpl.delete(product);
    }
}

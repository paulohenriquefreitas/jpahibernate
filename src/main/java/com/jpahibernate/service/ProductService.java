package com.jpahibernate.service;

import java.util.List;

import com.jpahibernate.model.Product;

/**
 * Created by paulo on 18/11/17.
 */
public interface ProductService {

    List<Product> getAll(boolean full);
    boolean save(Product product);
    Product getById(Integer id, boolean full);
    void update(Product product);
	void deleteById(Integer entityId);
}

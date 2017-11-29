package com.jpahibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.jpahibernate.model.Product;

/**
 * Created by paulo on 18/11/17.
 */

@Repository
public class ProductDaoImpl extends AbstractJpaDAO<Product> implements ProductDao{
	
	
	public ProductDaoImpl() {
        super();

        setClazz(Product.class);
    }
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllWithoutRelationships() {
		return getCriteriaSpecificColumns().list();
	}

	@Override
	public Product getProductWithoutRelationship(Integer id) {
		return (Product) getCriteriaSpecificColumns().add(Restrictions.eq("product_id", id)).uniqueResult();
	}
	
	private Criteria getCriteriaSpecificColumns() {
		return getSession().createCriteria(Product.class)
			    .setProjection(Projections.projectionList()
					      .add(Projections.property("product_id"), "product_id")
					      .add(Projections.property("name"), "name")
					      .add(Projections.property("description"), "description"))
					    .setResultTransformer(Transformers.aliasToBean(Product.class));
	}
	
	

	
	
	
}

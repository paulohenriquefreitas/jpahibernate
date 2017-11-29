package com.jpahibernate.dao;

import org.springframework.stereotype.Repository;

import com.jpahibernate.model.Image;

/**
 * Created by paulo on 18/11/17.
 */

@Repository
public class ImageDaoImpl extends AbstractJpaDAO<Image> implements ImageDao{
	
	
	public ImageDaoImpl() {
        super();

        setClazz(Image.class);
    }

	
	
	
}

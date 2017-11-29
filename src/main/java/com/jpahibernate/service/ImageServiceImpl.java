package com.jpahibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jpahibernate.dao.ImageDaoImpl;
import com.jpahibernate.model.Image;

/**
 * Created by paulo on 18/11/17.
 */
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDaoImpl imageDaoImpl;

	@Override
    public List<Image> getAll() {
        return imageDaoImpl.findAll();
    }

    @Override
    public boolean save(Image image) {
    	if(imageDaoImpl.findOne(image.getImage_id()) != null){
    		return false;
    	}else {
    		imageDaoImpl.create(image);
    		return true;
    	}    	
    }

    @Override
    public Image getById(Integer id) {
        Image image = imageDaoImpl.findOne(id);
        return image;
    }

    @Override
    public void update(Image image) {
    	imageDaoImpl.update(image);
    }

    @Override
    public void deleteById(Integer id) {
    	Image image = imageDaoImpl.findOne(id);
    	imageDaoImpl.delete(image);
    }
}

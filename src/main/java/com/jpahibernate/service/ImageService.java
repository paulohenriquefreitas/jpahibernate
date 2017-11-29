package com.jpahibernate.service;

import java.util.List;

import com.jpahibernate.model.Image;

/**
 * Created by paulo on 18/11/17.
 */
public interface ImageService {

    List<Image> getAll();
    boolean save(Image image);
    Image getById(Integer id);
    void update(Image image);
	void deleteById(Integer entityId);
}

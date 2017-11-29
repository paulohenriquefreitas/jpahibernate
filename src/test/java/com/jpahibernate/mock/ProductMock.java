package com.jpahibernate.mock;

import java.util.Arrays;

import com.jpahibernate.model.Product;

public class ProductMock {
	
	public static Product getProductMock (){
		
		
		Product child = new Product();
		child.setProduct_id(20);
		child.setName("Iphone");
		child.setDescription("cell phone");
		child.setImages(Arrays.asList(ImageMock.getImageMock()));
		
		return child;
		
	}

}

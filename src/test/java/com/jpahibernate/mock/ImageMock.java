package com.jpahibernate.mock;

import com.jpahibernate.model.Image;

public class ImageMock {
	
	public static Image getImageMock() {
		Image image = new Image();
		image.setImage_id(1);
		image.setType("XX");
		return image;
	}

}

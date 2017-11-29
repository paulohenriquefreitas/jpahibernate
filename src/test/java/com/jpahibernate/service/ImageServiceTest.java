package com.jpahibernate.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jpahibernate.dao.AbstractJpaDAO;
import com.jpahibernate.mock.ImageMock;
import com.jpahibernate.mock.ProductMock;
import com.jpahibernate.service.ImageServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ImageServiceTest<T> {
	
	@InjectMocks
	private ImageServiceImpl imageServiceImpl;
	
	@Mock
	private AbstractJpaDAO<T> abstractJpaDAO;
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_save_success() throws Exception {
		
		verify(abstractJpaDAO, times(0)).create((T) ImageMock.getImageMock());
		
	}
	
//	Due the similarity of the events the other tests will not be implemented for this exam;
}

package com.jpahibernate.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jpahibernate.dao.AbstractJpaDAO;
import com.jpahibernate.dao.ProductDaoImpl;
import com.jpahibernate.mock.ProductMock;
import com.jpahibernate.service.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest<T> {
	
		
	@Mock
	private AbstractJpaDAO<T> abstractJpaDAO;
	
	@Mock
	private ProductDaoImpl productDaoImpl;
	
	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_save_success() throws Exception {
		verify(abstractJpaDAO, times(0)).create((T) ProductMock.getProductMock());
	}

	
//	Due the similarity of the events the other tests will not be implemented for this exam;

}

package com.jpahibernate.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jpahibernate.controller.ProductController;
import com.jpahibernate.mock.ProductMock;
import com.jpahibernate.model.Product;
import com.jpahibernate.service.ProductServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
	
    
	@InjectMocks
	private ProductController productController;
	@Mock
	private ProductServiceImpl productServiceImpl;
	
	@Test
	public void test_save_success() throws Exception {
		when(productServiceImpl.save(ProductMock.getProductMock())).thenReturn(true);
		System.out.println("AAA" + productServiceImpl.save(ProductMock.getProductMock()));
		assertEquals(201, productController.save(ProductMock.getProductMock()).getStatus());
	}
	
	@Test
	public void test_save_fail() throws Exception {
		when(productServiceImpl.save(ProductMock.getProductMock())).thenReturn(false);
		assertEquals(409, productController.save(ProductMock.getProductMock()).getStatus());
	}
	
	@Test (expected=RuntimeException.class)
	public void test_error_when_save() throws Exception {
		when(productServiceImpl.save(ProductMock.getProductMock())).thenThrow(new RuntimeException());
		assertEquals(409, productController.save(ProductMock.getProductMock()).getStatus());
		productController.save(ProductMock.getProductMock());
	}
	
	@Test
	public void test_getAll_success() throws Exception {
		Product expectedProduct = mock(Product.class);
		when(productServiceImpl.getAll(true)).thenReturn(Arrays.asList(expectedProduct));
		assertEquals(Arrays.asList(expectedProduct), productController.getAll(true).getEntity());
	}
	
	@Test
	public void test_getCompact_success() throws Exception {
		Product expectedProduct = mock(Product.class);
		when(productServiceImpl.getAll(false)).thenReturn(Arrays.asList(expectedProduct));
		assertEquals(Arrays.asList(expectedProduct), productController.getAll(false).getEntity());
	}
	
	@Test
	public void test_getAll_fail() throws Exception {
		when(productServiceImpl.getAll(true)).thenReturn(Arrays.asList());
		assertEquals(Arrays.asList(), productController.getAll(true).getEntity());
	}
     
	@Test
	public void test_findById_success() throws Exception {
		when(productServiceImpl.getById(1,true)).thenReturn(ProductMock.getProductMock());
		assertEquals(200, productController.getById(1,true).getStatus());
	}
	
	@Test
	public void test_findById_fail() throws Exception {
		when(productServiceImpl.getById(1,true)).thenReturn(ProductMock.getProductMock());
		assertEquals(200, productController.getById(2,true).getStatus());
	}
	
	@Test (expected=RuntimeException.class)
	public void test_error_when_getById() throws Exception {
		when(productServiceImpl.getById(1,true)).thenThrow(new RuntimeException());
		productController.getById(1,true);
	}
	
	@Test
	public void test_update_success() throws Exception {
		productController.update(ProductMock.getProductMock());
		verify(productServiceImpl, times(1)).update(ProductMock.getProductMock());
	}
	
	@Test
	public void test_delete_success() throws Exception {
		
		productController.delete(1);
		verify(productServiceImpl, times(1)).deleteById(1);
		assertEquals(204, productController.delete(1).getStatus());
	}
	

}

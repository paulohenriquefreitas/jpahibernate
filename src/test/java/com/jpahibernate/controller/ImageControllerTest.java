package com.jpahibernate.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jpahibernate.controller.ImageController;
import com.jpahibernate.mock.ImageMock;
import com.jpahibernate.service.ImageServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class ImageControllerTest {
	
	@InjectMocks
	private ImageController imageController;
	@Mock
	private ImageServiceImpl imageServiceImpl;
	
	@Test
	public void test_save_success() throws Exception {
		
		when(imageServiceImpl.save(ImageMock.getImageMock())).thenReturn(true);
		assertEquals(201, imageController.save(ImageMock.getImageMock()).getStatus());
	}
	
	@Test
	public void test_save_fail() throws Exception {
		
		when(imageServiceImpl.save(ImageMock.getImageMock())).thenReturn(false);
		assertEquals(409, imageController.save(ImageMock.getImageMock()).getStatus());
	}
	
	@Test (expected=RuntimeException.class)
	public void test_error_when_save() throws Exception {
		when(imageServiceImpl.save(ImageMock.getImageMock())).thenThrow(new RuntimeException());
		assertEquals(409, imageController.save(ImageMock.getImageMock()).getStatus());
		imageController.save(ImageMock.getImageMock());
	}
	
	@Test
	public void test_getAll_success() throws Exception {
		when(imageServiceImpl.getAll()).thenReturn(Arrays.asList());
		assertEquals(Arrays.asList(), imageController.getAllImages().getEntity());
	}
	
	@Test
	public void test_findById_success() throws Exception {
		when(imageServiceImpl.getById(1)).thenReturn(ImageMock.getImageMock());
		assertEquals(200, imageController.getImageById(1).getStatus());
	}
	
	@Test
	public void test_findById_fail() throws Exception {
		when(imageServiceImpl.getById(1)).thenReturn(ImageMock.getImageMock());
		assertEquals(200, imageController.getImageById(2).getStatus());
	}
	
	@Test (expected=RuntimeException.class)
	public void test_error_when_getById() throws Exception {
		when(imageServiceImpl.getById(1)).thenThrow(new RuntimeException());
		imageController.getImageById(1);
	}
	
	@Test
	public void test_update_success() throws Exception {
		imageController.update(ImageMock.getImageMock());
		verify(imageServiceImpl, times(1)).update(ImageMock.getImageMock());
	}
	
	@Test
	public void test_delete_success() throws Exception {
		
		imageController.deleteImage(1);
		verify(imageServiceImpl, times(1)).deleteById(1);
		assertEquals(204, imageController.deleteImage(1).getStatus());
	}

}

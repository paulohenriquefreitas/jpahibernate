package com.jpahibernate.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpahibernate.model.Image;
import com.jpahibernate.service.ImageService;

/**
 * Created by paulo on 18/11/17.
 */

@Component
@Path("/product/image/")
public class ImageController {

	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

	@Autowired
	private ImageService imageService;

    @GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllImages() {

		List<Image> images = imageService.getAll();
		return Response.ok(images).build();
	}
    
    @GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getImageById(@PathParam("id") Integer id) {
		Image image = imageService.getById(id);
		return Response.ok(image).build();
	}
    
    @POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Image image) {
    	   
		boolean isAdded = imageService.save(image);
		if (!isAdded) {
			logger.info("Image already exits.");
			return Response.status(Response.Status.CONFLICT).build();
		}
		return Response.created(URI.create("/jpahibernate/image/" + image.getImage_id())).build();
	}
    
    @PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Image image) {
		imageService.update(image);
		return Response.ok(image).build();
	}
    
    @DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteImage(@PathParam("id") Integer id) {
		imageService.deleteById(id);
		return Response.noContent().build();
	}


}

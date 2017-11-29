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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpahibernate.model.Product;
import com.jpahibernate.service.ProductService;

/**
 * Created by paulo on 18/11/17.
 */

@Component
@Path("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("full") boolean full) {
       
        List<Product> products = productService.getAll(full);
        return Response.ok(products).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @QueryParam("full") boolean full) {
        Product product = productService.getById(id,full);
        return Response.ok(product).build();
    }
    
    @GET
    @Path("/{id}/products")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllChildsById(@PathParam("id") Integer id) {
        //TODO
    	return Response.noContent().build();
    }
    
    @GET
    @Path("/{id}/images")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllImagesById(@PathParam("id") Integer id) {
    	//TODO
    	return Response.noContent().build();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Product product) {
 
        boolean isAdded = productService.save(product);
        if (!isAdded) {
            logger.info("Product already exits.");
            return Response.status(Response.Status.CONFLICT).build();
        }
        return Response.created(URI.create("/jpahibernate/product/"+ product.getProduct_id())).build();
     }

     @PUT
     @Path("/update")
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
     public Response update(Product product) {
        productService.update(product);
        return Response.ok(product).build();
     }

     @DELETE
     @Path("/{id}")
     @Consumes(MediaType.APPLICATION_JSON)
     public Response delete(@PathParam("id") Integer id) {
        productService.deleteById(id);
        return Response.noContent().build();
     }
}

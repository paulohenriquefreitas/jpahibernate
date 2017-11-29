package com.jpahibernate.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.jpahibernate.controller.ImageController;
import com.jpahibernate.controller.ProductController;

import javax.ws.rs.ApplicationPath;

/**
 * Created by paulo on 18/11/17.
 */

@Component
@ApplicationPath("/jpahibernate")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ProductController.class);
        register(ImageController.class);
    }
}

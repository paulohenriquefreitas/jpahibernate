package com.jpahibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpahibernate.dao.ImageDao;
import com.jpahibernate.dao.ImageDaoImpl;
import com.jpahibernate.dao.ProductDao;
import com.jpahibernate.dao.ProductDaoImpl;
import com.jpahibernate.service.ImageService;
import com.jpahibernate.service.ImageServiceImpl;
import com.jpahibernate.service.ProductService;
import com.jpahibernate.service.ProductServiceImpl;

/**
 * Created by paulo on 18/11/17.
 */

@Configuration
@EnableTransactionManagement
public class JpaHibernateConfig {

    @Bean
    public ImageService imageService() {
        return new ImageServiceImpl();
    };
    
    @Bean
    public ImageDao imageDaoImp() {
    	return new ImageDaoImpl();
    }
    
    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    };
    
    @Bean
    public ProductDao productDaoImp() {
    	return new ProductDaoImpl();
    }
    
    @Bean
    public ObjectMapper buildObjectMapper() {
       return new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
    		                    .setSerializationInclusion(Include.NON_EMPTY);
    }
    
    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

  
}

package com.jpahibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

@SpringBootApplication
public class JpaHibernate {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernate.class, args);
	}
}

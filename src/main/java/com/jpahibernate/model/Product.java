package com.jpahibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="product" , catalog = "avenuecode")
public class Product implements Serializable {
    
	
    
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="product_id")
    private int product_id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="principal_id")
    private Product principal;
    
    @OneToMany(mappedBy="principal")
    @JsonBackReference
    private List<Product> products = new ArrayList<Product>();
    

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Image.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id" )
    private List<Image> images;


	

}

package com.enochcode.spring_boot_demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductImage {
	
	@jakarta.persistence.Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY  )
private Long  Id;
	
private String publicId;
private String url ;


public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
public String getPublicId() {
	return publicId;
}
public void setPublicId(String publicId) {
	this.publicId = publicId;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}


public ProductImage(Long id, String publicId, String url) {
	super();
	Id = id;
	this.publicId = publicId;
	this.url = url;
}

@ManyToOne()
@JoinColumn(name="product_id")
@JsonIgnore   // <-- prevents Jackson from serializing product -> images -> product -> ... forever

private Product product;



	public ProductImage(ProductImage url2, Product product) {
		this.url="/uploads" + url2;
		this.publicId=url2.getPublicId();
		this.product=product;
	}

public ProductImage() {
	super();
	// TODO Auto-generated constructor stub
}
public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}



	
}



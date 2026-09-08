package com.enochcode.spring_boot_demo.dto;

import com.enochcode.spring_boot_demo.entity.ProductImage;
import com.enochcode.spring_boot_demo.entity.ProductReview;

public class ProductDto {

	
	private Long id;

	private String name;

	private Double price;

	private String description;
	private String category;

	private Double ratings = 0.0;

 	private String seller;

 	private Integer stock;

	private Integer numOfReviews = 0;

	
	
 	private java.util.List<ProductImageDto> images;

		public java.util.List<ProductImageDto> getImages() {
		return images;
	}

	public void setImages(java.util.List<ProductImageDto> images) {
		this.images = images;
	}


		private java.util.List<ProductReviewDto> reviews;

	
	
	public java.util.List<ProductReviewDto> getReviews() {
		return reviews;
	}

	public void setReviews(java.util.List<ProductReviewDto> reviews) {
		this.reviews = reviews;
	}

	public Double getRatings() {
		return ratings;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getNumOfReviews() {
		return numOfReviews;
	}

	public void setNumOfReviews(Integer numOfReviews) {
		this.numOfReviews = numOfReviews;
	}

	public ProductDto(Long id, String name, Double price, String description,String category, String seller, Integer stock,
			 Double ratings) {

		super();
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;

		this.seller = seller;
		this.stock = stock;
		this.ratings = ratings;
	}
	

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

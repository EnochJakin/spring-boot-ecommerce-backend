package com.enochcode.spring_boot_demo.dto;

public class ProductImageDto {

	
	
	private  String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ProductImageDto(String url) {
		super();
		this.url = url;
	}
		
	
}

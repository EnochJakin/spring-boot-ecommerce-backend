package com.enochcode.spring_boot_demo.dto;

public class OrderCreated {
	
	private String referanceId;

	public String getReferanceId() {
		return referanceId;
	}

	public void setReferanceId(String referanceId) {
		this.referanceId = referanceId;
	}

	public OrderCreated(String referanceId) {
		super();
		this.referanceId = referanceId;
	}

}

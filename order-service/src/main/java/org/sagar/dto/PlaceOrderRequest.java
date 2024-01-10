package org.sagar.dto;

import org.springframework.stereotype.Component;

@Component
public class PlaceOrderRequest {

	private Long orderId;
	private String productIds;
	private Double price;
	private int Quentity;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public int getQuentity() {
		return Quentity;
	}

	public void setQuentity(int quentity) {
		Quentity = quentity;
	}

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}

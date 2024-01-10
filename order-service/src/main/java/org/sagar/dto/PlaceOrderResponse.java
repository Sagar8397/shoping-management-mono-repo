package org.sagar.dto;

import org.springframework.stereotype.Component;

@Component
public class PlaceOrderResponse {

	private String message;
	private Long orderId;
	private String productIds;
	private double totalPrice;
	private int Quentity;

	public int getQuentity() {
		return Quentity;
	}

	public void setQuentity(int quentity) {
		Quentity = quentity;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}

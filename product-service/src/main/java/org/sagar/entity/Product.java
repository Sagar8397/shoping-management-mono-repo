package org.sagar.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Component
public class Product {

	@GeneratedValue
	@Id
	@Column
	private long productId;
	
	@Column
	private String productName;
	
	@Column
	private long price;
	
	@Column
	private int Quentity;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getQuentity() {
		return Quentity;
	}

	public void setQuentity(int quentity) {
		Quentity = quentity;
	}

}

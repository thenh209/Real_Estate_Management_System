package com.project.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_history")
public class HistoryModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int paymentId;
    private int userId;
    private int propertyId;
	private double price;
	private String propertyName;
	public HistoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoryModel(int paymentId, int userId, int propertyId, double price, String propertyName) {
		super();
		this.paymentId = paymentId;
		this.userId = userId;
		this.propertyId = propertyId;
		this.price = price;
		this.propertyName = propertyName;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	
	
}

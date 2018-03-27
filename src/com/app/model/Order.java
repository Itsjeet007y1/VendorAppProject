package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_tab")
public class Order implements Comparable<Order> {
	@Id
	private int orderId;
	private String orderCode;
	private double orderCost;
	private double maxDiscount;
	private int custId;
	
	//default constructor
	public Order() {
		super();
	}
	
	//one parameter constructor for sorting
	public Order(int orderId) {
		super();
		this.orderId = orderId;
	}
	
	//setters and getters
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public double getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}
	public double getMaxDiscount() {
		return maxDiscount;
	}
	public void setMaxDiscount(double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	//compareTo method for sorting
	@Override
	public int compareTo(Order o) {
		return this.getCustId()-o.getCustId();
	}
	
	//toString() method
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCode=" + orderCode
				+ ", orderCost=" + orderCost + ", maxDiscount=" + maxDiscount
				+ ", custId=" + custId + "]";
	}
}

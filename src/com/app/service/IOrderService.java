package com.app.service;

import java.util.List;

import com.app.model.Order;

public interface IOrderService {
	public int saveOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(int orderId);
	public Order getOrderById(int orderId);
	public List<Order> getAllOrders();
}

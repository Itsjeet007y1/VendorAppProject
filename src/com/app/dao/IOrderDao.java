package com.app.dao;

import java.util.List;

import com.app.model.Order;

public interface IOrderDao {
	public int saveOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(int OrderId);
	public Order getOneOrderById(int OrderId);
	public List<Order> getAllOrders();
}

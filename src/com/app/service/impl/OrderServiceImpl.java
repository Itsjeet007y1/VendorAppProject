package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.dao.IOrderDao;
import com.app.model.Order;
import com.app.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderDao dao;

	@Override
	public int saveOrder(Order order) {
		return dao.saveOrder(order);
	}

	@Override
	public void updateOrder(Order order) {
		dao.updateOrder(order);

	}

	@Override
	public void deleteOrder(int orderId) {
		dao.deleteOrder(orderId);

	}

	@Override
	public Order getOrderById(int orderId) {
		return dao.getOneOrderById(orderId);
	}

	@Override
	public List<Order> getAllOrders() {
		return dao.getAllOrders();
	}

}

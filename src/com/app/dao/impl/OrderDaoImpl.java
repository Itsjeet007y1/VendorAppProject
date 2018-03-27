package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderDao;
import com.app.model.Order;

@Repository
public class OrderDaoImpl implements IOrderDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveOrder(Order order) {
		return (Integer)ht.save(order);
	}

	@Override
	public void updateOrder(Order order) {
		ht.update(order);

	}

	@Override
	public void deleteOrder(int orderId) {
		ht.delete(new Order(orderId));

	}

	@Override
	public Order getOneOrderById(int orderId) {
		return ht.get(Order.class, orderId);
	}

	@Override
	public List<Order> getAllOrders() {
		return ht.loadAll(Order.class);
	}

}

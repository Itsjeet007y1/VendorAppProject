package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveCustomer(Customer cust) {
		return (Integer)ht.save(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
		ht.update(cust);

	}

	@Override
	public void deleteCustomer(int custId) {
		ht.delete(new Customer(custId));

	}

	@Override
	public Customer getCustomerById(int custId) {
		return ht.get(Customer.class, custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return ht.loadAll(Customer.class);
	}
	@Override
	public Customer getCustomerByEmail(String email) {
		Customer cust=null;
		String hql="from com.app.model.Customer where custEmail=?";
		List<Customer> list=ht.find(hql,email);
		if(list!=null && list.size()>0){
			cust=list.get(0);
		}
		return cust;
	}
}

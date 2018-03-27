package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;

@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveItem(Item itm) {
		return (Integer)ht.save(itm);
	}

	@Override
	public void updateItem(Item itm) {
		ht.update(itm);

	}

	@Override
	public void deleteItem(int itemId) {
		ht.delete(new Item(itemId));

	}

	@Override
	public Item getOneItemById(int itemId) {
		return ht.get(Item.class, itemId);
	}

	@Override
	public List<Item> getAllItems() {
		return ht.loadAll(Item.class);
	}

}

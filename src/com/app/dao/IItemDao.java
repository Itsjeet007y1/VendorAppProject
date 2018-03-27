package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {
	public int saveItem(Item itm);
	public void updateItem(Item itm);
	public void deleteItem(int itemId);
	public Item getOneItemById(int itemId);
	public List<Item> getAllItems();
}

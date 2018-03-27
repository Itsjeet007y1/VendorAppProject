package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface IItemService {
	public int saveItem(Item itm);
	public void updateItem(Item itm);
	public void deleteItem(int itemId);
	public Item getItemById(int itemId);
	public List<Item> getAllItems();
}

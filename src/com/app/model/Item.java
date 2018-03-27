package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itme_tab")
public class Item implements Comparable<Item> {
	@Id
	private int itemId;
	private String itemCode;
	private String itemName;
	private double baseCost;
	private String barCode;
	private double maxDiscount;
	private String mfg;
	//default Constructor
	public Item() {
		super();
	}
	//1 parameter constructor for sorting based on id
	public Item(int itemId) {
		super();
		this.itemId = itemId;
	}
	//setters and getters
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public double getMaxDiscount() {
		return maxDiscount;
	}
	public void setMaxDiscount(double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}
	public String getMfg() {
		return mfg;
	}
	public void setMfg(String mfg) {
		this.mfg = mfg;
	}
	//compareTo() method
	@Override
	public int compareTo(Item o) {
		return this.getItemId()-o.getItemId();
	}
	
	//toString() method
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode
				+ ", itemName=" + itemName + ", baseCost=" + baseCost
				+ ", barCode=" + barCode + ", maxDiscount=" + maxDiscount
				+ ", mfg=" + mfg + "]";
	}
	
}

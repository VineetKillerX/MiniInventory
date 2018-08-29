package com.demo.inventory.model;

import java.util.Map;

public class Inventory {
	private Map<Integer,Items> inventoryItems;

	public Map<Integer, Items> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(Map<Integer, Items> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryItems=" + inventoryItems + "]";
	}
	
	


	
	
	
	

}

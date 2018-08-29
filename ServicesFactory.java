package com.demo.inventory;

import com.demo.inventory.service.InventoryService;
import com.demo.inventory.service.impl.InventoryServiceImpl;

public class ServicesFactory {
	public static InventoryService inventoryService = null;
	
	public static InventoryService createInventoryService(){
		if(inventoryService==null){
			inventoryService = new InventoryServiceImpl();
		}
		return inventoryService;
	}
	
}

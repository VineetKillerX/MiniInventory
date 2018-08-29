package com.demo.inventory.service;

import java.util.List;

import com.demo.inventory.exception.InventoryNotFoundException;
import com.demo.inventory.exception.InventorySystemExceptions;
import com.demo.inventory.model.Items;

public interface InventoryService{
	public int createInventory() throws InventorySystemExceptions;
	public int updateItemInInventory(Items item) throws InventoryNotFoundException, InventorySystemExceptions;
	public int checkoutItem(Items item) throws InventoryNotFoundException, InventorySystemExceptions;
	public List<Items> generateInventoryReport() throws InventoryNotFoundException, InventorySystemExceptions;
}

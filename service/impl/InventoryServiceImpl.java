package com.demo.inventory.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.demo.inventory.InventoryHolder;
import com.demo.inventory.constants.ErrorCodesAndMessages;
import com.demo.inventory.exception.InventoryNotFoundException;
import com.demo.inventory.exception.InventorySystemExceptions;
import com.demo.inventory.model.Inventory;
import com.demo.inventory.model.Items;
import com.demo.inventory.service.InventoryService;

public class InventoryServiceImpl implements InventoryService {
	
	final static Logger logger = Logger.getLogger(InventoryServiceImpl.class);

	@Override
	public int createInventory() throws InventorySystemExceptions {
		logger.info("Entering createInventory at : "+System.currentTimeMillis());
		try{
			if(InventoryHolder.inventory==null){
				synchronized (this) {
					if(InventoryHolder.inventory==null){
						InventoryHolder.inventory = new Inventory();
						InventoryHolder.inventory.setInventoryItems(new HashMap<>());
						return 1;
					}
					return 0;
				}
			}
		}catch(Exception e){
			throw new InventorySystemExceptions(ErrorCodesAndMessages.ErrorCodes.IMS001.toString(), ErrorCodesAndMessages.IMS001_MESSAGE, this.getClass(), "createInventory", e);
		}finally{
			logger.info("Exiting createInventory at : "+System.currentTimeMillis());
		}
		return 0;
	}

	@Override
	public int updateItemInInventory(Items item) throws InventoryNotFoundException, InventorySystemExceptions {
		logger.info("Entering updateItemInInventory at : "+System.currentTimeMillis());
		try{
			if(InventoryHolder.inventory==null){
				throw new InventoryNotFoundException(ErrorCodesAndMessages.ErrorCodes.IMS002.toString(), ErrorCodesAndMessages.IMS002_MESSAGE);
			}
			if(InventoryHolder.inventory.getInventoryItems().containsKey(item.getId())){
				synchronized (this) {
					Items existingItem = InventoryHolder.inventory.getInventoryItems().get(item.getId());
					int originalQuantity = existingItem.getStock();
					int newQuantity = originalQuantity+item.getStock();
					existingItem.setStock(newQuantity);
					InventoryHolder.inventory.getInventoryItems().put(item.getId(),existingItem);
					return newQuantity;
				}	
			}else{
				InventoryHolder.inventory.getInventoryItems().put(item.getId(),item);
				return item.getStock();
			}
		}catch(InventoryNotFoundException infe){
			logger.debug("InventoryNotFoundException in updateItemInInventory occurred at : "+System.currentTimeMillis()+" with ErrorCode as : "+infe.getErrorCode());
			throw infe;
		}catch(Exception e){
			throw new InventorySystemExceptions(ErrorCodesAndMessages.ErrorCodes.IMS001.toString(), ErrorCodesAndMessages.IMS001_MESSAGE, this.getClass(), "updateItemInInventory", e);
		}finally{
			logger.info("Exiting updateItemInInventory at : "+System.currentTimeMillis());
		}
	}

	@Override
	public int checkoutItem(Items item) throws InventoryNotFoundException, InventorySystemExceptions {
		logger.info("Entering checkoutItem at : "+System.currentTimeMillis());
		try{
			if(InventoryHolder.inventory==null){
				throw new InventoryNotFoundException(ErrorCodesAndMessages.ErrorCodes.IMS002.toString(), ErrorCodesAndMessages.IMS002_MESSAGE);
			}
			if(InventoryHolder.inventory.getInventoryItems().containsKey(item.getId())){
				synchronized (this) {
					Items existingItem = InventoryHolder.inventory.getInventoryItems().get(item.getId());
					int originalQuantity = existingItem.getStock();
					if(item.getStock()>originalQuantity){
						throw new InventoryNotFoundException(ErrorCodesAndMessages.ErrorCodes.IMS003.toString(), ErrorCodesAndMessages.IMS003_MESSAGE);
					}
					int newQuantity = originalQuantity-item.getStock();
					existingItem.setStock(newQuantity);
					InventoryHolder.inventory.getInventoryItems().put(item.getId(),existingItem);
					return newQuantity;
				}	
			}else{
				throw new InventoryNotFoundException(ErrorCodesAndMessages.ErrorCodes.IMS004.toString(), ErrorCodesAndMessages.IMS004_MESSAGE);
			}
		}catch(InventoryNotFoundException infe){
			logger.debug("InventoryNotFoundException in checkoutItem occurred at : "+System.currentTimeMillis()+" with ErrorCode as : "+infe.getErrorCode());
			throw infe;
		}catch(Exception e){
			throw new InventorySystemExceptions(ErrorCodesAndMessages.ErrorCodes.IMS001.toString(), ErrorCodesAndMessages.IMS001_MESSAGE, this.getClass(), "checkoutItem", e);
		}finally{
			logger.info("Exiting checkoutItem at : "+System.currentTimeMillis());
		}
	}

	@Override
	public List<Items> generateInventoryReport() throws InventoryNotFoundException, InventorySystemExceptions {
		logger.info("Entering generateInventoryReport at : "+System.currentTimeMillis());
		List<Items> inventoryItemsList = null;
		try{
			if(InventoryHolder.inventory==null){
				throw new InventoryNotFoundException(ErrorCodesAndMessages.ErrorCodes.IMS002.toString(), ErrorCodesAndMessages.IMS002_MESSAGE);
			}
			Collection<Items> itemsSet = InventoryHolder.inventory.getInventoryItems().values();
			if(itemsSet.size()>0){
				inventoryItemsList = new ArrayList<Items>();
				inventoryItemsList.addAll(itemsSet);
			}else{
				throw new InventoryNotFoundException(ErrorCodesAndMessages.ErrorCodes.IMS005.toString(), ErrorCodesAndMessages.IMS005_MESSAGE);
			}
		}catch(InventoryNotFoundException infe){
			logger.debug("InventoryNotFoundException in generateInventoryReport occurred at : "+System.currentTimeMillis()+" with ErrorCode as : "+infe.getErrorCode());
			throw infe;
		}catch(Exception e){
			throw new InventorySystemExceptions(ErrorCodesAndMessages.ErrorCodes.IMS001.toString(), ErrorCodesAndMessages.IMS001_MESSAGE, this.getClass(), "generateInventoryReport", e);
		}finally{
			logger.info("Exiting generateInventoryReport at : "+System.currentTimeMillis());
		}
		return inventoryItemsList;
	}
	
}

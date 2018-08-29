package com.demo.inventory;

import java.util.List;

import org.apache.log4j.Logger;

import com.demo.inventory.constants.ErrorCodesAndMessages;
import com.demo.inventory.exception.InventoryNotFoundException;
import com.demo.inventory.exception.InventorySystemExceptions;
import com.demo.inventory.exception.ItemValidationException;
import com.demo.inventory.model.Items;
import com.demo.inventory.service.InventoryService;
import com.demo.inventory.utils.Validator;

public class InventoryApplicationFactory {
	final static Logger logger = Logger.getLogger(InventoryApplicationFactory.class);
	
	
	public int createInventory() throws InventorySystemExceptions{
		logger.info("Entering createInventory at : "+System.currentTimeMillis());
		try{
			InventoryService service = ServicesFactory.createInventoryService();
			return service.createInventory();
		}catch(InventorySystemExceptions systemExcep){
			throw systemExcep;
		}catch(Exception e){
			throw new InventorySystemExceptions(ErrorCodesAndMessages.ErrorCodes.IMS001.toString(), ErrorCodesAndMessages.IMS001_MESSAGE, this.getClass(), "createInventory", e);
		}finally{
			logger.info("Exiting createInventory at : "+System.currentTimeMillis());
		}
	}
	
	public int updateItemStock(int quantity, int itemId, double cost, String desc) throws InventoryNotFoundException,InventorySystemExceptions,ItemValidationException{
		logger.info("Entering updateItemStock at : "+System.currentTimeMillis());
		try{
			InventoryService service = ServicesFactory.createInventoryService();
			Items item = new Items();
			item.setId(itemId);
			item.setStock(quantity);
			item.setCost(cost);
			item.setName(desc);
			Validator.validateItemRequest(item);
			return service.updateItemInInventory(item);
		}catch(InventoryNotFoundException | InventorySystemExceptions  | ItemValidationException e){
			throw e;
		}catch(Exception e){
			throw new InventorySystemExceptions(ErrorCodesAndMessages.ErrorCodes.IMS001.toString(), ErrorCodesAndMessages.IMS001_MESSAGE, this.getClass(), "createInventory", e);
		}finally{
			logger.info("Exiting updateItemStock at : "+System.currentTimeMillis());
		}
	}
	
	public int checkoutItem(int quantity, int itemId, double cost, String desc) throws InventoryNotFoundException,InventorySystemExceptions,ItemValidationException{
		logger.info("Entering checkoutItem at : "+System.currentTimeMillis());
		try{
			InventoryService service = ServicesFactory.createInventoryService();
			Items item = new Items();
			item.setId(itemId);
			item.setStock(quantity);
			item.setCost(cost);
			item.setName(desc);
			Validator.validateItemRequest(item);
			return service.checkoutItem(item);
		}catch(InventoryNotFoundException | InventorySystemExceptions  | ItemValidationException e){
			throw e;
		}catch(Exception e){
			throw new InventorySystemExceptions(ErrorCodesAndMessages.ErrorCodes.IMS001.toString(), ErrorCodesAndMessages.IMS001_MESSAGE, this.getClass(), "createInventory", e);
		}finally{
			logger.info("Exiting checkoutItem at : "+System.currentTimeMillis());
		}
	}
	
	public List<Items> generateInventoryReport() throws InventorySystemExceptions{
		logger.info("Entering createInventory at : "+System.currentTimeMillis());
		try{
			InventoryService service = ServicesFactory.createInventoryService();
			return service.generateInventoryReport();
		}catch(InventorySystemExceptions systemExcep){
			throw systemExcep;
		}catch(Exception e){
			throw new InventorySystemExceptions(ErrorCodesAndMessages.ErrorCodes.IMS001.toString(), ErrorCodesAndMessages.IMS001_MESSAGE, this.getClass(), "createInventory", e);
		}finally{
			logger.info("Exiting createInventory at : "+System.currentTimeMillis());
		}
	}
}

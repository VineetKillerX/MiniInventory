package com.demo.inventory.utils;

import org.apache.log4j.Logger;

import com.demo.inventory.constants.ErrorCodesAndMessages;
import com.demo.inventory.exception.ItemValidationException;
import com.demo.inventory.model.Items;

public class Validator {
	final static Logger logger = Logger.getLogger(Validator.class);
	public static void validateItemRequest(Items item) throws ItemValidationException{
		logger.info("Entering validateItemRequest at : "+System.currentTimeMillis());
		if(item==null || item.getId()==0){
			throw new ItemValidationException(ErrorCodesAndMessages.ErrorCodes.ITM001.toString(), ErrorCodesAndMessages.ITM001_MESSAGE);
		}
		if(item.getStock()<0){
			throw new ItemValidationException(ErrorCodesAndMessages.ErrorCodes.ITM002.toString(), ErrorCodesAndMessages.ITM002_MESSAGE);
		}
		if(item.getCost()<0){
			throw new ItemValidationException(ErrorCodesAndMessages.ErrorCodes.ITM003.toString(), ErrorCodesAndMessages.ITM003_MESSAGE);
		}
		
	}
	
}

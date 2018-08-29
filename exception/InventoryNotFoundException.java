package com.demo.inventory.exception;

import org.apache.log4j.Logger;

public class InventoryNotFoundException extends Exception {

	final static Logger logger = Logger.getLogger(InventoryNotFoundException.class);
	
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMsg;
	
	public InventoryNotFoundException(String string,String msg,Class fromClass,String methodName,Exception e){
		this.errorCode = string;
		this.errorMsg = msg;
		logger.error("Exception occurred for method : "+ methodName +" in class : "+fromClass.getName()+" with errorCode as : "+string+" and the Exception being : "+e);
	}
	
	public InventoryNotFoundException(String code,String message){
		this.errorCode = code;
		this.errorMsg = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
	
}

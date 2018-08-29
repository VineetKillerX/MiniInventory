package com.demo.inventory.exception;

import org.apache.log4j.Logger;

public class InventorySystemExceptions extends Exception {

	final static Logger logger = Logger.getLogger(InventorySystemExceptions.class);
	
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMsg;
	
	public InventorySystemExceptions(String code,String msg,Class fromClass,String methodName,Exception e){
		this.errorCode = code;
		this.errorMsg = msg;
		logger.error("InventorySystemExceptions occurred for method : "+ methodName +" in class : "+fromClass.getName()+" with errorCode as : "+code+" and the Exception being : "+e);
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

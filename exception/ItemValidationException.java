package com.demo.inventory.exception;

import org.apache.log4j.Logger;

public class ItemValidationException extends Exception {

	final static Logger logger = Logger
			.getLogger(InventorySystemExceptions.class);

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMsg;

	public ItemValidationException(String code, String msg, Class fromClass,
			String methodName, Exception e) {
		this.errorCode = code;
		this.errorMsg = msg;
		logger.error("InventorySystemExceptions occurred for method : "
				+ methodName + " in class : " + fromClass.getName()
				+ " with errorCode as : " + code
				+ " and the Exception being : " + e);
	}

	public ItemValidationException(String code, String message) {
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

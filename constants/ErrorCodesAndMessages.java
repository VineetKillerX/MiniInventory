package com.demo.inventory.constants;

public class ErrorCodesAndMessages {
	public enum ErrorCodes{
		IMS001,IMS002,IMS003,IMS004,IMS005,
		ITM001,ITM002,ITM003
	}
	
	public static String IMS001_MESSAGE = "Some System Error Occurred while processing your request. Please try again later!";
	public static String IMS002_MESSAGE = "No Inventory Found to Add or Remove an Item. Please create an Inventory to continue";
	public static String IMS003_MESSAGE = "Item in Stock are less than the desired Items for Checkout. Please reduce the quantity and try again!";
	public static String IMS004_MESSAGE = "Item you are trying to Checkout is not available in the Inventory. Please check the correct item and try again!";
	public static String IMS005_MESSAGE = "You have no items left in the Inventory";
	
	
	public static String ITM001_MESSAGE = "You have entered an Invalid Item";
	public static String ITM002_MESSAGE = "The Quantity entered is Invalid";
	public static String ITM003_MESSAGE = "Cost for any Item cannot be less than Zero, Please enter a valid cost";
}

package com.demo.inventory.utils;

import java.util.List;
import java.util.Scanner;

import com.demo.inventory.InventoryApplicationFactory;
import com.demo.inventory.exception.InventoryNotFoundException;
import com.demo.inventory.exception.InventorySystemExceptions;
import com.demo.inventory.exception.ItemValidationException;
import com.demo.inventory.model.Items;

public class ConsoleUtility {
	static InventoryApplicationFactory appFactory = new InventoryApplicationFactory();
	public static void showBanner(){
		System.out.println("==================================================================");
		System.out.println("==================================================================");
		System.out.println("====================INVENTORY MANAGEMENT SYSTEM===================");
		System.out.println("==================================================================");
		System.out.println("==================================================================");
	}
	
	public static void printChoices(){
		System.out.println("==================================================================");
		System.out.println(" 1) Create an Inventory");
		System.out.println(" 2) Update an Item in Inventory");
		System.out.println(" 3) Checkout an Item");
		System.out.println(" 4) Get Inventory Report");
		System.out.println(" 0) Main Screen");
		System.out.println(" Enter 99 to Exit the Application");
		System.out.println("==================================================================");		
	}
	
	public static void readChoices(Scanner scan) throws InventorySystemExceptions, InventoryNotFoundException, ItemValidationException{
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			if(appFactory.createInventory()==1){
				System.out.println("Inventory Created Successfully");
			}
			else{
				System.out.println("Inventory already Exists");
			}
			break;
		case 2:
			int id = getItemId(scan);
			int quantity = getStock(scan);
			double cost = getCost(scan);
			String name = getDesc(scan);
			if(appFactory.updateItemStock(quantity, id, cost, name)>=1){
				System.out.println("Item Updated Successfully");
			}
			else{
				System.out.println("Update Failed");
			}
			break;
		case 3:
			int idRemove = getItemId(scan);
			int quantityRemove = getStock(scan);
			double costRemove = getCost(scan);
			String nameRemove = getDesc(scan);
			if(appFactory.checkoutItem(quantityRemove, idRemove, costRemove, nameRemove)>=1){
				System.out.println("Item CheckedOut Successfully");
			}
			else{
				System.out.println("checkout Failed");
			}
			break;
		case 4:
			List<Items> itemliist = appFactory.generateInventoryReport();
			System.out.println("Item ID        Description        Quantity in Stock           Price Per Unit");
			for (Items items : itemliist) {
				System.out.println(items.getId()+"         "+items.getName()+"         "+items.getStock()+"           "+items.getCost());
			}
			break;	
		case 0:
			printChoices();
			break;

		default:
			System.out.println("Please enter a Valid choice to continue");
			break;
		}
		System.out.println("Enter any number to continue");
	}

	private static int getItemId(Scanner scan) {
		System.out.println("Item ID : ");
		return scan.nextInt();	
	}
	private static int getStock(Scanner scan) {
		System.out.println("Quantity : ");
		return scan.nextInt();	
	}
	private static int getCost(Scanner scan) {
		System.out.println("Cost per Item : ");
		return scan.nextInt();	
	}
	private static String getDesc(Scanner scan) {
		System.out.println("Description : ");
		return scan.next();	
	}
}

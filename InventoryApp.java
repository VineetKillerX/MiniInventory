package com.demo.inventory;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.demo.inventory.exception.InventoryNotFoundException;
import com.demo.inventory.exception.InventorySystemExceptions;
import com.demo.inventory.exception.ItemValidationException;
import com.demo.inventory.utils.ConsoleUtility;

public class InventoryApp {

	final static Logger logger = Logger.getLogger(InventoryApp.class);

	public static void main(String[] args) throws InventorySystemExceptions, InventoryNotFoundException, ItemValidationException {
		Scanner scanner = new Scanner(System.in);
		try {
			ConsoleUtility.showBanner();
			System.out.println("Enter any number to continue");
			logger.info("Starting Application Inventory Management System at : "
					+ System.currentTimeMillis());
			while (scanner.nextInt() != 99) {
				ConsoleUtility.printChoices();
				ConsoleUtility.readChoices(scanner);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Enter any number to continue");
			while (scanner.nextInt() != 99) {
				ConsoleUtility.printChoices();
				ConsoleUtility.readChoices(scanner);
			}
		} finally {
			logger.info("Exiting Application Inventory Management System at : "
					+ System.currentTimeMillis());
		}
	}
}

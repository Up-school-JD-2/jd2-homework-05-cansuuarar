package com.cansu.homework05;

import java.util.Scanner;

public class PaymentOperationMain {

	static boolean repeat = false;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		

		while(!repeat) {
			try {
				System.out.print("Enter total price: ");
				int price = sc.nextInt();
				if (!isValidPrice(price)) {
					throw new InvalidAmountException("invalid payment type!");
				}

				

				System.out.print("\nEnter credit card number: ");
				String cardNumber = sc.next();
				if (!isValidCardNumber(cardNumber)) {
					throw new InvalidCardNumberException("Invalid card number!");
				}

				

				System.out.print("\nEnter expire date of card ");
				System.out.print("\nMM: ");
				
				
				int month = sc.nextInt(); 
				System.out.print("\nYYYY: ");
				int year = sc.nextInt();

				
				if (!isValidDate(month, year)) {
					throw new InvalidExpireDateException("Invalid expire date!");
				}

				

				System.out.print("\nEnter securtiy number of card: ");
				String securityNumber = sc.next();
				if (!isValidSecurityNumber(securityNumber)) {
					throw new InvalidSecurityNumberException("Invalid securtiy number!");
				}

				pay();

			} catch (InvalidAmountException | InvalidCardNumberException | InvalidExpireDateException
					| InvalidSecurityNumberException e) {
				System.out.println(e.getMessage());
			} catch (SystemNotWorkingException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static boolean isValidPrice(int price) {

		if (price < 0) {
			return false;
		}

		return true;

	}

	public static boolean isValidCardNumber(String cardNumber) {
		boolean isValidCard = true;

		if (cardNumber.length() != 16) {
			isValidCard = false;
		}

		for (char c : cardNumber.toCharArray()) {
			if (!Character.isDigit(c)) {
				isValidCard = false;
			}
		}

		return isValidCard;

	}

	public static boolean isValidDate(int month, int year) {
		boolean isValidDate = false;

		if (month >= 1 && month <= 12 && year >= 2023 && year <= 9999) {
			isValidDate = true;
		}

		return isValidDate;

	}

	public static boolean isValidSecurityNumber(String securityNumber) {
		boolean isValidSecurty = true;

		if (securityNumber.length() != 3) {
			isValidSecurty = false;
		}

		for (char c : securityNumber.toCharArray()) {
			if (!Character.isDigit(c)) {
				isValidSecurty = false;
			}
		}

		return isValidSecurty;
	}

	public static void pay() throws SystemNotWorkingException {

		int number = (int) (Math.random() * 100);

		if (number >= 75) {
			System.out.println(number + " is higher than 75. Please rerun operation.");
			throw new SystemNotWorkingException("higher than 75 exception.");
		} else {
			repeat = true;
			System.out.println(number + " is lower than 75. Operation is done.");
		}

	}

}

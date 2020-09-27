package com.cg;

import java.util.*;

public class AddressBookMain {

	public static void main(String[] args) {
		AddressBook addressBook  = new AddressBook();
		try {
			System.out.println("Welcome to Address Book Program");
			System.out.println("--------------------------------");
			Scanner sc = new Scanner(System.in);
			Contact contact = new Contact();
			System.out.println("Want to add contact details: (1. Yes, 2. No)");
			int option = Integer.parseInt(sc.nextLine());
			if (option == 2)
				return;
			System.out.println("First Name:");
			contact.setFirstName(sc.nextLine());
			System.out.println("Last Name:");
			contact.setLastName(sc.nextLine());
			System.out.println("Address:");
			contact.setAddress(sc.nextLine());
			System.out.println("City:");
			contact.setCity(sc.nextLine());
			System.out.println("State:");
			contact.setState(sc.nextLine());
			System.out.println("Zip:");
			contact.setZip(Integer.parseInt(sc.nextLine()));
			System.out.println("Phone Number:");
			contact.setPhoneNumber(sc.nextLine());
			System.out.println("Email:");
			contact.setEmail(sc.nextLine());
			
			addressBook.addContact(contact);
			System.out.println("\nContacts in Address Book:");
			System.out.println(addressBook);

		} catch (Exception e) {
			System.out.println("Entered invalid values. Retry again");
		}
	}
}

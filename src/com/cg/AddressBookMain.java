package com.cg;

import java.util.*;

public class AddressBookMain {

	public static void main(String[] args) {
		AddressBook addressBook  = new AddressBook();
		Scanner sc = new Scanner(System.in);
		Contact contact;
		String name;
		int option;
		try {
			boolean repeat = true;
			while(repeat) {
				System.out.println("Welcome to Address Book Program");
				System.out.println("--------------------------------");
				System.out.println("Options:\n1 (add new contact)\n2 (edit existing contact)\n3 (do nothing)");
				option = Integer.parseInt(sc.nextLine());
				switch(option){
				case 1:
					contact = new Contact();
					System.out.println("First Name:");
					contact.setFirstName(sc.nextLine());
					System.out.println("Last Name:");
					contact.setLastName(sc.nextLine());
					
					name = contact.getName();
					if (addressBook.searchByName(name)!=null) {
						System.out.println("Contact for entered name is already exist");
						break;
					}
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
					System.out.println("\nContact is added");
					System.out.println(contact);
					break;
				case 2:
					System.out.println("Enter name to edit contact: ");
					System.out.println("First Name:");
					String firstName = sc.nextLine();
					System.out.println("Last Name:");
					String lastName = sc.nextLine();
					
					name = firstName+" "+lastName;
					contact = addressBook.searchByName(name);
					if (contact==null) {
						System.out.println("Contact for given name is not found");
						break;
					}
					System.out.println("Choose option to edit:\n1 First Name\n2 Last Name\n3 address\n4 city\n5 state\n6 zip\n7 phone number\n8 email \n9 skip");
					option = Integer.parseInt(sc.nextLine());
					switch(option) {
					case 1:
						System.out.println("First Name:");
						contact.setFirstName(sc.nextLine());
						break;
					case 2:
						System.out.println("Last Name:");
						contact.setLastName(sc.nextLine());
						break;
					case 3:
						System.out.println("Address:");
						contact.setAddress(sc.nextLine());
						break;
					case 4:
						System.out.println("City:");
						contact.setCity(sc.nextLine());
						break;
					case 5:
						System.out.println("State:");
						contact.setState(sc.nextLine());
						break;
					case 6:
						System.out.println("Zip:");
						contact.setZip(Integer.parseInt(sc.nextLine()));
						break;
					case 7:
						System.out.println("Phone Number:");
						contact.setPhoneNumber(sc.nextLine());
						break;
					case 8:
						System.out.println("Email:");
						contact.setEmail(sc.nextLine());
						break;
					default:
						break;
					}
					addressBook.editContact(name, contact);
					System.out.println("\nSuccessfully edited");
					System.out.println(contact);
					break;
				default:
					break;
				}
				System.out.println("Continue(1) or exit(2):");
				if (Integer.parseInt(sc.nextLine())==2)
					repeat = false;
			}
		} catch (Exception e) {
			System.out.println("Entered invalid values. Retry again");
		}
	}
}

package com.cg;

import java.util.*;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, AddressBook> addressBookSystem = new HashMap<String, AddressBook>();

	public static void addAddressBookContacts(String addressBookName) {
		AddressBook addressBook = addressBookSystem.get(addressBookName);
		System.out.println("Enter the number of contacts to add: ");
		int count = Integer.parseInt(sc.nextLine());
		while (count-- > 0) {
			Contact contact = new Contact();
			System.out.println("First Name:");
			contact.setFirstName(sc.nextLine());
			System.out.println("Last Name:");
			contact.setLastName(sc.nextLine());
			String name = contact.getName();
			if (addressBook.searchByName(name) != null) {
				System.out.println("Contact for entered name is already exist\n");
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
		}
		System.out.println("\nContacts are added\n");
		addressBookSystem.replace(addressBookName, addressBook);
	}

	public static void editAddressBookContact(String addressBookName) {
		AddressBook addressBook = addressBookSystem.get(addressBookName);
		System.out.println("Enter name to edit contact: ");
		System.out.println("First Name:");
		String firstName = sc.nextLine();
		System.out.println("Last Name:");
		String lastName = sc.nextLine();
		String name = firstName + " " + lastName;

		Contact contact = addressBook.searchByName(name);
		if (contact == null) {
			System.out.println("Contact for given name is not found\n");
			return;
		}
		System.out.println(
				"Choose option to edit:\n1 First Name\n2 Last Name\n3 address\n4 city\n5 state\n6 zip\n7 phone number\n8 email \n9 skip");
		int option = Integer.parseInt(sc.nextLine());
		switch (option) {
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
		System.out.println(contact + "\n");
		addressBookSystem.replace(addressBookName, addressBook);
	}

	public static void deleteAddressBookContact(String addressBookName) {
		AddressBook addressBook = addressBookSystem.get(addressBookName);
		System.out.println("Enter name of the contact to delete: ");
		System.out.println("First Name:");
		String firstName = sc.nextLine();
		System.out.println("Last Name:");
		String lastName = sc.nextLine();

		String name = firstName + " " + lastName;
		Contact contact = addressBook.searchByName(name);
		if (contact != null)
			addressBook.editContact(name, null);
		System.out.println("\nSuccessfully deleted contact\n");
		addressBookSystem.replace(addressBookName, addressBook);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		System.out.println("--------------------------------");
		try {
			int bookOptions = 0;
			boolean bookRepeat = true;
			while (bookRepeat) {
				System.out.println(
						"Main Options:\n1 (add new AddressBook)\n2 (view or open existing AddressBook)\n3 (exit)");
				bookOptions = Integer.parseInt(sc.nextLine());

				switch (bookOptions) {
				case 1:
					System.out.println("Enter the name of address Book:");
					String newAddressBook = sc.nextLine();
					addressBookSystem.putIfAbsent(newAddressBook, new AddressBook());
					break;
				case 2:
					StringBuilder str = new StringBuilder();
					int count = 1;
					for (String key : addressBookSystem.keySet()) {
						str.append(count + ". " + key + "\n");
						count++;
					}
					if (str.length() == 0) {
						System.out.println("There is no Address Book. Add New(1) Exit(2) ");
						break;
					}
					System.out.println("List of Existing AddressBooks:\n" + str.toString());

					System.out.println("Enter the name of addressBook you want to work on:");
					String addressBookName = sc.nextLine();
					if (!addressBookSystem.containsKey(addressBookName))
						break;
					boolean repeat = true;
					while (repeat) {
						System.out.println(
								"\nAddress Book Options:\n1 (add new contacts)\n2 (edit existing contact)\n3 (delete a contact)\n4 (view all contact)\n5 (go out of current AddressBook");
						int option = Integer.parseInt(sc.nextLine());
						switch (option) {
						case 1:
							addAddressBookContacts(addressBookName);
							break;
						case 2:
							editAddressBookContact(addressBookName);
							break;
						case 3:
							deleteAddressBookContact(addressBookName);
							break;
						case 4:
							System.out.println(addressBookSystem.get(addressBookName));
							System.out.println("Enter the name of contact to view:");
							System.out.println(addressBookSystem.get(addressBookName).searchByName(sc.nextLine()) + "\n");
							break;
						case 5:
							repeat = false;
						}
					}
					break;
				default:
					bookRepeat = false;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Entered invalid values. Retry again");
		}
	}
}

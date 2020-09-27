package com.cg;

import java.util.ArrayList;

public class AddressBook {
	private ArrayList<Contact> addressList = new ArrayList<Contact>();

	public void setAddressList(ArrayList<Contact> addressList) {
		this.addressList = addressList;
	}

	public ArrayList<Contact> getAddressList() {
		return addressList;
	}

	public void addContact(Contact contact) {
		addressList.add(contact);
	}

	public Contact searchByName(String name) {
		for (int i = 0; i<addressList.size(); ++i) {
			if (addressList.get(i).getName().contains(name))
				return addressList.get(i);
		}
		return null;
	}
	
	public void editContact(String name, Contact contact) {
		for (int i = 0; i<addressList.size(); ++i) {
			if (addressList.get(i).getName().contains(name))
				addressList.set(i, contact);
		}
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		int count = 1;
		for (Contact contact : addressList) {
			str.append(count+". "+contact.getFirstName()+" "+contact.getLastName()+"\n");
			count++;
		}
		return str.toString();
	}
}

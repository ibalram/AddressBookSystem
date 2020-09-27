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

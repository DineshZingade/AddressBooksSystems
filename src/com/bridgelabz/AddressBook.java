package com.bridgelabz

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

	Scanner sc = new Scanner(System.in);

	// Create an object of arraylist
	ArrayList<ContactPerson> addressBook1 = new ArrayList<>();

	public ContactPerson createContact() {
		ContactPerson person = new ContactPerson();// creating object of ContactPerson class
		System.out.print("Enter First Name: ");
		person.setFirstName(sc.next());// using object reference calling setFirstName method to set first name
		System.out.print("Enter Last Name: ");
		person.setLastName(sc.next());
		System.out.print("Enter Address: ");
		person.setAddress(sc.next());
		System.out.print("Enter City: ");
		person.setCity(sc.next());
		System.out.print("Enter State: ");
		person.setState(sc.next());
		System.out.print("Enter email: ");
		person.setEmail(sc.next());
		System.out.print("Enter ZipCode: ");
		person.setZipCode(sc.nextInt());
		System.out.print("Enter Phone Number: ");
		person.setPhoneNumber(sc.nextLong());
		System.out.println("created new contact");
		return person;
	}

	// Add new contacts to address book
	public void addContact() {
		ContactPerson contactPerson = createContact();// call createContact method and store in contactPerson
		addressBook1.add(contactPerson);// using arraylist object reference call add method
		System.out.println(contactPerson);// print contact details of person
		System.out.println("Contact added successfully");
	}

	/*
	 * Edit contact if contact found then edit otherwise no contact found message
	 */
	public void editContact() {
		boolean isContactFound = false;
		System.out.println("Enter Name to edit Contact");
		String name = sc.next();
		for (ContactPerson contactPerson : addressBook1) { // iterate over the arraylist
			if (name.equalsIgnoreCase(contactPerson.getFirstName())) {
				isContactFound = true;
				System.out.print("Enter First Name :");
				contactPerson.setFirstName(sc.next());
				System.out.print("Enter Last Name :");
				contactPerson.setLastName(sc.next());
				System.out.print("Enter Address :");
				contactPerson.setAddress(sc.next());
				System.out.print("Enter City :");
				contactPerson.setCity(sc.next());
				System.out.print("Enter State :");
				contactPerson.setState(sc.next());
				System.out.print("Enter email :");
				contactPerson.setEmail(sc.next());
				System.out.print("Enter ZipCode :");
				contactPerson.setZipCode(sc.nextInt());
				System.out.print("Enter Phone Number :");
				contactPerson.setPhoneNumber(sc.nextLong());
				System.out.println(contactPerson);
				break;
			}
		}
		if (isContactFound) {
			System.out.println("Contact Updated Successfully..");
		} else {
			System.out.println("Oops...Contact not found");
		}
	}

	/*
	 * Delete contact if contact found then delete that contact if no contact found
	 * then message will be display as...contact not found
	 */
	public void deleteContact() {

		boolean isContactFound = false;
		System.out.println("enter name to delete contact");
		String name = sc.next();
		for (ContactPerson contactPerson : currentAddressBook) {
			if (contactPerson.getFirstName().equalsIgnoreCase(name)) {
				System.out.println("contact found:");
				isContactFound = true;
				System.out.println(contactPerson);
				System.out.println("confirm to delete (y/n)");
				if (sc.next().equalsIgnoreCase("y")) {
					currentAddressBook.remove(contactPerson);
					System.out.println("contact deleted");
				}
				break;
			}
		}
		if (!isContactFound) {
			System.out.println("Opps... contact not found");
		}
	}

	void displayContact() {
		if (addressBook1.isEmpty()) {
			System.out.println("No contacts to display");
		} else {
			for (ContactPerson contactPerson : addressBook1) {
				System.out.println(contactPerson);
			}
		}
	}
}
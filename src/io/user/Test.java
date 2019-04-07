package io.user;

import java.util.ArrayList;
import java.util.Scanner;

import dto.Contact;
import dto.User;

public class Test {

	private static Scanner input=new Scanner(System.in);

	public static void login() {
		System.out.print("Uesite ime:");
		String name=input.nextLine();
		System.out.print("prezime:");
		String surname=input.nextLine();
		System.out.print("password:");
		String password=input.nextLine();
		User user=new User(name, surname, password);
		menu(user);
	}

	public static void register() {
		System.out.print("Uesite ime:");
		String name=input.nextLine();
		System.out.print("prezime:");
		String surname=input.nextLine();
		System.out.print("password:");
		String password=input.nextLine();
		System.out.print("password(ponovo):");
		String passwordTake2=input.nextLine();
		User user=null;
		if(password==passwordTake2)
			user=new User(name, surname, password);
		else
			System.out.println("Passwordi nisu identicni");

		menu(user);
	}

	public static Contact contactInfo(User user) {
		System.out.print("ime:");
		String name=input.nextLine();
		System.out.println("prezime:");
		String surname=input.nextLine();
		System.out.println("broj telefona:");
		int phoneNum=input.nextInt();
		System.out.println("email");
		String email=input.next();
		System.out.println("adresa:");
		String adress=input.nextLine();
		return new Contact(name, surname, phoneNum, email, adress, user.getId());
	}

	public static void menu(User user) {
		byte choice;
		do {
			System.out.println("1. Dodaj novi kontakt");
			System.out.println("2. Izbirisi kontakt");
			System.out.println("3. Ispisi kontakte");
			System.out.println("4. pronadji kontakt");
			System.out.println("5. povratak");
			choice=input.nextByte();

			switch (choice) {
			case 1:
				Contact contact=contactInfo(user);
				user.addContact(contact);
				break;

			case 2:
				contact=contactInfo(user);
				user.removeContact(contact.getId());
				break;

			case 3:
				ArrayList<Contact> contacts=user.getContacts();

				for(int i=0; i<contacts.size(); i++) {
					contact=contacts.get(i);
					System.out.println(contact.toString());
				}
				break;

			case 4:
				System.out.print("Unesite kontakt koji trazite:");

				break;
			}
		}while(choice!=5);
	}

	public static void main(String[] args) {
		byte choice;
		do {
			System.out.println("Choose one:");
			System.out.println("1. log in");
			System.out.println("2. register");
			System.out.println("0. exit");
			choice=input.nextByte();

			if(choice==1) 
				login();
			else if(choice==2)
				register();

		}while(choice!=0);

	}

}

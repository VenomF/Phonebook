package dto;

import java.util.ArrayList;

public class User extends Account{
	
	private static ArrayList<User> users=new ArrayList<User>();
	private int password;
	private ArrayList<Contact> contacts=new ArrayList<Contact>();
	
	public User(String name, String surname, String password) {
		super(name, surname);
		this.password=password.hashCode();
	}
	
	public ArrayList<Contact> getContacts(){
		return this.contacts;
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean autenticate(String password) {
		int passwordHash=password.hashCode();
		if(this.password==passwordHash)
			return true;
		else return false;
		
	}
	
	public void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	public void removeContact(int id) {
		int contactIndex=getContactIndex(id);
		
		if(contactIndex > 0)
			contacts.remove(contactIndex);
	}
	
	public Contact findContact(int id) {
		int contactIndex=getContactIndex(id);
		return contacts.get(contactIndex);
	}
	
	private int getContactIndex(int id) {
		for(int i=0; i<contacts.size(); i++) {
			if(contacts.get(i).id==id)
				return i;
		}
		
		return 0;
	}
	
	public void saveContacts() {
		
	}
	
	public static void saveUsers() {
		
	}

}

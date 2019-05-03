package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.Contact;
import dto.User;

public interface UserInterface {
	
	public ArrayList<User> getAllUsers() throws SQLException;

	public void addUser(String name, String surname, String password) throws SQLException;
	
	public ArrayList<Contact> getAllContacts(int userId) throws SQLException;
	
	public void addContact()

}

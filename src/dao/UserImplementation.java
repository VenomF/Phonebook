package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.User;

public class UserImplementation implements UserInterface {
		
		Connection connection = ConnectionManager.getInstance().getConnection();

		@Override
		public ArrayList<User> getAllUsers() throws SQLException {

			ArrayList<User> users = new ArrayList<>();

			String query = "SELECT * FROM users";

			ResultSet rs = null;

			try (Statement statement = connection.createStatement();) {

				rs = statement.executeQuery(query);

				while (rs.next())
					users.add(
							new User(rs.getString("name"), rs.getString("surname"), rs.getInt("password")));

			}

			return users;
		}

		@Override
		public void addUser(String name, String surname, String password) throws SQLException {

			String query = "INSERT INTO korisnici(imeKorisnika, prezimeKorisnika, password) VALUES (?, ?, ?)";

			try (PreparedStatement statement = connection.prepareStatement(query);) {

				statement.setString(1, name);
				statement.setString(2, surname);
				statement.setString(3, password);

				statement.executeUpdate();

			}
		}

}

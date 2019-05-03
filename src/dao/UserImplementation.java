package dao;

import java.io.BufferedReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.User;

public class UserImplementation {
	
	public static ArrayList<User> readUSersFromDB(ResultSet resultSet) throws SQLException{
		
		while(resultSet.next()) {
			BufferedReader reader=new BufferedReader(in)
		}
		
	}

}

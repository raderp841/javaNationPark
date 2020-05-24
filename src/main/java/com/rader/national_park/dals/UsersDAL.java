package main.java.com.rader.national_park.dals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.com.rader.national_park.models.UserModel;

public class UsersDAL extends DAL{

	public UserModel getUserByUsernamePassword(String username, String password){
		List<UserModel> users = new ArrayList<UserModel>();
		String sqlStatement = "SELECT * FROM userinfo where username = '"+ username + "' and password = '"+ password + "'";
		try (Connection conn = getConnection();
			 Statement statement = conn.createStatement();) {
			ResultSet result = statement.executeQuery(sqlStatement);
			
			while(result.next()) {
				int id = result.getInt("id");
				String usern = result.getString("username");
				String pass = result.getString("password");
				users.add(new UserModel(id, usern, pass));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return (users.size() > 0) ? users.get(0) : new UserModel();
	}
	
	public boolean saveUser(String username, String password) {
		boolean successfulSave = false;
		try {
			Connection conn = getConnection();
			Statement statement = conn.createStatement();
			int rowsAffected = statement.executeUpdate("insert into userInfo(username, password) values('" + username + "','" + password + "')");
			successfulSave = rowsAffected > 0;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return successfulSave;
	}
}


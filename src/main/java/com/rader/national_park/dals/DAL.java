package main.java.com.rader.national_park.dals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAL {

	private final String url = "[REPLCE WITH CONNECTION STRING]";

	public String getUrl() {
		return url;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, "root", "[REPLACE WITH PASSWORD TO MYSQL]");
	}
}

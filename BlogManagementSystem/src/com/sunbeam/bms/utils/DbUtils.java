package com.sunbeam.bms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	// Database URL, username, and password
	public static final String DB_URL = "jdbc:mysql://localhost:3306/bms";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "manager";

	// Get a connection to the database
	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			// Attempt to establish a connection to the database
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			// If connection fails, print error message and throw exception
			System.err.println("Failed to connect to the database: " + e.getMessage());
			throw e;
		}
		return connection;
	}
}

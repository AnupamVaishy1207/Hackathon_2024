package com.sunbeam.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunbeam.bms.pojo.UserDetails;
import com.sunbeam.bms.utils.DbUtils;

public class UserDao implements AutoCloseable {
	private Connection connection;

	// Constructor to initialize the connection
	public UserDao() throws SQLException {
		// Obtain the database connection
		connection = DbUtils.getConnection();
	}

	// Method to register a new user
	public void registerUser(UserDetails user) throws SQLException {
		String query = "insert into user (full_name,email,password,phone_no) VALUES (?,?,?,?)";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			// Set parameters for the prepared statement
			st.setString(1, user.getFullName());
			st.setString(2, user.getEmail());
			st.setString(3, user.getPassword());
			st.setString(4, user.getPhone());
			// Execute the insert query
			st.executeUpdate();
		} catch (Exception e) {
			// Print error message and stack trace
			System.out.println("@@@@Record insertion error in Registration(registerUser()) UserDAO@@@@");
			e.printStackTrace();
		}
	}

	// Method to authenticate a user
	public boolean authenticate(String email, String password) throws Exception {
		boolean isUser = false;
		String sql = "select email, password from user where email=? and password=?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			// Set parameters for the prepared statement
			statement.setString(1, email);
			statement.setString(2, password);
			// Execute the query and retrieve the result set
			ResultSet result = statement.executeQuery();
			// Check if user exists and password matches
			if (result.next()) {
				isUser = true;
				System.out.println("User authenticated successfully");
			} else {
				System.out.println("Invalid username or password!");
			}
		} catch (Exception e) {
			// Print error message and stack trace
			System.out.println("DB related Error");
			e.printStackTrace();
		}
		return isUser;
	}

	// Method to check if a user already exists
	public boolean CheckUserExists(String username) throws SQLException {
		boolean userNameExists = false;
		String sql = "select * from user";
		try (PreparedStatement st = connection.prepareStatement(sql)) {
			// Execute the query and retrieve the result set
			ResultSet rs = st.executeQuery();
			String userNameCompare;
			if (rs.next()) {
				userNameCompare = rs.getString(3);
				// Check if username exists
				if (userNameCompare.equals(username)) {
					System.out.println("User already Exists. Press 1 for Login.");
					userNameExists = true;
				} else {
					System.out.println("@@@@You Enter Duplicate Email Please Enter @@@@");
				}
			}
		}
		return userNameExists;
	}

	// Method to close the database connection
	@Override
	public void close() throws Exception {
		// Close the connection
		connection.close();
	}
}

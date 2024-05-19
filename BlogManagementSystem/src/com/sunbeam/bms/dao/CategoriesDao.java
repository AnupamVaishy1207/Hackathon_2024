package com.sunbeam.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.bms.pojo.CategoryDetails;
import com.sunbeam.bms.utils.DbUtils;

// DAO class for managing categories
public class CategoriesDao implements AutoCloseable {
	private Connection connection;

	// Constructor to initialize the connection
	public CategoriesDao() throws SQLException {
		// Obtain the database connection
		connection = DbUtils.getConnection();
	}

	// Method to add a new category
	public void AddCategory(String title, String description) throws SQLException {
		// SQL query to insert category details
		String query = "insert into categories (title, description) VALUES (?, ?)";
		try (PreparedStatement st = connection.prepareStatement(query)) {
			// Set parameters for the prepared statement
			st.setString(1, title);
			st.setString(2, description);
			// Execute the insert query
			st.executeUpdate();
		} catch (Exception e) {
			// Print error message and stack trace
			System.out.println("@@@@Add Category error in CategoriesDao(AddCategory()) CategoriesDao@@@@");
			e.printStackTrace();
		}
	}

	// Method to retrieve all categories
	public List<CategoryDetails> getAllCategory() throws SQLException {
		// Initialize a list to store category details
		List<CategoryDetails> list = new ArrayList<>();

		// SQL query to select all categories
		String sql = "select * from  categories";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			// Execute the query and retrieve the result set
			ResultSet rs = stmt.executeQuery();

			// Process each row in the result set
			while (rs.next()) {
				CategoryDetails cat = new CategoryDetails();
				// Set the properties of the CategoryDetails object from the result set
				cat.setId(rs.getInt(1));
				cat.setTitle(rs.getString(2));
				cat.setDescription(rs.getString(3));
				// Add the CategoryDetails object to the list
				list.add(cat);
			}

			// Return the list of categories
			return list;
		}
	}

	// Method to close the database connection
	@Override
	public void close() throws Exception {
		// Close the connection
		connection.close();
	}
}

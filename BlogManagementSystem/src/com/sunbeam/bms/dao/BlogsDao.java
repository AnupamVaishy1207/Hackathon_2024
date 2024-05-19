package com.sunbeam.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.bms.pojo.BlogsDetails;
import com.sunbeam.bms.utils.DbUtils;

public class BlogsDao {
	private Connection connection;

	// Constructor to initialize the connection
	public BlogsDao() {
		try {
			// Obtain the database connection
			connection = DbUtils.getConnection(); // Handling SQLException here or with proper error logging
		} catch (SQLException e) {
			// Handle the exception appropriately
			e.printStackTrace();
		}
	}

	// Method to add a new blog entry
	public void addBlog(String title, String contents, int userid, int category) throws SQLException {
		String sql = "INSERT INTO blogs(title, contents, userid, category) values(?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql);) {
			// Set parameters for the prepared statement
			stmt.setString(1, title);
			stmt.setString(2, contents);
			stmt.setInt(3, userid);
			stmt.setInt(4, category);
			// Execute the insert query
			stmt.executeUpdate();
		}
	}

	// Method to search for blogs by title
	public List<BlogsDetails> searchBlog(String title) throws SQLException {
		String sql = "SELECT title, contents FROM blogs WHERE title=?";
		List<BlogsDetails> b = new ArrayList<>();
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			// Set the title parameter for the prepared statement
			stmt.setString(1, title);
			// Execute the query and retrieve the result set
			ResultSet rs = stmt.executeQuery();
			// Process each row in the result set
			while (rs.next()) {
				BlogsDetails blogsDetails = new BlogsDetails();
				// Set the title and content from the result set
				blogsDetails.setTitle(rs.getString(1)); // Index should start from 1
				blogsDetails.setContent(rs.getString(2)); // Index should start from 1
				// Add the BlogsDetails object to the list
				b.add(blogsDetails);
			}
		}
		// Return the list of blogs
		return b;
	}

	// Method to retrieve all blogs
	public List<BlogsDetails> Allblogs() throws SQLException {
		String sql = "SELECT * FROM blogs"; // Corrected SQL query
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			// Execute the query and retrieve the result set
			ResultSet rs = stmt.executeQuery();
			// Initialize a list to store the retrieved blogs
			List<BlogsDetails> blogsList = new ArrayList<>();
			// Process each row in the result set
			while (rs.next()) {
				BlogsDetails blogsDetails = new BlogsDetails();
				// Set the properties of the BlogsDetails object from the result set
				blogsDetails.setId(rs.getInt(1));
				blogsDetails.setTitle(rs.getString(2));
				blogsDetails.setContent(rs.getString(3));
				blogsDetails.setCreatedTime(rs.getTimestamp(4));
				blogsDetails.setUserid(rs.getInt(5));
				blogsDetails.setCategory(rs.getInt(6));
				// Add the BlogsDetails object to the list
				blogsList.add(blogsDetails);
			}
			// Return the list of blogs
			return blogsList;
		}
	}

	// Method to delete a blog by id
	public void DeleteBlog(int id) throws SQLException {
		String sql = "DELETE FROM blogs WHERE id = ?";
		try (PreparedStatement stm = connection.prepareStatement(sql)) {
			// Set the id parameter for the prepared statement
			stm.setInt(1, id);
			// Execute the delete query
			stm.executeUpdate();
		}
	}
}

package com.sunbeam.bms.pojo;

import java.sql.Timestamp;
import java.time.LocalDate;

public class BlogsDetails {
	private int id;
	private String title;
	private String content;
	private Timestamp createdTime; // Timestamp of blog creation
	private int userid; // User ID associated with the blog
	private int category; // Category ID associated with the blog

	// Default constructor
	public BlogsDetails() {
		super();
	}

	// Constructor with parameters for title, content, user ID, and category ID
	public BlogsDetails(String title, String content, int userid, int category) {
		super();
		this.title = title;
		this.content = content;
		// Set the created time to the current system time
		this.createdTime = new Timestamp(System.currentTimeMillis());
		this.userid = userid;
		this.category = category;
	}

	// Constructor with parameters for content, created time, user ID, and category
	// ID
	public BlogsDetails(String content, LocalDate createdTime, int userid, int category) {
		super();
		this.content = content;
		// Set the created time to the current system time
		this.createdTime = new Timestamp(System.currentTimeMillis());
		this.userid = userid;
		this.category = category;
	}

	// Getter and setter methods for each field

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Override toString method to provide a string representation of the object
	@Override
	public String toString() {
		return "BlogsDetails [id=" + id + ", title=" + title + ", content=" + content + ", createdTime=" + createdTime
				+ ", userid=" + userid + ", category=" + category + "]";
	}
}

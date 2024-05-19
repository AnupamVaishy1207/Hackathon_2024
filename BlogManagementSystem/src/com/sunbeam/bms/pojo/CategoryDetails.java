package com.sunbeam.bms.pojo;

import java.util.Objects;

public class CategoryDetails {
	private int id; // Category ID
	private String title; // Category title
	private String description; // Category description

	// Default constructor
	public CategoryDetails() {
		super();
	}

	// Constructor with parameter for category ID
	public CategoryDetails(int id) {
		super();
		this.id = id;
	}

	// Constructor with parameters for category ID and title
	public CategoryDetails(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	// Constructor with parameters for category ID, title, and description
	public CategoryDetails(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	// Override hashCode method to calculate hash based on category ID
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	// Override equals method to compare objects based on category ID
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryDetails other = (CategoryDetails) obj;
		return id == other.id;
	}

	// Getter and setter methods for each field

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Override toString method to provide a string representation of the object
	@Override
	public String toString() {
		return "CategoryDetails [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
}

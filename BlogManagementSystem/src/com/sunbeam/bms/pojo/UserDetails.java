package com.sunbeam.bms.pojo;

import java.time.LocalDate;
import java.util.Objects;

public class UserDetails {
	private int id; // User ID
	private String fullName; // User's full name
	private String email; // User's email
	private String password; // User's password
	private String phone; // User's phone number
	private LocalDate createdTime; // Date and time of user creation

	// Default constructor
	public UserDetails() {
		super();
	}

	// Constructor with parameter for user ID
	public UserDetails(int id) {
		super();
		this.id = id;
	}

	// Constructor with parameters for user ID and full name
	public UserDetails(int id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}

	// Constructor with parameters for user ID, full name, and email
	public UserDetails(int id, String fullName, String email) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
	}

	// Constructor with parameters for user ID, full name, email, and password
	public UserDetails(int id, String fullName, String email, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	// Constructor with parameters for full name, email, password, and phone number
	public UserDetails(String fullName, String email, String password, String phone) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	// Constructor with parameters for full name, email, password, phone number, and
	// created time
	public UserDetails(String fullName, String email, String password, String phone, LocalDate createdTime) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.createdTime = createdTime;
	}

	// Getter and setter methods for each field

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	// Override hashCode method to calculate hash based on email and phone
	@Override
	public int hashCode() {
		return Objects.hash(email, phone);
	}

	// Override equals method to compare objects based on email and phone
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		return Objects.equals(email, other.email) && Objects.equals(phone, other.phone);
	}
}

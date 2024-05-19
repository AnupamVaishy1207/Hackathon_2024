package com.sunbeam.bms.menu;

import java.util.List;
import java.util.Scanner;

import com.sunbeam.bms.dao.CategoriesDao;
import com.sunbeam.bms.dao.UserDao;
import com.sunbeam.bms.pojo.CategoryDetails;
import com.sunbeam.bms.pojo.UserDetails;

public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			// Menu options
			System.out.println("0. Exit");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();

			switch (choice) {
				case 0:
					System.out.println("Thank You For Visiting Our BLOGS");
					break;
				case 1:
					login(sc);
					break;
				case 2:
					registration(sc);
					break;
			}

		} while (choice != 0);
		sc.close(); // Closing scanner
	}

	// Method for user login
	public static void login(Scanner sc) {
		System.out.println("----------------------------------");
		System.out.println("          - Login Page -          ");
		System.out.println("----------------------------------");
		try (UserDao userDao = new UserDao()) {
			System.out.print("Email -> ");
			String email = sc.next();
			System.out.print("Password -> ");
			String password = sc.next();

			if (userDao.authenticate(email, password)) {
				System.out.println("Login Successful");
				bloggingApp(sc);
			} else {
				System.out.println("Invalid username or password!");
			}
		} catch (Exception e) {
			System.out.println("DB related Error");
			e.printStackTrace();
		}
	}

	// Method to manage blogging functionalities
	public static void bloggingApp(Scanner sc) {
		int choice;
		do {
			// Blogging options
			System.out.println("1. Add Category");
			System.out.println("2. Show Category");
			System.out.println("3. All Blogs");
			System.out.println("4. My Blogs");
			System.out.println("5. Add Blog");
			System.out.println("6. Edit Blog");
			System.out.println("7. Search Blog");
			System.out.println("8. Delete Blog");
			System.out.println("9. Logout");
			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {
				case 1:
					addCategory(sc);
					break;
				case 2:
					showCategories();
					break;
			}
		} while (choice != 9);
	}

	// Method to add a new category
	public static void addCategory(Scanner sc) {
		try (CategoriesDao categoriesDao = new CategoriesDao()) {
			System.out.print("Enter Title - ");
			sc.nextLine(); // Consume the newline character
			String title = sc.nextLine();
			System.out.print("Enter Description - ");
			String desc = sc.nextLine();
			categoriesDao.AddCategory(title, desc);
		} catch (Exception e) {
			System.out.println("Error adding category");
			e.printStackTrace();
		}
	}

	// Method to display all categories
	public static void showCategories() {
		try (CategoriesDao categoriesDao = new CategoriesDao()) {
			List<CategoryDetails> categoryList = categoriesDao.getAllCategory();
			categoryList.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println("Error fetching categories");
			e.printStackTrace();
		}
	}

	// Method for user registration
	public static void registration(Scanner sc) {
		System.out.println("----------------------------------");
		System.out.println("      - Registration Page -       ");
		System.out.println("----------------------------------");

		try (UserDao userDao = new UserDao()) {
			System.out.print("Full Name -> ");
			sc.nextLine(); // Consume the newline character
			String fullName = sc.nextLine();
			System.out.print("Email -> ");
			String email = sc.next();
			if (!userDao.CheckUserExists(email)) {
				System.out.print("Password -> ");
				String password = sc.next();
				System.out.print("Full Phone No -> ");
				String phoneNo = sc.next();
				userDao.registerUser(new UserDetails(fullName, email, password, phoneNo));
			} else {
				System.out.println("User with this email already exists.");
			}

		} catch (Exception e) {
			System.out.println("Error registering user");
			e.printStackTrace();
		}
	}
}

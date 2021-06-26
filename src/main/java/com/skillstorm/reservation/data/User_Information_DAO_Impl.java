package com.skillstorm.reservation.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.reservation.models.User_Information;

public class User_Information_DAO_Impl implements DAO_Basic {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * overridden method from the DAO_Basic abstract class that allows the class to
	 * save data to the database, respective of their model and table.
	 * 
	 * @param Object o --> casted to the respective object for this class.
	 * @exception throws an SQL exception and prints out other exceptions that occur
	 *                   when safe code is failed.
	 */
	@Override
	public boolean save(Object o) throws SQLException {
		// String for inserting new user data into data base REMEMBER THE PARAMETER
		// BINDINGSs
		String sql = "Insert into USER_INFORMATION (user_name, user_email, user_travel_location) values (?,?,?)";
		int rows = 0;
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			User_Information user = (User_Information) o; // casted the object to user_information object
			stm.setString(1, user.getUser_name());
			stm.setString(2, user.getUser_email());
			stm.setInt(3, user.getTravel_location());
			rows = stm.executeUpdate(); // returns 1 for success, 0 for no rows changed

		} catch (Exception e) {
			System.out.println("something happened in save method!");
			e.printStackTrace();
		}

		return rows > 0 ? true : false;
	}

	/**
	 * the find all method that is used to list out all existing informations about
	 * the users in the USER_INFORMATION table. takes no parameters
	 */
	public List<User_Information> findAll() throws SQLException {
		String sql = "Select user_id, user_name, user_email, user_travel_location from USER_INFORMATION";
		List<User_Information> allRegisteredUsers = new LinkedList<>();
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				// create the object
				User_Information users = new User_Information(rs.getString("user_name"), rs.getString("user_email"),
						rs.getInt("user_travel_location"));
				users.setUser_id(rs.getInt("user_id"));
				// add to the list
				allRegisteredUsers.add(users);
			}
		} catch (Exception e) {
			System.out.println("Something went wron in findAll method!");
			e.printStackTrace();
		}
		System.out.println(allRegisteredUsers);
		return allRegisteredUsers;
	}

	/**
	 * this method is implemented with the assumption that their id is already
	 * populated.
	 */
	@Override
	public boolean update(Object o) throws SQLException {
		String sql = "update USER_INFORMATION set user_name = ?, user_email = ?, user_travel_location = ? where user_id = ?";
		int rows = 0;
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// type cast the object
			User_Information user = (User_Information) o;
			stm.setString(1, user.getUser_name());
			stm.setString(2, user.getUser_email());
			stm.setInt(3, user.getTravel_location());
			stm.setInt(4, user.getUser_id());
			rows = stm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
			e.printStackTrace();
		}
		return rows > 0 ? true : false;
	}

	/**
	 * Like the update method, this is a method that assumes that the user already
	 * has an id in the populated data, and wants to be removed, given the unique
	 * id. Conditions range to many, but for now will have the condition equal to
	 * specific id.
	 */
	@Override
	public boolean delete(Object o) throws SQLException {
		String sql = "delete from USER_INFORMATION where user_id = ?"; // the SQL statement that was tested in MySQL
		int rows = 0; // again, rows affected will return integer greater than 0 if successful, 0
						// otherwise.
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			// the method takes in an object--> cast it
			User_Information user = (User_Information) o;
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setInt(1, user.getUser_id());

			// execute and update the query.
			rows = stm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Something happened in delete method!");
			e.printStackTrace();
		}
		return rows > 0 ? true : false;

	}
}
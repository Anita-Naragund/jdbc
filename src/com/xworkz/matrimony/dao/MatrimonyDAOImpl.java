package com.xworkz.matrimony.dao;

import static com.xworkz.matrimony.constants.Constants.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xworkz.matrimony.dto.Bride;

public class MatrimonyDAOImpl implements MatrimonyDAO {

	private Connection connection = null;

	@Override
	public Bride getById(int id) {
		Bride bride = new Bride();
		try {
			connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
			System.out.println("Database created succefully.........");
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from matrimony.bride where id=+"+id);
			resultSet.next();
			bride.setId(resultSet.getInt(1));
			bride.setName(resultSet.getString(2));
			bride.setAge(resultSet.getInt(3));
			bride.setHeight(resultSet.getDouble(4));
			bride.setWeight(resultSet.getDouble(5));
			bride.setQualification(resultSet.getString(6));
			bride.setExpectation(resultSet.getString(7));
			bride.setSalary(resultSet.getDouble(8));
			bride.setPhoneNo(resultSet.getString(9));
			bride.setOccupation(resultSet.getString(10));
			bride.setAddress(resultSet.getString(11));
			System.out.println(bride);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Database connection failed");
		}
		return bride;
		
	}

	@Override
	public void getAllBrides(Bride bride) {
		// Bride bride1=new Bride();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
			System.out.println("Connected to database.....");
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from matrimony.bride");
			// Bride bride=new Bride();
			while (resultSet.next()) {
				bride.setId(resultSet.getInt(1));
				bride.setName(resultSet.getString(2));
				bride.setAge(resultSet.getInt(3));
				bride.setHeight(resultSet.getDouble(4));
				bride.setWeight(resultSet.getDouble(5));
				bride.setQualification(resultSet.getString(6));
				bride.setExpectation(resultSet.getString(7));
				bride.setSalary(resultSet.getDouble(8));
				bride.setPhoneNo(resultSet.getString(9));
				bride.setOccupation(resultSet.getString(10));
				bride.setAddress(resultSet.getString(11));
				System.out.println(bride);
			}
			// System.out.println(bride);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to connect to database");
		}
	}

	@Override
	public int create(Bride bride) {
		int result = 0;
		try (Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD)) {
			PreparedStatement prepare = conn
					.prepareStatement("insert into matrimony.bride values(?,?,?,?,?,?,?,?,?,?,?)");
			prepare.setInt(1, bride.getId());
			prepare.setString(2, bride.getName());
			prepare.setInt(3, bride.getAge());
			prepare.setDouble(4, bride.getHeight());
			prepare.setDouble(5, bride.getWeight());
			prepare.setString(6, bride.getQualification());
			prepare.setString(7, bride.getExpectation());
			prepare.setString(8, bride.getPhoneNo());
			prepare.setDouble(9, bride.getSalary());
			prepare.setString(10, bride.getOccupation());
			prepare.setString(11, bride.getAddress());
			result = prepare.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to connect to Database...");
			e.printStackTrace();
		}

		return result;
	}
	@Override
	public int updatePhoneNumberById(int id, String phoneNo) {
		int update=0;
		try (Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD)) {
			PreparedStatement prepare = conn.prepareStatement("update matrimony.bride set phoneNo=(?) where id=(?)");
			prepare.setString(1, phoneNo);
			prepare.setInt(2, id);
			update=prepare.executeUpdate();
	}catch(SQLException e) {
		System.out.println("Failed to update");
	}
		return update;
	}

	@Override
	public int deleteBrideById(int id) {
		int delete=0;
		try (Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD)) {
			PreparedStatement prepare = conn.prepareStatement("delete from matrimony.bride where id=(?)");
			prepare.setInt(1, id);
			delete=prepare.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Failed to delete");
		}
		return delete;
	}
}

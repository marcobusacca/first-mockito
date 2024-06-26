package com.advancia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {

	public List<String> fetchAvailableRooms() throws SQLException {
		List<String> availableRooms = new ArrayList<String>();
		Connection conn = DriverManager.getConnection("DATABASE_URL");
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM rooms WHERE available LIKE '1'");
		while (rs.next()) {
			availableRooms.add(rs.getString("Room name"));
		}
		return availableRooms;
	}
}

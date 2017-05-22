package com.doc.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	public Connection getConnection() throws Exception {
		try {
			String connectionURL = "jdbc:mysql://127.0.0.1:3306/hospitaldb";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "vikas");
			return connection;
		} catch (Exception e) {
			throw e;
		}

	}

}
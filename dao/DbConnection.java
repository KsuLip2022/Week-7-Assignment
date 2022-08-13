package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exeption.DbException;

public class DbConnection {

	private static String HOST = "localhost";
	private static String PASSWORD = "projects";
	private static int PORT = 3306;
	private static String SCHEMA = "projects";
	private static String USER = "projects";
	
	public static Connection getConnection() {
		String uri = String.format("jdbc:mysql://%s:%d/%s",HOST, PORT, SCHEMA);
		
		try {
			Connection conn =  DriverManager.getConnection(uri, USER, PASSWORD);
			System.out.println("The connection " + SCHEMA + " is successful");
			return conn;
			
		} catch (SQLException e) {
			throw new DbException("Could not connect to database", e); 
		}
	}
}
 
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException,Exception {
		
		String driverName = "com.mysql.jdbc.Driver";
		String connectionURL = "jdbc:mysql://202.28.34.205/db63011211066";
		String username = "63011211066";
		String password = "63011211066";
		
		// for test
		//String username = "6301121";
		//String password = "6301121";

		System.out.println("-------- SQL JDBC Connection Testing ------");
		Connection connection = null;
		
		try {
			System.out.println("try class for name");
			Class.forName(driverName);
			System.out.println("SQL JDBC Driver Registered!");
			
			System.out.println("try DriverManager getConnection");
			connection = DriverManager.getConnection(connectionURL, username, password);
			

		} catch (ClassNotFoundException e) {
			System.out.println("Where is your  JDBC Driver?");
			System.out.println("Class:" + "ConnectionFactory, Class.forName " + e.getMessage());
			throw e;
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			System.out.println("Class:" + "ConnectionFactory, DriverManager.getConnection " + e.getMessage());
			throw e;
		} catch (Exception e) {
			System.out.println("Class:" + "ConnectionFactory, DriverManager.getConnection " + e.getMessage());
			throw e;
		}
		
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			System.out.println("Connected to database");
			
		} else {
			System.out.println("Failed to make connection!");
			throw new Exception("Failed to make connection!");
		}
		
		return connection;
	}
}

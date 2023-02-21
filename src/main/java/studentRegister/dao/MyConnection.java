package studentRegister.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","root");
			System.out.println("Connecting...");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		} catch (SQLException e) {
			System.out.println("Database Not Found");
		}
		return con;

	}
	

}

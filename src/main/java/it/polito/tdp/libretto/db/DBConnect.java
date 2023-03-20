package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection() throws SQLException {
		
		String jdbcURL = "jdbc:mariadb://localhost/LibrettoVoti?user=root&password=rootadmin" ;
		Connection conn = DriverManager.getConnection(jdbcURL) ;
		
		return conn;
	}
	
	
}

package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;


public class Prova {

	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:mariadb://localhost/LibrettoVoti?user=root&password=rootadmin";
		
		try {
		
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql = "SELECT corso, punti, data " + "FROM Voto";
			
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				
				String corso = res.getString("corso");
				int punti = res.getInt("punti");
				
				
				System.out.println(corso + " = " + punti);
				
				//System.out.println(corso);
				//System.out.println(punti);
			}
			
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
}

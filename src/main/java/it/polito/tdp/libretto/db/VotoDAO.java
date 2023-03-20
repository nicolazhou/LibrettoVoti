package it.polito.tdp.libretto.db;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import it.polito.tdp.libretto.model.Voto;

public class VotoDAO {

	// CRUD = Create Read Update Delete List Search
	
	
	public List<Voto> listVoti() {
		
		String jdbcURL = "jdbc:mariadb://localhost/LibrettoVoti?user=root&password=rootadmin";
		
		try {
		
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql = "SELECT corso, punti, data " + "FROM Voto";
			
			ResultSet res = st.executeQuery(sql);
			
			List<Voto> voti = new ArrayList<>();
			
			while(res.next()) {
				
				String corso = res.getString("corso");
				int punti = res.getInt("punti");
				
				LocalDate data = res.getDate("data").toLocalDate();
				
				Voto v = new Voto(corso, punti, data);
				voti.add(v);
				
			}
			
			conn.close();
			return voti;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void createVoto(Voto v) {
		
		//		String sql = "INSERT INTO `voto` (`corso`, `punti`, `data`) "
		//		+ "VALUES ('"+v.getCorso()+"', "
		//		+v.getPunti()+", '"+v.getDataEsame()+"');";

		String sql = "INSERT INTO voto (`corso`, `punti`, `data`) "
		+"VALUES (?, ?, ?);" ;

		try {
			Connection conn = DBConnect.getConnection() ;
			PreparedStatement st = conn.prepareStatement(sql) ;

			st.setString(1, v.getNomeCorso());
			st.setInt(2, v.getPunti());
			st.setDate(3, Date.valueOf(v.getDataEsame()));

			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Voto readVoto(String corso) {
		
		
		return null;
	}
	
	public List<Voto> searchVotoPuntiMaggiori(int punti) {
		
		
		return null;
	}
	
	
}

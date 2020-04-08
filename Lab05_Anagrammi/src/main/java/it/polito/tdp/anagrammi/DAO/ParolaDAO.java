package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParolaDAO {

	public boolean controllaParola(String p) {
		final String sql = "SELECT * " + 
				"FROM parola " + 
				"WHERE nome = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, p);
			ResultSet rs = st.executeQuery();
			
			conn.close();
			
			if(!rs.next())
				return false;			

			return true;
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore DB!\n", e);
		}
	}

}

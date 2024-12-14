package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class EsempioJDBC {

	public static void main(String[] args) {

		try {
	
			
			//jdbc:mysql://localhost:3306/myschema?serverTimezone=UTC
			
            java.util.Date d1 = new java.util.Date();
           
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            d1 = sdf.parse("2009-12-31");
            
            
			Date d = new Date(d1.getTime());
			
			EsempioJDBC.insert("PROVA", d);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void delete(int id) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		String updateTableSQL = "DELETE FROM corsi WHERE idCorso = ?";

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/universitadb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "1234");

	
			
					
					
			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, id);
		

			// execute update SQL stetement
		    cmd.executeUpdate();
			
			

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}


	public static void insert(String desc, java.util.Date dt) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		String updateTableSQL = "INSERT INTO corsi(descrizione, dataCreazione) VALUES(?,?)";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/prova?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
	

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, desc);
			//cmd.setDate(2, dt);

			// execute update SQL stetement
		    cmd.executeUpdate();
			
			

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	
	public static void update(String desc, int idCorso) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		String updateTableSQL = "UPDATE corsi SET DESCRIZIONE = ?  WHERE idCorso = ?";

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/universitadb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "1234");

	

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, desc);
			cmd.setInt(2, idCorso);

			// execute update SQL stetement
		    cmd.executeUpdate();
			
			

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}


	public static void query() {

		try {

			// QUERY
			// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/universitadb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection con = DriverManager.getConnection(url, "root", "1234");

			int idc = 1;

			String qry = "SELECT * FROM docente WHERE cognome= ? and email = ? ";

			// Creiamo un oggetto PrepareStatement per poter interrogare il db
			PreparedStatement cmd = con.prepareStatement(qry);

			cmd.setString(1, "paperino");
			cmd.setString(2, "pri");
			// Eseguiamo una query e immagazziniamone i risu3ltati
			// in un oggetto ResultSet
			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();// ---> la prima riga
			// --> seconda riga

			
			
			
			
			
			
			// Stampiamone i risultati riga per riga

			while (esiste) {
				int idC = res.getInt("idDocente");

				System.out.println(idC);

				System.out.println(res.getString("nome"));
				System.out.println(res.getString("cognome"));


				esiste = res.next();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("sdgfsda");

			e.printStackTrace();
		}
	}

}

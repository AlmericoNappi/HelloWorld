package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCHelloWorld {

	public static void main(String[] args)  {
		// eliminare edoardo1989

		//
		// JDBCHelloWorld.queryConParamentri(7);

//		try {
		
		
		
		
			try {
				
				
				JDBCHelloWorld.query();
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		System.out.println("33");	
			
			//			
//			
//		//	JDBCHelloWorld.update("pippo", 7);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public static void query() throws ClassNotFoundException, SQLException {

		// try {

		// QUERY
		// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
		String driver = "com.mysql.jdbc.Driver";
		Connection con;
	//	try {
			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://locadfhfghdfglhost:3306/universitadb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password

			con = DriverManager.getConnection(url, "root", "1234");

			String qry = "SELECT * FROM corsi";

			// Creiamo un oggetto PrepareStatement per poter interrogare il db
			PreparedStatement cmd = con.prepareStatement(qry);

			// Eseguiamo una query e immagazziniamone i risu3ltati
			// in un oggetto ResultSet
			ResultSet res = cmd.executeQuery();

			boolean tro = res.next();// ---> la prima riga
			// --> seconda riga

			// Stampiamone i risultati riga per riga

			while (tro) {
				int idC = res.getInt("idCorso");

				System.out.println(idC);

				System.out.println(res.getString("descrizione"));

				res.next();

				tro = res.next();
			}
			
			
			

//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// UPDATE
		// update("PROVA33", 4);

//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.err.println("sdgfsda");
//
//			e.printStackTrace();
//		}
	}

	public static void queryConParamentri(int idAttore) {

		try {

			// QUERY
			// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/db_izzo";

			// Otteniamo una connessione con username e password
			Connection con = DriverManager.getConnection(url, "corso", "corso2016");

			String qry = "SELECT * FROM attori where codattore = ? ";

			// Creiamo un oggetto PrepareStatement per poter interrogare il db
			PreparedStatement cmd = con.prepareStatement(qry);

			cmd.setInt(1, idAttore);

			// Eseguiamo una query e immagazziniamone i risu3ltati
			// in un oggetto ResultSet
			ResultSet res = cmd.executeQuery();

			boolean tro = res.next();// ---> la prima riga
			// --> seconda riga

			// Stampiamone i risultati riga per riga

			while (tro) {
				System.out.println("--------------------");
				System.out.println("codice attore:" + res.getInt("CODATTORE"));
				System.out.println("nome:" + res.getString("NOME"));
				tro = res.next();
			}

			// UPDATE
			// update("PROVA33", 4);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("sdgfsda");

			e.printStackTrace();
		}
	}

	public static void update(String nome, int codAttore) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		String updateTableSQL = "UPDATE attori SET NOME = ?  WHERE CODATTORE = ?";

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/db_izzo";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "paganoant");

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, nome);
			cmd.setInt(2, codAttore);

			// execute update SQL stetement
			cmd.executeUpdate();

			java.util.Date d1 = new java.util.Date();

			Date d = new Date(d1.getTime());

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

}

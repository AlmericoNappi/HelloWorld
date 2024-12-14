package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudenteDao {

	public static void main(String[] args) {
		StudenteDao sd = new StudenteDao();
		
		try {
			sd.insert("mario", "rossi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void query(String c) {

		try {

			// QUERY
			// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/prova?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection con = DriverManager.getConnection(url, "root", "1234");

			int idc = 1;

			String qry = "SELECT * FROM cliente WHERE cognome= ?  ";

			// Creiamo un oggetto PrepareStatement per poter interrogare il db
			PreparedStatement cmd = con.prepareStatement(qry);

			cmd.setString(1, c);
	
			// Eseguiamo una query e immagazziniamone i risu3ltati
			// in un oggetto ResultSet
			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();// ---> la prima riga
			// --> seconda riga

			// Stampiamone i risultati riga per riga

			while (esiste) {
				int idC = res.getInt("codicecliente");

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

	public void insert(String n, String c) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/prova?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "1234");

			String updateTableSQL = "INSERT INTO cliente(nome, cognome) VALUES(?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, n);
			cmd.setString(2, c);

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

}

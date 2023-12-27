package sql;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class CreateDB {

	public static String DB_REL_FILE = "./db/db.db3";
	public static String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;

	public void creaDB() throws IOException, SQLException {
		if (new File(DB_REL_FILE).exists()) {
			System.out.println("Il DB gia' esiste");
		} else {
			DriverManager.getConnection(DB_URL);
			System.out.println("Il DB e' stato creato");

		}
	}

	public void creaTable() throws IOException, SQLException {
		Connection conn = DriverManager.getConnection(DB_URL);
		if (conn != null) {
			Statement stmt = conn.createStatement();
			String tabellapersonale = "CREATE TABLE PERSONALE (CODICE TEXT, NOME TEXT, COGNOME TEXT, MANSIONE INT, PRIMARY KEY(CODICE))";
			String tabelladegente = "CREATE TABLE DEGENTE (CODICE TEXT, NOME TEXT, COGNOME TEXT, URGENZA INT, IN_ATTESA BOOLEAN, PRIMARY KEY (CODICE))";
			String tabelladiaria = "CREATE TABLE DIARIA (CODICE TEXT, CODICE_DEGENTE TEXT, DATA DATE, ORA TIME, NOTE_PARTICOLARI TEXT, IMPORTANTE BOOLEAN, FARMACO TEXT, FOREIGN KEY (CODICE_DEGENTE) REFERENCES DEGENTE(CODICE), PRIMARY KEY (CODICE,CODICE_DEGENTE))";
			// in mansione 0 è medico, 1 è infermiere, 2 è segretario
			// in urgenza 0 è verde, 1 è giallo e 2 è rosso
			stmt.executeUpdate(tabellapersonale);
			stmt.executeUpdate(tabelladegente);
			stmt.executeUpdate(tabelladiaria);
			stmt.close();
			conn.close();
			System.out.println("Table created successfully");
		}

	}

	public static void main(String[] args) throws IOException, SQLException {
		CreateDB b = new CreateDB();
		b.creaDB();
		b.creaTable();

	}

}

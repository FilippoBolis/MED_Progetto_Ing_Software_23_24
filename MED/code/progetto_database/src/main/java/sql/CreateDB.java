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
			String tabellapersonale = "CREATE TABLE PERSONALE (CODICE TEXT, NOME TEXT, COGNOME TEXT, MANSIONE TEXT, PRIMARY KEY(CODICE))";
			String tabelladegente = "CREATE TABLE DEGENTE (CODICE TEXT, NOME TEXT, COGNOME TEXT, URGENZA INT, IN_ATTESA BOOLEAN, PRIMARY KEY (CODICE))";
			String tabelladiariainf = "CREATE TABLE DIARIAINF (CODICE TEXT, CODICE_DEGENTE TEXT, DATA DATE, ORA TIME, NOTE_PARTICOLARI TEXT, IMPORTANTE BOOLEAN, FARMACO TEXT, FOREIGN KEY (CODICE_DEGENTE) REFERENCES DEGENTE(CODICE), PRIMARY KEY (CODICE,CODICE_DEGENTE))";
			String tabelladiariamed = "CREATE TABLE DIARIAMED (CODICE TEXT, CODICE_DEGENTE TEXT, STORICO TEXT , MOTIVO TEXT, FARMACI TEXT,DATA DATE,  ALLERGIE TEXT, FOREIGN KEY (CODICE_DEGENTE) REFERENCES DEGENTE(CODICE), PRIMARY KEY (CODICE,CODICE_DEGENTE))";
			String tabellaassegnazioneletto = "CREATE TABLE ASSEGNAZIONELETTO (CODICE_DEGENTE TEXT, CODICE_REPARTO TEXT, NOME_MODULO TEXT, NUMERO INT,DATA_ASSEGNAZIONE DATE "
					+ "FOREIGN KEY (CODICE_DEGENTE) REFERENCES DEGENTE(CODICE), "
					+ "FOREIGN KEY (CODICE_REPARTO) REFERENCES LETTO(CODICE_REPARTO), "
					+ "FOREIGN KEY (NOME_MODULO) REFERENCES LETTO(NOME_MODULO), "
					+ "FOREIGN KEY (NUMERO) REFERENCES LETTO(NUMERO), PRIMARY KEY (CODICE_REPARTO,CODICE_DEGENTE,NOME_MODULO,NUMERO))";

			// in urgenza 0 è verde, 1 è giallo e 2 è rosso
			String tabellareparto = "CREATE TABLE REPARTO (CODICE TEXT,NOME_REPARTO TEXT, PRIMARY KEY(CODICE))";
			String tabellamodulo = "CREATE TABLE MODULO (CODICE_REPARTO TEXT, NOME TEXT, FOREIGN KEY (CODICE_REPARTO) REFERENCES REPARTO (CODICE), PRIMARY KEY(CODICE_REPARTO,NOME))";
			String tabellaletto = "CREATE TABLE LETTO (CODICE_REPARTO TEXT, NOME_MODULO TEXT, NUMERO INT, FOREIGN KEY (CODICE_REPARTO) REFERENCES REPARTO(CODICE), FOREIGN KEY(NOME_MODULO) REFERENCES MODULO (NOME), PRIMARY KEY(CODICE_REPARTO,NOME_MODULO,NUMERO))";
			String tabellarilevazione = "CREATE TABLE RILEVAZIONE (ID TEXT , CODICE_DEGENTE TEXT,TEMPERATURA FLOAT, PRESSIONE INT, GLICEMIA INT ,DATA DATE, FREQ_CARD INT, DOLORE INT,PRIMARY KEY(ID,CODICE_DEGENTE),FOREIGN KEY(CODICE_DEGENTE) REFERENCES DEGENTE (CODICE))";
			stmt.executeUpdate(tabellaassegnazioneletto);
			stmt.executeUpdate(tabellarilevazione);
			stmt.executeUpdate(tabellapersonale);
			stmt.executeUpdate(tabelladegente);
			stmt.executeUpdate(tabelladiariainf);
			stmt.executeUpdate(tabelladiariamed);
			stmt.executeUpdate(tabellareparto);
			stmt.executeUpdate(tabellamodulo);
			stmt.executeUpdate(tabellaletto);
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

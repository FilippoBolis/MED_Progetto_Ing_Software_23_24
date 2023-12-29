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
			String tabellaPersonale = "CREATE TABLE PERSONALE (CODICE TEXT, NOME TEXT, COGNOME TEXT, MANSIONE TEXT, PRIMARY KEY(CODICE))";
			String tabellaDegente = "CREATE TABLE DEGENTE (CODICE TEXT, NOME TEXT, COGNOME TEXT, URGENZA INT, IN_ATTESA BOOLEAN, PRIMARY KEY (CODICE))";
			// in urgenza 0 è verde, 1 è giallo e 2 è rosso
			String tabellaDiariaInf = "CREATE TABLE DIARIAINF (CODICE TEXT, CODICE_DEGENTE TEXT, CODICE_INFERMIERE TEXT, DATA DATE, ORA TIME, NOTE_PARTICOLARI TEXT, IMPORTANTE BOOLEAN, FARMACO TEXT, FOREIGN KEY (CODICE_DEGENTE) REFERENCES DEGENTE(CODICE), PRIMARY KEY (CODICE,CODICE_DEGENTE))";
			String tabellaDiariaMed = "CREATE TABLE DIARIAMED (CODICE TEXT, CODICE_DEGENTE TEXT, CODICE_MEDICO TEXT, STORICO TEXT , MOTIVO TEXT, FARMACI TEXT,DATA DATE,ORA TIME, ALLERGIE TEXT, FOREIGN KEY (CODICE_DEGENTE) REFERENCES DEGENTE(CODICE), PRIMARY KEY (CODICE,CODICE_DEGENTE))";
			String tabellaAssegnazioneLetto = "CREATE TABLE ASSEGNAZIONELETTO (CODICE_DEGENTE TEXT, CODICE_REPARTO TEXT, NOME_MODULO TEXT, NUMERO_LETTO INT,DATA_ASSEGNAZIONE DATE, FOREIGN KEY (CODICE_DEGENTE) REFERENCES DEGENTE(CODICE), FOREIGN KEY (CODICE_REPARTO) REFERENCES LETTO(CODICE_REPARTO), FOREIGN KEY (NOME_MODULO) REFERENCES LETTO(NOME_MODULO), FOREIGN KEY (NUMERO_LETTO) REFERENCES LETTO(NUMERO), PRIMARY KEY (CODICE_REPARTO,CODICE_DEGENTE,NOME_MODULO,NUMERO_LETTO))";
			String tabellaReparto = "CREATE TABLE REPARTO (CODICE TEXT,NOME_REPARTO TEXT, PRIMARY KEY(CODICE))";
			String tabellaModulo = "CREATE TABLE MODULO (CODICE_REPARTO TEXT, NOME TEXT, FOREIGN KEY (CODICE_REPARTO) REFERENCES REPARTO (CODICE), PRIMARY KEY(CODICE_REPARTO,NOME))";
			String tabellaLetto = "CREATE TABLE LETTO (CODICE_REPARTO TEXT, NOME_MODULO TEXT, NUMERO INT, FOREIGN KEY (CODICE_REPARTO) REFERENCES REPARTO(CODICE), FOREIGN KEY(NOME_MODULO) REFERENCES MODULO (NOME), PRIMARY KEY(CODICE_REPARTO,NOME_MODULO,NUMERO))";
			String tabellaRilevazione = "CREATE TABLE RILEVAZIONE (ID TEXT , CODICE_DEGENTE TEXT,TEMPERATURA DOUBLE,PRESSIONE_MAX INT, PRESSIONE_MIN INT, GLICEMIA INT ,DATA DATE,ORA TIME, FREQ_CARD INT, DOLORE INT,PRIMARY KEY(ID,CODICE_DEGENTE),FOREIGN KEY(CODICE_DEGENTE) REFERENCES DEGENTE (CODICE))";
			stmt.executeUpdate(tabellaAssegnazioneLetto);
			stmt.executeUpdate(tabellaRilevazione);
			stmt.executeUpdate(tabellaPersonale);
			stmt.executeUpdate(tabellaDegente);
			stmt.executeUpdate(tabellaDiariaInf);
			stmt.executeUpdate(tabellaDiariaMed);
			stmt.executeUpdate(tabellaReparto);
			stmt.executeUpdate(tabellaModulo);
			stmt.executeUpdate(tabellaLetto);
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

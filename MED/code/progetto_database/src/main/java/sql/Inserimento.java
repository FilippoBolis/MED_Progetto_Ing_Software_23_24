package sql;

import java.sql.*;

public class Inserimento {

	public void personale(String codice, String nome, String cognome, String mansione) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				if (mansione == "M" || mansione == "I" || mansione == "S") {
					Statement stmt = conn.createStatement();
					String sql = "INSERT INTO PERSONALE VALUES (" + codice + "," + nome + "," + cognome + "," + mansione
							+ ")";
					stmt.executeUpdate(sql);
					stmt.close();
					conn.close();
					System.out.println("Membro del personale inserito con successo");
				} else {
					System.out.println("mansione del membro del personale non valida");
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finito");
		}
	}

	public void degente(String codice, String nome, String cognome, int urgenza, boolean attesa) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				if (urgenza >= 0 && urgenza <= 2) {
					Statement stmt = conn.createStatement();
					String sql = "INSERT INTO DEGENTE VALUES (" + codice + "," + nome + "," + cognome + "," + urgenza
							+ "," + attesa + ")";
					stmt.executeUpdate(sql);
					stmt.close();
					conn.close();
					System.out.println("Degente inserito con successo");
				} else {
					System.out.println("urgenza non valida");
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finito");
		}
	}

	public void diariaMed() {
	}

	public void diariaInf() {
	}

	public void rilevazione() {
	}

	public void reparto(String codice, String nome) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO REPARTO VALUES (" + codice + "," + nome + ")";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Reparto inserito con successo");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finito");
		}
	}

	public void modulo() {
	}

	public void letto() {
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void diariaInf(String codice, String codiceDegente, String codiceInfermiere, Date data, Time ora, String noteParticolari, Boolean importante, String farmaco) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO DIARIAINF VALUES (" + codice + "," + codiceDegente + "," + codiceInfermiere + "," + data + "," + ora + "," + noteParticolari + "," + importante + "," + farmaco + ")";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("DiaraInf inserita con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void diariaMed(String codice, String codiceDegente, String codiceMedico, String storico, String motivo, String farmaci, Date data, String ora, String allergie) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO DIARIAINF VALUES (" + codice + "," + codiceDegente + "," + codiceMedico + "," + storico + "," + motivo + "," + farmaci + "," + data + "," + ora + "," + allergie + ")";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("DiaraMed inserita con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {

	}

}

package sql;

import java.sql.*;

public class Inserimento {

	public void personale(String codice, String nome, String cognome, String mansione) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				if (mansione == "M" || mansione == "I" || mansione == "S") {
					Statement stmt = conn.createStatement();
					String sql = "INSERT INTO PERSONALE VALUES (" + codice + "," + nome + "," + cognome + "," + mansione + ")";
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
		}
	}

	public void degente(String codice, String nome, String cognome, int urgenza, boolean attesa) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				if (urgenza >= 0 && urgenza <= 2) {
					Statement stmt = conn.createStatement();
					String sql = "INSERT INTO DEGENTE VALUES (" + codice + "," + nome + "," + cognome + "," + urgenza + "," + attesa + ")";
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
		}
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
		}
	}

	public void modulo(String codRep, String nome) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO MODULO VALUES (" + codRep + "," + nome + ")";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Modulo inserito con successo");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void letto(String codRep, String nomeMod, int numero) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO LETTO VALUES (" + codRep + "," + nomeMod + "," + numero + ")";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Letto inserito con successo");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void assegnazioneLetto(String codDeg, String codRep, String nomeMod, int numero, Date dataAss) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO ASSEGNAZIONELETTO VALUES (" + codDeg+ "," + codRep + "," + nomeMod + "," + numero + "," + dataAss+ ")";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Letto inserito con successo");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}

	public static void main(String[] args) {

	}

}

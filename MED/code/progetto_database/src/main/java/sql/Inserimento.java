package sql;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
public class Inserimento {

	public void personale(String codice, String nome, String cognome, String mansione) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				if (mansione == "M" || mansione == "I" || mansione == "S") {
					Statement stmt = conn.createStatement();
					String sql = "INSERT INTO PERSONALE(CODICE,NOME,COGNOME,MANSIONE) VALUES ('" + codice + "','" + nome + "','" + cognome + "','" + mansione + "')";
					stmt.executeUpdate(sql);
					stmt.close();
					conn.close();
					System.out.println("Membro del personale inserito con successo");
				} else {
					System.out.println("mansione del membro del personale non valida");
				}

			}
			else {System.out.println("Non va");}
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

	public void rilevazione(String ID, String codDeg, double temp, int pressMax,int pressMin, int glicem,LocalDate data, LocalTime ora, int freqCard, int dol) {try {
		
		Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
		if (conn != null) {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO RILEVAZIONE(ID,CODICE_DEGENTE,TEMPERATURA,PRESSIONE_MAX,PRESSIONE_MIN,GLICEMIA,DATA,ORA,FREQ_CARD,DOLORE) VALUES ('" + ID + "','" + codDeg +"','" + temp + "','" + pressMax + "','" + pressMin + "','" + glicem+ "','" + data + "','" + ora+ "','" + freqCard+ "','" + dol + "')";
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
			System.out.println("Rilevazione inserita con successo");

		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
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
			}catch (SQLException e) {
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
            Inserimento i= new Inserimento();
            i.personale("A1","Daniele","Gotti","M");
          //  i.degente("A21","Gabriele","Mazzoleni",0,true);
            i.rilevazione("B1","A21",36.8,150,90,100, LocalDate.now(),LocalTime.now().withNano(0),60,5);
           /* i.reparto();
            i.modulo();
            i.letto();
            i.assegnazioneLetto();
            i.diariaInf();
            i.diariaMed();*/
            
            
            
	}

}

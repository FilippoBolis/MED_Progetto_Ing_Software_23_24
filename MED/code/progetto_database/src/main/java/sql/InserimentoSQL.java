package sql;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
public class InserimentoSQL {

	public void personale(String codice, String nome, String cognome, String mansione) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				if (mansione == "M" || mansione == "I" || mansione == "S") {
					Statement stmt = conn.createStatement();
					String sql = "INSERT INTO PERSONALE (CODICE,NOME,COGNOME,MANSIONE) VALUES ('" + codice + "','" + nome + "','" + cognome + "','" + mansione + "')";
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
					String sql = "INSERT INTO DEGENTE (CODICE,NOME,COGNOME,URGENZA,IN_ATTESA) VALUES ('" + codice + "','" + nome + "','" + cognome + "','" + urgenza + "','" + attesa + "')";
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

	public void rilevazione(String ID, String codDeg, double temp, int pressMax,int pressMin, int glicem,LocalDate data, LocalTime ora, int freqCard, int dol) {
			try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO RILEVAZIONE (ID,CODICE_DEGENTE,TEMPERATURA,PRESSIONE_MAX,PRESSIONE_MIN,GLICEMIA,DATA,ORA,FREQ_CARD,DOLORE) VALUES ('" + ID + "','" + codDeg +"','" + temp + "','" + pressMax + "','" + pressMin + "','" + glicem+ "','" + data + "','" + ora+ "','" + freqCard+ "','" + dol + "')";
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
				String sql = "INSERT INTO REPARTO (CODICE,NOME_REPARTO) VALUES ('" + codice + "','" + nome + "')";
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
				String sql = "INSERT INTO MODULO (CODICE_REPARTO,NOME) VALUES ('" + codRep + "','" + nome + "')";
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
				String sql = "INSERT INTO LETTO (CODICE_REPARTO,NOME_MODULO,NUMERO) VALUES ('" + codRep + "','" + nomeMod + "','" + numero + "')";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Letto inserito con successo");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}

	public void assegnazioneLetto(String codDeg, String codRep, String nomeMod, int numero, LocalDate dataAss) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO ASSEGNAZIONELETTO (CODICE_DEGENTE,CODICE_REPARTO,NOME_MODULO,NUMERO_LETTO,DATA_ASSEGNAZIONE) VALUES ('" + codDeg+ "','" + codRep + "','" + nomeMod + "','" + numero + "','" + dataAss + "')";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Letto inserito con successo");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}

	public void diariaInf(String codice, String codiceDegente, String codiceInfermiere, LocalDate data, LocalTime ora, String noteParticolari, Boolean importante, String farmaco) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO DIARIAINF (CODICE,CODICE_DEGENTE,CODICE_INFERMIERE,DATA,ORA,NOTE_PARTICOLARI,IMPORTANTE,FARMACO) VALUES ('" + codice + "','" + codiceDegente + "','" + codiceInfermiere + "','" + data + "','" + ora + "','" + noteParticolari + "','" + importante + "','" + farmaco + "')";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("DiaraInf inserita con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void diariaMed(String codice, String codiceDegente, String codiceMedico, String storico, String motivo, String farmaci, LocalDate data, LocalTime ora, String allergie) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO DIARIAMED (CODICE,CODICE_DEGENTE,CODICE_MEDICO,STORICO,MOTIVO,FARMACI,DATA,ORA,ALLERGIE) VALUES ('" + codice + "','" + codiceDegente + "','" + codiceMedico + "','" + storico + "','" + motivo + "','" + farmaci + "','" + data + "','" + ora + "','" + allergie + "')";
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
            InserimentoSQL i= new InserimentoSQL();
            i.personale("P1","Daniele","Gotti","M");
            i.personale("P2","Filippo","Bolis","I");
            i.degente("D1","Gabriele","Mazzoleni",0,true);
            i.rilevazione("Ri1","D1",36.8,150,90,100, LocalDate.now(),LocalTime.now().withNano(0),60,5);
            i.reparto("Re1","Cardiologia");
            i.modulo("Re1","ModuloA");
            i.letto("Re1","ModuloA",1);
            i.assegnazioneLetto("D1","Re1","ModuloA",1,LocalDate.now());
            i.diariaInf("DiariaInf1","D1","P2",LocalDate.now(),LocalTime.now().withNano(0),"Il paziente è diventato enorme dottore",true,"Trembolone");
            i.diariaMed("DiariaMed1","D1","P1","il paziente non soffre di nulla in particolare","Vuole diventare più grosso","Trembolone",LocalDate.now(),LocalTime.now().withNano(0),"nessun allergia");
                
	}

}

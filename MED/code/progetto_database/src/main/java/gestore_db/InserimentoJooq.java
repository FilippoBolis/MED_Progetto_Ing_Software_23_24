package gestore_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import med_db.jooq.generated.tables.*;
import med_db.jooq.generated.tables.records.*;


public class InserimentoJooq {
	
	public void personale(String codice, String nome, String cognome, String mansione) {
		
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				if (mansione == "M" || mansione == "I" || mansione == "S") {
					DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

					PersonaleRecord persona = new PersonaleRecord(codice, nome, cognome, mansione);

					int result = create.insertInto(Personale.PERSONALE).set(persona).execute();

					System.out.println(result);
					//System.out.println("Membro del personale inserito con successo");
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
					DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

					DegenteRecord degente = new DegenteRecord(codice, nome, cognome, urgenza, attesa);

					int result = create.insertInto(Degente.DEGENTE).set(degente).execute();

					System.out.println(result);
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
			DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

			RilevazioneRecord rilevazione = new RilevazioneRecord(ID, codDeg, temp, pressMax, pressMin, glicem, data, ora, freqCard, dol);

			int result = create.insertInto(Rilevazione.RILEVAZIONE).set(rilevazione).execute();

			System.out.println(result);

		}
	} catch (SQLException e) {
	System.out.println(e.getMessage());
	}
}

	public void reparto(String codice, String nome) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				RepartoRecord reparto = new RepartoRecord(codice, nome);

				int result = create.insertInto(Reparto.REPARTO).set(reparto).execute();

				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void modulo(String codRep, String nome) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				ModuloRecord modulo = new ModuloRecord(codRep, nome);

				int result = create.insertInto(Modulo.MODULO).set(modulo).execute();

				System.out.println(result);
				}
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		
	}
	
	public void letto(String codRep, String nomeMod, int numero) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				LettoRecord letto = new LettoRecord(codRep, nomeMod, numero);

				int result = create.insertInto(Letto.LETTO).set(letto).execute();

				System.out.println(result);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void assegnazioneLetto(String codDeg, String codRep, String nomeMod, int numero, LocalDate dataAss) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				AssegnazionelettoRecord assLetto = new AssegnazionelettoRecord(codDeg, codRep, nomeMod, numero, dataAss);

				int result = create.insertInto(Assegnazioneletto.ASSEGNAZIONELETTO).set(assLetto).execute();

				System.out.println(result);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void diariaInf(String codice, String codiceDegente, String codiceInfermiere, LocalDate data, LocalTime ora, String noteParticolari, Boolean importante, String farmaco) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				DiariainfRecord diariaInf = new DiariainfRecord(codice, codiceDegente, codiceInfermiere, data, ora, noteParticolari, importante, farmaco);

				int result = create.insertInto(Diariainf.DIARIAINF).set(diariaInf).execute();

				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void diariaMed(String codice, String codiceDegente, String codiceMedico, String storico, String motivo, String farmaci, LocalDate data, LocalTime ora, String allergie) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				DiariamedRecord diariaMed = new DiariamedRecord(codice, codiceDegente, codiceMedico, storico, motivo, farmaci, data, ora, allergie);

				int result = create.insertInto(Diariamed.DIARIAMED).set(diariaMed).execute();

				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		InserimentoJooq i= new InserimentoJooq();
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

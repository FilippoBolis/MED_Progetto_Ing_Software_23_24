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


public class InserimentoJooq{
	//pattern singleton
	private static InserimentoJooq istanza= new InserimentoJooq();
	
	private InserimentoJooq() {}
	
	public static InserimentoJooq getIstanza() {
		return istanza;
	}

	public int personale(String codice, String nome, String cognome, String mansione, String password) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				if (mansione == "M" || mansione == "I" || mansione == "S") {
					DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

					PersonaleRecord persona = new PersonaleRecord(codice, nome, cognome, mansione, password);

					result = create.insertInto(Personale.PERSONALE).set(persona).execute();

					//System.out.println("Membro del personale inserito con successo");
				} else {
					System.out.println("mansione del membro del personale non valida");
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	public int degente(String codice, String nome, String cognome, String sesso, LocalDate dataArrivo, LocalTime oraArrivo,  String urgenza) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				if ((urgenza=="verde" || urgenza=="giallo" || urgenza=="rosso") && (sesso=="M" || sesso=="F")) {
					DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
					//il degente è in pronto soccorso all'inserimento nel DB
					DegenteRecord degente = new DegenteRecord(codice, nome, cognome, sesso, dataArrivo, oraArrivo, urgenza, "in Pronto Soccorso");

					result = create.insertInto(Degente.DEGENTE).set(degente).execute();

				} else {
					System.out.println("urgenza e/o sesso inseriti non validi");
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int rilevazione(int ID, String codDeg, String codInf, double temp, int pressMax,int pressMin, int glicem,LocalDate data, LocalTime ora, int freqCard, int dol) {
		int result=0;
		try {
		Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
		if (conn != null) {
			DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
			if (create.select(Degente.DEGENTE.CODICE).from(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codDeg)).fetch().isNotEmpty()) {
				RilevazioneRecord rilevazione = new RilevazioneRecord(ID, codDeg, codInf, temp, pressMax, pressMin, glicem, data, ora, freqCard, dol);
				result = create.insertInto(Rilevazione.RILEVAZIONE).set(rilevazione).execute();	
			}
			

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
}

	public int reparto(String codice, String nome) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				RepartoRecord reparto = new RepartoRecord(codice, nome);

				result = create.insertInto(Reparto.REPARTO).set(reparto).execute();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int modulo(String codRep, String nome) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
				if (create.select(Reparto.REPARTO.CODICE).from(Reparto.REPARTO).where(Reparto.REPARTO.CODICE.eq(codRep)).fetch().isNotEmpty()) {
					ModuloRecord modulo = new ModuloRecord(codRep, nome);
					result = create.insertInto(Modulo.MODULO).set(modulo).execute();	
					}
				}
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		return result;
	}
	
	public int letto(String codRep, String nomeMod, int numero) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
				if (create.select(Modulo.MODULO.NOME).from(Modulo.MODULO).where(Modulo.MODULO.CODICE_REPARTO.eq(codRep), Modulo.MODULO.NOME.eq(nomeMod)).fetch().isNotEmpty()) {

				LettoRecord letto = new LettoRecord(codRep, nomeMod, numero);
				result = create.insertInto(Letto.LETTO).set(letto).execute();
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	public int assegnazioneLetto(String codDeg, String codRep, String nomeMod, int numero, LocalDate dataAss) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				//se il degente scelto non esiste è impossibile assegnargli un letto, allo stesso modo non si può assegnare un letto che non esiste
				if (create.select(Degente.DEGENTE.CODICE).from(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codDeg)).fetch().isNotEmpty() &&
						create.select(Letto.LETTO.NUMERO).from(Letto.LETTO).where(Letto.LETTO.CODICE_REPARTO.eq(codRep), Letto.LETTO.NOME_MODULO.eq(nomeMod),Letto.LETTO.NUMERO.eq(numero)).fetch().isNotEmpty()) {
					
					AssegnazionelettoRecord assLetto = new AssegnazionelettoRecord(codDeg, codRep, nomeMod, numero, dataAss);
					result = create.insertInto(Assegnazioneletto.ASSEGNAZIONELETTO).set(assLetto).execute();
					//se assegno un letto, il degente non è più in attesa, bensì in reparto
					AggiornamentiJooq.getIstanza().degente(codDeg,"posizione", "in Reparto");
				}


			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
		return result;
	}
	
	public int diariaInf(int codice, String codiceDegente, String codiceInfermiere, LocalDate data, LocalTime ora, String noteParticolari, Boolean importante, String farmaco) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
				
				//se il degente scelto non esiste è impossibile aggiungergli una diaria
				if (create.select(Degente.DEGENTE.CODICE).from(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codiceDegente)).fetch().isNotEmpty()) {
					DiariainfRecord diariaInf = new DiariainfRecord(codice, codiceDegente, codiceInfermiere, data, ora, noteParticolari, importante, farmaco);
					result = create.insertInto(Diariainf.DIARIAINF).set(diariaInf).execute();
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int diariaMed(int codice, String codiceDegente, String codiceMedico, String storico, String motivo, String reparto, String farmaci, LocalDate data, LocalTime ora, String allergie) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

				if (create.select(Degente.DEGENTE.CODICE).from(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codiceDegente)).fetch().isNotEmpty()) {
					DiariamedRecord diariaMed = new DiariamedRecord(codice, codiceDegente, codiceMedico, storico, motivo, reparto,farmaci, data, ora, allergie);

					result = create.insertInto(Diariamed.DIARIAMED).set(diariaMed).execute();
					//alla scrittura della diaria medica, il degente viene posto in attesa finchè non gli viene assegnato il letto
					AggiornamentiJooq.getIstanza().degente(codiceDegente, "posizione", "in Attesa");
				}
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static void main(String[] args) {
		
		/*
		getIstanza().degente("D$","Tizio","Test","M",LocalDate.now(), LocalTime.now().withNano(0),"verde");
		getIstanza().personale("m","ADMIN","Medico","M", "m");
		getIstanza().personale("i","ADMIN","Infermiere","I", "i");
		getIstanza().personale("o","ADMIN","Operatore","S", "o");
		getIstanza().degente("D3","Lara","Longhi","F",LocalDate.now(), LocalTime.now().withNano(0),"giallo");
		getIstanza().degente("D2","Jacopo","Bellosi","M",LocalDate.now(), LocalTime.now().withNano(0),"rosso");
		getIstanza().personale("P1","Daniele","Gotti","M", "SpostamiSeCiRiesci");
		getIstanza().personale("P2","Filippo","Bolis","I","HaiGiocatoAdOuterWilds");
		getIstanza().personale("P3","Gabriele","Masinari","S","PileBunker");
		getIstanza().degente("D1","Gabriele","Mazzoleni","M",LocalDate.now(), LocalTime.now().withNano(0),"verde");

		getIstanza().diariaMed(1,"D1","P1","il paziente non soffre di nulla in particolare","Vuole diventare più grosso","Cardiologia","Trembolone",LocalDate.now(),LocalTime.now().withNano(0),"nessun allergia");
		getIstanza().diariaMed(1,"D3","P1","il paziente va messo in attesa","E' super simpatica","Cardiologia","Aspirina",LocalDate.now(),LocalTime.now().withNano(0),"nessun allergia");
		getIstanza().rilevazione(1,"D1",36.8,150,90,100, LocalDate.now(),LocalTime.now().withNano(0),60,5);

		getIstanza().reparto("Re1","Cardiologia");
		getIstanza().modulo("Re1","ModuloA");
		getIstanza().letto("Re1","ModuloA",2);
		getIstanza().letto("Re1","ModuloA",1);
		getIstanza().modulo("Re1","ModuloB");
		getIstanza().letto("Re1","ModuloB",1);
		getIstanza().modulo("Re1","ModuloC");
		getIstanza().letto("Re1","ModuloB",2);
		getIstanza().assegnazioneLetto("D1","Re1","ModuloA",1,LocalDate.now());
		getIstanza().diariaInf(1,"D1","P2",LocalDate.now(),LocalTime.now().withNano(0),"Il paziente è diventato enorme dottore",true,"Trembolone");
		*/

	}

}

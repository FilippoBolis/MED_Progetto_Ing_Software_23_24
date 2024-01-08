package gestore_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import med_db.jooq.generated.tables.Degente;
import med_db.jooq.generated.tables.Diariainf;
import med_db.jooq.generated.tables.Diariamed;
import med_db.jooq.generated.tables.Personale;

public class AggiornamentiJooq {
	//pattern singleton
	private static AggiornamentiJooq istanza=new AggiornamentiJooq();
	
	private AggiornamentiJooq() {};
	
	public static AggiornamentiJooq getIstanza() {
		return istanza;
	}


	public void personale(String ID, String newVal) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				/*nel caso del personale non si può modificare altro che la password, 
				non serve includere un attributo per la selezione */
					DSLContext cambiaPW = DSL.using(conn, SQLDialect.SQLITE);
					int result= cambiaPW.update(Personale.PERSONALE).set(Personale.PERSONALE.PASSWORD, newVal).where(Personale.PERSONALE.CODICE.eq(ID)).execute();
					System.out.println(result);
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void degente(String codice, String attr, String newVal) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext cambiaVal = DSL.using(conn, SQLDialect.SQLITE);
				
				/*in base all'attributo scelto si modifica 
				 * il relativo campo del degente identificato dal codice*/
				switch(attr) {
				case "urgenza":
					if(newVal=="verde" || newVal=="giallo" || newVal=="rosso") {
						int resultU= cambiaVal.update(Degente.DEGENTE).set(Degente.DEGENTE.URGENZA, newVal).where(Degente.DEGENTE.CODICE.eq(codice)).execute();
						System.out.println(resultU);	
					}
					else
						System.out.println("Urgenza richiesta non ammessa");
					
					break;
					
				case "posizione": //deve essere chiamata SOLO all'inserimento di un letto o di una diaria medica
					int resultA= cambiaVal.update(Degente.DEGENTE).set(Degente.DEGENTE.POSIZIONE, newVal).where(Degente.DEGENTE.CODICE.eq(codice)).execute();
					System.out.println(resultA);
					break;
					
				case "sesso":
					if(newVal=="M" || newVal=="F") {
						int resultS= cambiaVal.update(Degente.DEGENTE).set(Degente.DEGENTE.SESSO, newVal).where(Degente.DEGENTE.CODICE.eq(codice)).execute();
						System.out.println(resultS);	
					}
					else
						System.out.println("Sesso del paziente richiesto non ammesso");
					
					break;
					
				default:
					System.out.println("Attributo da modificare selezionato non valido");
					break;
				}
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void diariaInf(String codice ,String codDeg, String newVal) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext cambiaVal = DSL.using(conn, SQLDialect.SQLITE);
				/*l'unico attributo per cui è ammissibile la modifica è il flag d'importanza
				 non è necessario includere una variabile di selezione*/
				int result= cambiaVal.update(Diariainf.DIARIAINF).set(Diariainf.DIARIAINF.IMPORTANTE, Boolean.parseBoolean(newVal)).where(Diariainf.DIARIAINF.CODICE_DEGENTE.eq(codDeg), Diariainf.DIARIAINF.CODICE.eq(codice)).execute();
				System.out.println(result);
				
				
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void diariaMed(String codice ,String codDeg, String attr, String newVal) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext cambiaVal = DSL.using(conn, SQLDialect.SQLITE);
				
				switch(attr) {
				/* è possibile aggiornare diversi attributi su diariaMed,
				 * dunque è necassario un parametro attributo per la selezione
				   per ogni modifica viene aggiornata anche la data e l'ora a quella corrente*/
				
				case "storico":
					int resultS= cambiaVal.update(Diariamed.DIARIAMED).set(Diariamed.DIARIAMED.STORICO, newVal).set(Diariamed.DIARIAMED.DATA, LocalDate.now()).set(Diariamed.DIARIAMED.ORA, LocalTime.now().withNano(0)).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(codDeg), Diariamed.DIARIAMED.CODICE.eq(codice)).execute();
					System.out.println(resultS);
					break;
					
				case "motivo":
					int resultM= cambiaVal.update(Diariamed.DIARIAMED).set(Diariamed.DIARIAMED.MOTIVO, newVal).set(Diariamed.DIARIAMED.DATA, LocalDate.now()).set(Diariamed.DIARIAMED.ORA, LocalTime.now().withNano(0)).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(codDeg), Diariamed.DIARIAMED.CODICE.eq(codice)).execute();
					System.out.println(resultM);
					break;
					
				case "farmaci":
					int resultF= cambiaVal.update(Diariamed.DIARIAMED).set(Diariamed.DIARIAMED.FARMACI, newVal).set(Diariamed.DIARIAMED.DATA, LocalDate.now()).set(Diariamed.DIARIAMED.ORA, LocalTime.now().withNano(0)).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(codDeg), Diariamed.DIARIAMED.CODICE.eq(codice)).execute();
					System.out.println(resultF);
					break;
					
				case "allergie":
					int resultA= cambiaVal.update(Diariamed.DIARIAMED).set(Diariamed.DIARIAMED.ALLERGIE, newVal).set(Diariamed.DIARIAMED.DATA, LocalDate.now()).set(Diariamed.DIARIAMED.ORA, LocalTime.now().withNano(0)).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(codDeg), Diariamed.DIARIAMED.CODICE.eq(codice)).execute();
					System.out.println(resultA);
					break;
					
				default:
					System.out.println("Attributo da modificare selezionato non valido");
					break;
				}
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		//getIstanza().personale("P2", "CaviAreMyLife");
		//getIstanza().degente("D1","posizione","in Reparto");
		//getIstanza().diariaInf("DiariaInf1", "D1", "false");
		//getIstanza().diariaMed("DiariaMed1", "D1", "storico", "Il paziente era diventato gigagrosso");
		//getIstanza().diariaMed("DiariaMed1", "D1", "motivo", "Il paziente deve ridursi un pelo");
		//getIstanza().diariaMed("DiariaMed1", "D1", "farmaci", "riducina");
		//getIstanza().diariaMed("DiariaMed1", "D1", "allergie", "i perditempo");
	}

}

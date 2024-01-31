package gestore_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import med_db.jooq.generated.tables.*;

/**
 * Classe contenente i metodi per gli inserimenti di tuple all'interno dei database,utilizzando JOOQ;
 * ogni metodo rimuove dati dalla tabella omonima.
 */
public class RimozioneJooq {
	//pattern singleton
	private static RimozioneJooq istanza=new RimozioneJooq();
	
	private RimozioneJooq() {}
	
	public static RimozioneJooq getIstanza() {
		return istanza;
	}
	
	/**
	 * @param codice del membro del personale da rimuovere
	 * @return 1 se la rimozione ha avuto successo, 0 se non è andata a buon fine
	 */
	public int personale(String codice) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				result = delete.deleteFrom(Personale.PERSONALE).where(Personale.PERSONALE.CODICE.eq(codice)).execute();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	/**
	 * @param codice del degente che si desidera rimuovere
	 * @return 0 se la rimozione non ha avuto successo, 1+(1 per ogni tabella entità debole associata al degente in cui sono state eseguite rimozioni) se la rimozione è avvenuta con successo
	 */
	public int degente(String codice) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				//cancellazione del singolo degente
				result = delete.deleteFrom(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codice)).execute();
				
				//cancellazione delle entità daboli: diaria med, diaria inf, assLetto e rilevazione
				result+= delete.deleteFrom(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(codice)).execute();
				result+= delete.deleteFrom(Diariainf.DIARIAINF).where(Diariainf.DIARIAINF.CODICE_DEGENTE.eq(codice)).execute();
				result+= delete.deleteFrom(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE.eq(codice)).execute();
				result+= delete.deleteFrom(Rilevazione.RILEVAZIONE).where(Rilevazione.RILEVAZIONE.CODICE_DEGENTE.eq(codice)).execute();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * @param ID della rilevazione che si desidera rimuovere
	 * @param codDeg codice del degente a cui è associata
	 * @return 1 se la rimozione ha avuto successo, 0 se non è andata a buon fine
	 */
	public int rilevazione(int ID, String codDeg) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				result = delete.deleteFrom(Rilevazione.RILEVAZIONE).where(Rilevazione.RILEVAZIONE.ID.eq(ID), Rilevazione.RILEVAZIONE.CODICE_DEGENTE.eq(codDeg)).execute();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * @param codice del reparto che si desidera rimuovere
	 * @return 0 se la rimozione non ha avuto successo, 1+(1 per ogni tabella entità debole associata al reparto in cui sono state eseguite rimozioni, quali modulo, letto e assegnazioneLetto) se la rimozione è avvenuta con successo
	 */
	public int reparto(String codice) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				//cancello il reparto
				result = delete.deleteFrom(Reparto.REPARTO).where(Reparto.REPARTO.CODICE.eq(codice)).execute();
				
				//cancellazione di entità deboli: modulo, letto e assegnazione letto
				result+= delete.deleteFrom(Modulo.MODULO).where(Modulo.MODULO.CODICE_REPARTO.eq(codice)).execute();
				result+= delete.deleteFrom(Letto.LETTO).where(Letto.LETTO.CODICE_REPARTO.eq(codice)).execute();
				result+= delete.deleteFrom(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(codice)).execute();
				//il risultato restituito dalla funzione è utilizzato nelle fasi di testing
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	/**
	 * @param codRep codice del reparto che contiene il modulo
	 * @param nome nome del modulo che si desidera rimuovere
	 * @return 0 se la rimozione non ha avuto successo, 1+(1 per ogni tabella entità debole associata al modulo in cui sono state eseguite rimozioni, quali letto e assegnazioneLetto) se la rimozione è avvenuta con successo
	 */
	public int modulo(String codRep, String nome) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				result = delete.deleteFrom(Modulo.MODULO).where(Modulo.MODULO.CODICE_REPARTO.eq(codRep),Modulo.MODULO.NOME.eq(nome)).execute();
				
				//cancelazione entità deboli: letto e assegnazione letto
				result+= delete.deleteFrom(Letto.LETTO).where(Letto.LETTO.CODICE_REPARTO.eq(codRep),Letto.LETTO.NOME_MODULO.eq(nome)).execute();
				result+= delete.deleteFrom(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO.eq(nome),Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(codRep)).execute();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * @param codRep codice del reparto contenente il letto
	 * @param nomeMod nome del modulo contentente il letto
	 * @param numero del letto che si desidera rimuovere
	 * @return 0 se la rimozione non ha avuto successo, 1+(1 se è stata rimossa un'assegnazioneLetto) se la rimozione è avvenuta con successo
	 */
	public int letto(String codRep, String nomeMod, int numero) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				result = delete.deleteFrom(Letto.LETTO).where(Letto.LETTO.CODICE_REPARTO.eq(codRep), Letto.LETTO.NOME_MODULO.eq(nomeMod), Letto.LETTO.NUMERO.eq(numero)).execute();
				
				//rimozione dell'entità debole: assegnazione letto
				result+= delete.deleteFrom(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(codRep), Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO.eq(nomeMod), Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO.eq(numero)).execute();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * @param codDeg codice del degente assegnato al letto
	 * @param codRep codice del reparto contenente il letto
	 * @param nomeMod nome del modulo contentente il letto
	 * @param numLetto numero del letto
	 * @return 1 se la rimozione ha avuto successo, 0 se non è andata a buon fine
	 */
	public int assegnazioneLetto(String codDeg, String codRep, String nomeMod, int numLetto) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				result = delete.deleteFrom(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE.eq(codDeg) ,Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(codRep), Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO.eq(nomeMod), Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO.eq(numLetto)).execute();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	/**
	 * @param codice della diaria
	 * @param codDeg codice del degente a cui la diaria è associata
	 * @return 1 se la rimozione ha avuto successo, 0 se non è andata a buon fine
	 */
	public int diariaMed(int codice, String codDeg) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				result = delete.deleteFrom(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE.eq(codice), Diariamed.DIARIAMED.CODICE_DEGENTE.eq(codDeg)).execute();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * @param codice della diaria
	 * @param codDeg codice del degente a cui la diaria è associata
	 * @return 1 se la rimozione ha avuto successo, 0 se non è andata a buon fine
	 */
	public int diariaInf(int codice, String codDeg) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				result = delete.deleteFrom(Diariainf.DIARIAINF).where(Diariainf.DIARIAINF.CODICE.eq(codice), Diariainf.DIARIAINF.CODICE_DEGENTE.eq(codDeg)).execute();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	

	public static void main(String[] args) {

	}

}

package gestore_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import med_db.jooq.generated.tables.*;

public class RimozioneJooq {
	//pattern singleton
	private static RimozioneJooq istanza=new RimozioneJooq();
	
	private RimozioneJooq() {}
	
	public static RimozioneJooq getIstanza() {
		return istanza;
	}
	
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

		/*
		getIstanza().assegnazioneLetto("D2","Re2", "ModuloB", 15);
		getIstanza().personale("m");
		getIstanza().personale("i");
		getIstanza().personale("o");
		getIstanza().personale("P2");
		getIstanza().rilevazione(1,"D1");
		getIstanza().degente("D1");
		getIstanza().reparto("R5");
		getIstanza().modulo("Re2","ModuloA");
		getIstanza().modulo("Re1","ModuloA");
		getIstanza().letto("Re1", "ModuloA", 1);
		getIstanza().assegnazioneLetto("D1","Re1", "ModuloA", 1);
		getIstanza().diariaInf(1, "D1");
		getIstanza().diariaMed(1,"D1");
		*/
	}

}

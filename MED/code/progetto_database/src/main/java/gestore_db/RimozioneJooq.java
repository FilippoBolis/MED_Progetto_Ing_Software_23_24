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
	
	public void personale(String codice) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Personale.PERSONALE).where(Personale.PERSONALE.CODICE.eq(codice)).execute();
				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void degente(String codice) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				//cancellazione del singolo degente
				int result = delete.deleteFrom(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codice)).execute();
				
				//cancellazione delle entità daboli: diaria med, diaria inf, assLetto e rilevazione
				int result1= delete.deleteFrom(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(codice)).execute();
				int result2= delete.deleteFrom(Diariainf.DIARIAINF).where(Diariainf.DIARIAINF.CODICE_DEGENTE.eq(codice)).execute();
				int result3= delete.deleteFrom(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE.eq(codice)).execute();
				int result4= delete.deleteFrom(Rilevazione.RILEVAZIONE).where(Rilevazione.RILEVAZIONE.CODICE_DEGENTE.eq(codice)).execute();
				
				System.out.println(result+ " "+ result1+ " "+ result2+ " "+ result3+ " "+ result4);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void rilevazione(String ID, String codDeg) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Rilevazione.RILEVAZIONE).where(Rilevazione.RILEVAZIONE.ID.eq(ID), Rilevazione.RILEVAZIONE.CODICE_DEGENTE.eq(codDeg)).execute();
				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void reparto(String codice) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				//cancello il reparto
				int result = delete.deleteFrom(Reparto.REPARTO).where(Reparto.REPARTO.CODICE.eq(codice)).execute();
				
				//cancellazione di entità deboli: modulo, letto e assegnazione letto
				int result1= delete.deleteFrom(Modulo.MODULO).where(Modulo.MODULO.CODICE_REPARTO.eq(codice)).execute();
				int result2= delete.deleteFrom(Letto.LETTO).where(Letto.LETTO.CODICE_REPARTO.eq(codice)).execute();
				int result3= delete.deleteFrom(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(codice)).execute();
				
				//stampa a video dei risultati delle varie operazioni di rimozione
				System.out.println(result + " "+ result1+ " "+ result2+ " "+ result3);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void modulo(String codRep, String nome) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Modulo.MODULO).where(Modulo.MODULO.CODICE_REPARTO.eq(codRep), Modulo.MODULO.NOME.eq(nome)).execute();
				
				//cancelazione entità deboli: letto e assegnazione letto
				int result1= delete.deleteFrom(Letto.LETTO).where(Letto.LETTO.NOME_MODULO.eq(nome)).execute();
				int result2= delete.deleteFrom(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO.eq(nome)).execute();
				System.out.println(result+ " "+ result1+ " "+ result2);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void letto(String codRep, String nomeMod, int numero) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Letto.LETTO).where(Letto.LETTO.CODICE_REPARTO.eq(codRep), Letto.LETTO.NOME_MODULO.eq(nomeMod), Letto.LETTO.NUMERO.eq(numero)).execute();
				
				//rimozione dell'entità debole: assegnazione letto
				int result1 = delete.deleteFrom(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(codRep), Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO.eq(nomeMod), Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO.eq(numero)).execute();
				
				System.out.println(result+" "+ result1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void assegnazioneLetto(String codDeg, String codRep, String nomeMod, int numLetto) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE.eq(codDeg) ,Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(codRep), Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO.eq(nomeMod), Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO.eq(numLetto)).execute();
				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void diariaMed(String codice, String codDeg) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE.eq(codice), Diariamed.DIARIAMED.CODICE_DEGENTE.eq(codDeg)).execute();
				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void diariaInf(String codice, String codDeg) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				DSLContext delete = DSL.using(conn, SQLDialect.SQLITE);
				int result = delete.deleteFrom(Diariainf.DIARIAINF).where(Diariainf.DIARIAINF.CODICE.eq(codice), Diariainf.DIARIAINF.CODICE_DEGENTE.eq(codDeg)).execute();
				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	

	public static void main(String[] args) {

		//getIstanza().personale("P2");
		//getIstanza().rilevazione("Ri3","D1");
		//getIstanza().degente("D1");
		//getIstanza().reparto("R5");
		//getIstanza().modulo("Re1","ModuloA");
		//getIstanza().letto("Re1", "ModuloA", 1);
		//getIstanza().assegnazioneLetto("D1","Re1", "ModuloA", 1);
		//getIstanza().diariaInf("DiariaInf1", "D1");
		//getIstanza().diariaMed("DiariaMed1","D1");

	}

}

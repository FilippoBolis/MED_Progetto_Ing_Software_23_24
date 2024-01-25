package eseguibile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gui.LoginFrame;
import logiche_bottoni.*;
import med_db.jooq.generated.tables.Reparto;
import modelli.ModelloGestoreLogicaGenerale;

/**
 * Classe che predispone tutti i componenti del programma, attivandoli 
 */
public class GestoreLogicaSetup {
	
	private LoginFrame loginFrame;
	private ModelloGestoreLogicaGenerale mainModelUnit;
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	
	/**
	 * Metodo costruttore che avvia il processo di login e collega tutti i bottoni della GUI alle relative funzionalità logiche
	 * @param m riferimento al modello generale
	 */
	public GestoreLogicaSetup(ModelloGestoreLogicaGenerale m) {
		// prende i riferimenti e avvia tutti i bottoni della GUI
		loginFrame = new LoginFrame();
		mainModelUnit = m;
		//mainFrameUnit = new PazientiFrame(mainModelUnit);
		setupReparti(mainModelUnit);
		new LoginLogic(loginFrame,m);
	}
	
	/**
	 * Metodo utilizzato per impostare i reparti disponibili nel programma, a partire da quelli presenti nel database
	 * @param modello
	 */
	private void setupReparti(ModelloGestoreLogicaGenerale modello) {
		try {
			List<String> nomi = new ArrayList<>();
			Connection conn = DriverManager.getConnection(DB_URLLOGIC);
			if (conn != null) {
				DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
				Result<Record1<String>> reparti = contesto.selectDistinct(Reparto.REPARTO.NOME_REPARTO).from(Reparto.REPARTO).fetch();
				for (Record1<String> repartoRecord : reparti) {
				    nomi.add(repartoRecord.value1());
				}
				modello.modelloGestoreLogistica.setNomiReparti(nomi);
			}
		} catch (SQLException ev) {
			System.out.println(ev.getMessage());
		}
	}
	
}

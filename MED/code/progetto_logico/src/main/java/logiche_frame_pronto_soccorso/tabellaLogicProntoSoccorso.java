package logiche_frame_pronto_soccorso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingUtilities;

import org.jooq.DSLContext;
import org.jooq.Record6;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gui.PazientiFrame;
import med_db.jooq.generated.tables.Degente;
import modelli.modelloLogicaPazienti;

public class tabellaLogicProntoSoccorso{
	private PazientiFrame prontoSoccorso;
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	private modelloLogicaPazienti modello;
	private List<String> nomi = new ArrayList<>();
	private List<String> cognomi = new ArrayList<>();
	private List<String> sesso = new ArrayList<>();
	private List<LocalDate> dateArrivo = new ArrayList<>();
	private List<LocalTime> oreArrivo = new ArrayList<>();
	private List<Integer> urgenza = new ArrayList<>();
	
	public tabellaLogicProntoSoccorso(PazientiFrame p, modelloLogicaPazienti m) {
		prontoSoccorso = p;
		modello = m;
	}
	
	public void update() {
		try {
			Connection conn = DriverManager.getConnection(DB_URLLOGIC);
			if (conn != null) {
				DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
				Result<Record6<String,String,String,LocalDate,LocalTime,Integer>> degenti = contesto.select(Degente.DEGENTE.NOME,Degente.DEGENTE.COGNOME,Degente.DEGENTE.SESSO,Degente.DEGENTE.DATA_ARRIVO,Degente.DEGENTE.ORA_ARRIVO,Degente.DEGENTE.URGENZA).from(Degente.DEGENTE).fetch(); //poi aggiungi la condizione che mette gab
				for (Record6<String, String, String, LocalDate, LocalTime, Integer> degenteRecord : degenti) {
				    nomi.add(degenteRecord.value1());
				    cognomi.add(degenteRecord.value2());
				    sesso.add(degenteRecord.value3());
				    dateArrivo.add(degenteRecord.value4());
				    oreArrivo.add(degenteRecord.value5());
				    urgenza.add(degenteRecord.value6());
				}
				modello.setTableNomi(nomi);
				modello.setTableCognomi(cognomi);
				modello.setTableSesso(sesso);
				modello.setTableDateArrivo(dateArrivo);
				modello.setTableOreArrivo(oreArrivo);
				modello.setTableUrgenza(urgenza);
				SwingUtilities.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	prontoSoccorso.updateViewTabellaProntoSoccorso();
				    }
				});
			}
		} catch (SQLException ev) {
			System.out.println(ev.getMessage());
		}
	}
	
}





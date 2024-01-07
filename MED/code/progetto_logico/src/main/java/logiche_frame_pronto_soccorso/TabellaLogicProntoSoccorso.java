package logiche_frame_pronto_soccorso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import org.jooq.DSLContext;
import org.jooq.Record7;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gui.PazientiFrame;
import med_db.jooq.generated.tables.Degente;
import modelli.ModelloGestoreLogicaGenerale;

public class TabellaLogicProntoSoccorso{
	private PazientiFrame prontoSoccorso;
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	private ModelloGestoreLogicaGenerale modello;
	private List<String> nomi;							//il problema era che le variabili
	private List<String> cognomi;						//erano tutte condivise nel metodo di update
	private List<String> sesso;							//quindi ogni volta che premevi il pulsante
	private List<LocalDate> dateArrivo;					//nonostante fosse in mutua esclusione per i lock
	private List<LocalTime> oreArrivo;					//comunque venivano accumulati i dati nelle liste (sovrapposizione)
	private List<String> urgenza;						//creandoli dentro update ora il problema è risolto
	private List<String> codice;
	
	public TabellaLogicProntoSoccorso(PazientiFrame p, ModelloGestoreLogicaGenerale m) {
		prontoSoccorso = p;
		modello = m;
	}
	
	public void update() {
		if(!prontoSoccorso.updating) {
			try {
				List<String> nomi = new ArrayList<>();
				List<String> codice = new ArrayList<>();
	            List<String> cognomi = new ArrayList<>();
	            List<String> sesso = new ArrayList<>();
	            List<LocalDate> dateArrivo = new ArrayList<>();
	            List<LocalTime> oreArrivo = new ArrayList<>();
	            List<String> urgenza = new ArrayList<>();
				Connection conn = DriverManager.getConnection(DB_URLLOGIC);
				if (conn != null) {
					DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
					Result<Record7<String,String,String,LocalDate,LocalTime,String,String>> degenti = contesto.select(Degente.DEGENTE.NOME,Degente.DEGENTE.COGNOME,Degente.DEGENTE.SESSO,Degente.DEGENTE.DATA_ARRIVO,Degente.DEGENTE.ORA_ARRIVO,Degente.DEGENTE.URGENZA,Degente.DEGENTE.CODICE).from(Degente.DEGENTE).where(Degente.DEGENTE.POSIZIONE.eq("in Pronto Soccorso")).fetch();
					for (Record7<String, String, String, LocalDate, LocalTime, String,String> degenteRecord : degenti) {
					    nomi.add(degenteRecord.value1());
					    cognomi.add(degenteRecord.value2());
					    sesso.add(degenteRecord.value3());
					    dateArrivo.add(degenteRecord.value4());
					    oreArrivo.add(degenteRecord.value5());
					    urgenza.add(degenteRecord.value6());
					    codice.add(degenteRecord.value7());
					}
					modello.modelloGestoreTabella.setTableNomi(nomi);
					modello.modelloGestoreTabella.setTableCognomi(cognomi);
					modello.modelloGestoreTabella.setTableSesso(sesso);
					modello.modelloGestoreTabella.setTableDateArrivo(dateArrivo);
					modello.modelloGestoreTabella.setTableOreArrivo(oreArrivo);
					modello.modelloGestoreTabella.setTableUrgenza(urgenza);
					modello.modelloGestoreTabella.setTableCodice(codice);
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
	
}





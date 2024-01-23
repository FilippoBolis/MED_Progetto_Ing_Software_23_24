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
import org.jooq.Record9;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gui.VisualizzaRilevazioniFrame;
import med_db.jooq.generated.tables.Rilevazione;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaDelleRilevazioniTabella{
	
	VisualizzaRilevazioniFrame frameDelleRilevazioni;
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	private ModelloGestoreLogicaGenerale modello;
	
	public LogicaDelleRilevazioniTabella(VisualizzaRilevazioniFrame v, ModelloGestoreLogicaGenerale m) {
		frameDelleRilevazioni = v;
		modello = m;
		update();
	}
	
	public void update() {
		if(!frameDelleRilevazioni.updating) {
			try {
				List<String> codicePersonale = new ArrayList<>();
				List<Integer> glicemia = new ArrayList<>();
				List<Double> temperatura = new ArrayList<>();
				List<Integer> pressioneMax = new ArrayList<>();
				List<Integer> pressioneMin = new ArrayList<>();
				List<Integer> frequenza = new ArrayList<>();
				List<Integer> dolore = new ArrayList<>();
				List<LocalDate> dataCreazione = new ArrayList<>();
				List<LocalTime> oreCreazione = new ArrayList<>();
				String codiceDegente = modello.modelloGestorePaziente.getCodice();
				Connection conn = DriverManager.getConnection(DB_URLLOGIC);
				if (conn != null) {
					DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
					if (contesto.select(Rilevazione.RILEVAZIONE.ID).from(Rilevazione.RILEVAZIONE).where(Rilevazione.RILEVAZIONE.CODICE_DEGENTE.eq(codiceDegente)).fetch().isNotEmpty()) {
						Result<Record9<String, Integer, Double, Integer, Integer, Integer, Integer, LocalDate, LocalTime>> rilevazioni = contesto.selectDistinct(Rilevazione.RILEVAZIONE.CODICE_DEGENTE,Rilevazione.RILEVAZIONE.GLICEMIA,Rilevazione.RILEVAZIONE.TEMPERATURA,Rilevazione.RILEVAZIONE.PRESSIONE_MAX,Rilevazione.RILEVAZIONE.PRESSIONE_MIN, Rilevazione.RILEVAZIONE.FREQ_CARD, Rilevazione.RILEVAZIONE.DOLORE, Rilevazione.RILEVAZIONE.DATA,Rilevazione.RILEVAZIONE.ORA).from(Rilevazione.RILEVAZIONE).where(Rilevazione.RILEVAZIONE.CODICE_DEGENTE.eq(codiceDegente)).fetch();
						for (Record9<String, Integer, Double, Integer, Integer, Integer, Integer, LocalDate, LocalTime> RilevazioneRecord : rilevazioni) {
							codicePersonale.add(RilevazioneRecord.value1());
							glicemia.add(RilevazioneRecord.value2());
							temperatura.add(RilevazioneRecord.value3());
							pressioneMax.add(RilevazioneRecord.value4());
							pressioneMin.add(RilevazioneRecord.value5());
							frequenza.add(RilevazioneRecord.value6());
							dolore.add(RilevazioneRecord.value7());
						    dataCreazione.add(RilevazioneRecord.value8());
						    oreCreazione.add(RilevazioneRecord.value9());
						}
						
					}
					modello.modelloGestoreRilevazioni.setTableCodicePersonale(codicePersonale);
					modello.modelloGestoreRilevazioni.setTableDateArrivo(dataCreazione);
					modello.modelloGestoreRilevazioni.setTableDolore(dolore);
					modello.modelloGestoreRilevazioni.setTableFrequenza(frequenza);
					modello.modelloGestoreRilevazioni.setTableGlicemia(glicemia);
					modello.modelloGestoreRilevazioni.setTableOreArrivo(oreCreazione);
					modello.modelloGestoreRilevazioni.setTablePressioneMax(pressioneMax);
					modello.modelloGestoreRilevazioni.setTablePressioneMin(pressioneMin);
					modello.modelloGestoreRilevazioni.setTableTemperatura(temperatura);;
					SwingUtilities.invokeLater(new Runnable() {
					    @Override
					    public void run() {
					    	frameDelleRilevazioni.updateViewTabella();
					    }
					});
				}
			} catch (SQLException ev) {
				System.out.println(ev.getMessage());
			}
		}
	}
	
}





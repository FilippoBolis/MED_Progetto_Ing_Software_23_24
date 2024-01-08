package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import med_db.jooq.generated.tables.Degente;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneFiltroNomeCognome {
	
	private PazientiFrame frameDeiPazienti;
	private ModelloGestoreLogicaGenerale modello;
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	private String[] sezioni;
	private String valore1;
	private String valore2;
	private LogicaDellaPosizionePazienteTabella tabellaDeiPazienti;
	
	public LogicaBottoneFiltroNomeCognome(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		// prede i refs
		frameDeiPazienti = v2;
		modello = m;
		start();
	}
	
	private void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.cercaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			try {
				Connection conn = DriverManager.getConnection(DB_URLLOGIC);
				List<String> nomi = new ArrayList<>();
				List<String> codice = new ArrayList<>();
	            List<String> cognomi = new ArrayList<>();
	            List<String> sesso = new ArrayList<>();
	            List<LocalDate> dateArrivo = new ArrayList<>();
	            List<LocalTime> oreArrivo = new ArrayList<>();
	            List<String> urgenza = new ArrayList<>();
				if (conn != null) {								//ipotizzio che un paziente abbia un nome e un cognome, quelli con il doppio nome putroppo si dovrà cercare per cognome, stessa cosa per le persone con il doppio cognome che si dovrà cercare per nome
				DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
				if(!frameDeiPazienti.cercaTextField.getText().isEmpty()) {
					sezioni = frameDeiPazienti.cercaTextField.getText().split(" ");
					if (sezioni.length >= 2) {
						valore1 = sezioni[0];
						valore2 = sezioni[1];
						Result<Record7<String,String,String,LocalDate,LocalTime,String,String>> degenti = contesto.select(Degente.DEGENTE.NOME,Degente.DEGENTE.COGNOME,Degente.DEGENTE.SESSO,Degente.DEGENTE.DATA_ARRIVO,Degente.DEGENTE.ORA_ARRIVO,Degente.DEGENTE.URGENZA,Degente.DEGENTE.CODICE).from(Degente.DEGENTE).where(((Degente.DEGENTE.NOME.equalIgnoreCase(valore1).and(Degente.DEGENTE.COGNOME.equalIgnoreCase(valore2))).or((Degente.DEGENTE.COGNOME.equalIgnoreCase(valore1).and(Degente.DEGENTE.NOME.equalIgnoreCase(valore2))))).and(Degente.DEGENTE.POSIZIONE.equalIgnoreCase(frameDeiPazienti.posizioneAttuale))).fetch();
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
					}
					else {
						valore1 = sezioni[0];
						Result<Record7<String,String,String,LocalDate,LocalTime,String,String>> degenti = contesto.select(Degente.DEGENTE.NOME,Degente.DEGENTE.COGNOME,Degente.DEGENTE.SESSO,Degente.DEGENTE.DATA_ARRIVO,Degente.DEGENTE.ORA_ARRIVO,Degente.DEGENTE.URGENZA,Degente.DEGENTE.CODICE).from(Degente.DEGENTE).where(((Degente.DEGENTE.NOME.equalIgnoreCase(valore1).or(Degente.DEGENTE.COGNOME.equalIgnoreCase(valore1)))).and(Degente.DEGENTE.POSIZIONE.equalIgnoreCase(frameDeiPazienti.posizioneAttuale))).fetch();
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
					}
				}
				else {
					tabellaDeiPazienti = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti, modello, frameDeiPazienti.posizioneAttuale);
					tabellaDeiPazienti.update();
				}
				frameDeiPazienti.urgenzaComboBox.setSelectedItem(" ");
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						frameDeiPazienti.updateViewTabella();
					}
				});
			}
			} catch (SQLException ev) {
				System.out.println(ev.getMessage());
			}	
			}
		});
	}
}

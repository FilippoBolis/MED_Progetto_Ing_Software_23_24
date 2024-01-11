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
import org.jooq.Record10;
import org.jooq.Record7;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import med_db.jooq.generated.tables.Assegnazioneletto;
import med_db.jooq.generated.tables.Degente;
import med_db.jooq.generated.tables.Modulo;
import med_db.jooq.generated.tables.Reparto;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneFiltroNomeCognome extends LogicaBottone{
	
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	private String[] sezioni;
	private String valore1;
	private String valore2;
	private LogicaDellaPosizionePazienteTabella tabellaDeiPazienti;
	
	public LogicaBottoneFiltroNomeCognome(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	protected void start() {
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
	            List<String> reparto = new ArrayList<>();
	            List<String> modulo = new ArrayList<>();
	            List<Integer> letto = new ArrayList<>();
	            modello.modelloGestorePaziente.deselezionaPaziente();
				frameDeiPazienti.updateStringaPaziente();
				if (conn != null) {								//ipotizzio che un paziente abbia un nome e un cognome, quelli con il doppio nome putroppo si dovrà cercare per cognome, stessa cosa per le persone con il doppio cognome che si dovrà cercare per nome
				DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
				if(!frameDeiPazienti.cercaTextField.getText().isEmpty()) {
					sezioni = frameDeiPazienti.cercaTextField.getText().split(" ");
					if (sezioni.length >= 2) {
						valore1 = sezioni[0];
						valore2 = sezioni[1];
						if (contesto.select(Degente.DEGENTE.CODICE).from(Degente.DEGENTE,Assegnazioneletto.ASSEGNAZIONELETTO).where(Degente.DEGENTE.POSIZIONE.eq(frameDeiPazienti.posizioneAttuale),Degente.DEGENTE.CODICE.eq(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE)).fetch().isNotEmpty()) {
							Result<Record10<String,String,String,LocalDate,LocalTime,String,String,String,String,Integer>> degenti = contesto.selectDistinct(Degente.DEGENTE.NOME,Degente.DEGENTE.COGNOME,Degente.DEGENTE.SESSO,Degente.DEGENTE.DATA_ARRIVO,Degente.DEGENTE.ORA_ARRIVO,Degente.DEGENTE.URGENZA,Degente.DEGENTE.CODICE,Reparto.REPARTO.NOME_REPARTO,Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO,Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO).from(Degente.DEGENTE,Assegnazioneletto.ASSEGNAZIONELETTO,Reparto.REPARTO).where(((Degente.DEGENTE.NOME.equalIgnoreCase(valore1).and(Degente.DEGENTE.COGNOME.equalIgnoreCase(valore2))).or((Degente.DEGENTE.COGNOME.equalIgnoreCase(valore1).and(Degente.DEGENTE.NOME.equalIgnoreCase(valore2))))).and(Degente.DEGENTE.POSIZIONE.eq(frameDeiPazienti.posizioneAttuale)).and(Degente.DEGENTE.CODICE.eq(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE)).and(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(Reparto.REPARTO.CODICE))).fetch();
							for (Record10<String, String, String, LocalDate, LocalTime, String,String,String,String,Integer> degenteRecord : degenti) {
							    nomi.add(degenteRecord.value1());
							    cognomi.add(degenteRecord.value2());
							    sesso.add(degenteRecord.value3());
							    dateArrivo.add(degenteRecord.value4());
							    oreArrivo.add(degenteRecord.value5());
							    urgenza.add(degenteRecord.value6());
							    codice.add(degenteRecord.value7());
							    reparto.add(degenteRecord.value8());
							    modulo.add(degenteRecord.value9());
							    letto.add(degenteRecord.value10());
							}
						}
						else {
							Result<Record7<String,String,String,LocalDate,LocalTime,String,String>> degenti = contesto.selectDistinct(Degente.DEGENTE.NOME,Degente.DEGENTE.COGNOME,Degente.DEGENTE.SESSO,Degente.DEGENTE.DATA_ARRIVO,Degente.DEGENTE.ORA_ARRIVO,Degente.DEGENTE.URGENZA,Degente.DEGENTE.CODICE).from(Degente.DEGENTE).where(((Degente.DEGENTE.NOME.equalIgnoreCase(valore1).and(Degente.DEGENTE.COGNOME.equalIgnoreCase(valore2))).or((Degente.DEGENTE.COGNOME.equalIgnoreCase(valore1).and(Degente.DEGENTE.NOME.equalIgnoreCase(valore2)))))).fetch();
							for (Record7<String, String, String, LocalDate, LocalTime, String,String> degenteRecord : degenti) {
							    nomi.add(degenteRecord.value1());
							    cognomi.add(degenteRecord.value2());
							    sesso.add(degenteRecord.value3());
							    dateArrivo.add(degenteRecord.value4());
							    oreArrivo.add(degenteRecord.value5());
								urgenza.add(degenteRecord.value6());
							    codice.add(degenteRecord.value7());
							    modulo.add("Nessun modulo");
							    reparto.add("Nessun reparto");
							    letto.add(0);
								}
						}
					}
					else {
						valore1 = sezioni[0];
						if (contesto.select(Degente.DEGENTE.CODICE).from(Degente.DEGENTE,Assegnazioneletto.ASSEGNAZIONELETTO).where(Degente.DEGENTE.POSIZIONE.eq(frameDeiPazienti.posizioneAttuale),Degente.DEGENTE.CODICE.eq(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE)).fetch().isNotEmpty()) {
							Result<Record10<String,String,String,LocalDate,LocalTime,String,String,String,String,Integer>> degenti = contesto.select(Degente.DEGENTE.NOME,Degente.DEGENTE.COGNOME,Degente.DEGENTE.SESSO,Degente.DEGENTE.DATA_ARRIVO,Degente.DEGENTE.ORA_ARRIVO,Degente.DEGENTE.URGENZA,Degente.DEGENTE.CODICE,Reparto.REPARTO.NOME_REPARTO,Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO,Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO).from(Degente.DEGENTE,Reparto.REPARTO,Assegnazioneletto.ASSEGNAZIONELETTO).where(((Degente.DEGENTE.NOME.equalIgnoreCase(valore1).or(Degente.DEGENTE.COGNOME.equalIgnoreCase(valore1)))).and(Degente.DEGENTE.POSIZIONE.eq(frameDeiPazienti.posizioneAttuale)).and(Degente.DEGENTE.CODICE.eq(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE)).and(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(Reparto.REPARTO.CODICE))).fetch();
							for (Record10<String, String, String, LocalDate, LocalTime, String,String,String,String,Integer> degenteRecord : degenti) {
							    nomi.add(degenteRecord.value1());
							    cognomi.add(degenteRecord.value2());
							    sesso.add(degenteRecord.value3());
							    dateArrivo.add(degenteRecord.value4());
							    oreArrivo.add(degenteRecord.value5());
								urgenza.add(degenteRecord.value6());
							    codice.add(degenteRecord.value7());
							    reparto.add(degenteRecord.value8());
							    modulo.add(degenteRecord.value9());
							    letto.add(degenteRecord.value10());
							}
						}
						else {
							Result<Record7<String,String,String,LocalDate,LocalTime,String,String>> degenti = contesto.select(Degente.DEGENTE.NOME,Degente.DEGENTE.COGNOME,Degente.DEGENTE.SESSO,Degente.DEGENTE.DATA_ARRIVO,Degente.DEGENTE.ORA_ARRIVO,Degente.DEGENTE.URGENZA,Degente.DEGENTE.CODICE).from(Degente.DEGENTE).where(((Degente.DEGENTE.NOME.equalIgnoreCase(valore1).or(Degente.DEGENTE.COGNOME.equalIgnoreCase(valore1)))).and(Degente.DEGENTE.POSIZIONE.equalIgnoreCase(frameDeiPazienti.posizioneAttuale))).fetch();
							for (Record7<String, String, String, LocalDate, LocalTime, String,String> degenteRecord : degenti) {
							    nomi.add(degenteRecord.value1());
							    cognomi.add(degenteRecord.value2());
							    sesso.add(degenteRecord.value3());
							    dateArrivo.add(degenteRecord.value4());
							    oreArrivo.add(degenteRecord.value5());
								urgenza.add(degenteRecord.value6());
							    codice.add(degenteRecord.value7());
							    modulo.add("Nessun modulo");
							    reparto.add("Nessun reparto");
							    letto.add(0);
							}
						}
						
					}
					modello.modelloGestoreTabella.setTableNomi(nomi);
					modello.modelloGestoreTabella.setTableCognomi(cognomi);
					modello.modelloGestoreTabella.setTableSesso(sesso);
					modello.modelloGestoreTabella.setTableDateArrivo(dateArrivo);
					modello.modelloGestoreTabella.setTableOreArrivo(oreArrivo);
					modello.modelloGestoreTabella.setTableUrgenza(urgenza);
					modello.modelloGestoreTabella.setTableCodice(codice);
					modello.modelloGestoreTabella.setTableReparto(reparto);
					modello.modelloGestoreTabella.setTableModulo(modulo);
					modello.modelloGestoreTabella.setNumeroLetto(letto);
				}
				else {
					tabellaDeiPazienti = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti, modello, frameDeiPazienti.posizioneAttuale);
					tabellaDeiPazienti.update();
				}
				// non so perchè danno problemi ste cose sotto (se cambi il paziente mentre è attivo un altro filtro non lo cambia, devi rifarlo dopo è come se facesse un clear ma nell'if ci entra non so)
				frameDeiPazienti.urgenzaComboBox.setSelectedItem(" ");
				frameDeiPazienti.repartoComboBox.setSelectedItem(" ");
				// non so perchè danno problemi le cose sopra
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
